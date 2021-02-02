package com.rxh.blog.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rxh.blog.entity.Article;
import com.rxh.blog.entity.Collection;
import com.rxh.blog.entity.SetArticleLabel;
import com.rxh.blog.entity.SetArticleSort;
import com.rxh.blog.service.ArticleService;
import com.rxh.blog.service.CollectionService;
import com.rxh.blog.service.SetArticleLabelService;
import com.rxh.blog.service.SetArticleSortService;
import com.rxh.complat.common.shiro.entity.Member;
import com.rxh.complat.common.util.JsonResult;
import com.rxh.complat.common.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 发布号作者表(Article)表控制层
 *
 * @author zyh
 * @Date 2021-01-14 11:18:58
 */
@RestController
@RequestMapping("article")
public class ArticleController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ArticleService articleService;
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private SetArticleLabelService articleLabelService;
    @Autowired
    private SetArticleSortService articleSortService;

    @RequestMapping("test")
    public Object test(String id) {
        return articleService.queryById(id);
    }

    /**
     * 分页查询所有数据
     *
     * @param size 分页数量
     * @param curPage 当前页码
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(String size, String curPage) {

        Page<Article> page = new Page<>();
        page.setSize(Integer.parseInt(size));
        page.setCurrent(Integer.parseInt(curPage));
//        Page<Article> page1 = this.articleService.page(page);
//        return success(this.articleService.page(page));
        Page page1 = articleService.selectPage(page);
        return success(page1);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable String id) {
        Article article = this.articleService.queryById(id);
        return success(article);
    }

    /**
     * 新增数据
     *
     * @param article 实体对象
     * @return 新增结果
     */
    @PostMapping
    public JsonResult<Object> insert(Article article, String labelArr, String categoryArr) {
        JsonResult<Object> result = new JsonResult<>();

        Member user = SessionUtils.getUser();
        article.setAuthor(user.getNickname());
        article.setAuthorId(user.getId());
        article.setContent(article.getContent());

        boolean save = this.articleService.save(article);

        setLabelAndSort(article, labelArr, categoryArr);

        if (save) {
            result.success("Save Success!");
            result.addParam("url", "/blog/addSuccess");
            result.addParam("id", article.getId());
        } else {
            result.error("保存失败");
            result.addParam("url", "/404");
            result.addParam("key", "ceshishuju ");
        }
        return result;
    }

    /**
     * @Description 添加标签, 文章分类中间表
     * @author Zhang YuHui
     * @date 2021/2/2
     *
     * @param article
     * @param labelArr
     * @param categoryArr
     * @return void
     */
    private void setLabelAndSort(Article article, String labelArr, String categoryArr) {
        ArrayList<SetArticleLabel> label_arr = new ArrayList<>();
        ArrayList<SetArticleSort> sort_arr = new ArrayList<>();
        String[] labels = labelArr.split(",");
        String[] categories = categoryArr.split(",");
        if (StringUtils.isNotBlank(labelArr)) {
            for (String label : labels) {
                SetArticleLabel setArticleLabel = new SetArticleLabel();
                setArticleLabel.setArticleId(article.getId());
                setArticleLabel.setLabelId(label);
                label_arr.add(setArticleLabel);
            }
            articleLabelService.saveBatch(label_arr);
        }

        if (StringUtils.isNotBlank(categoryArr)) {
            for (String category : categories) {
                SetArticleSort setArticleSort = new SetArticleSort();
                setArticleSort.setArticleId(article.getId());
                setArticleSort.setSortId(category);
                sort_arr.add(setArticleSort);
            }
            articleSortService.saveBatch(sort_arr);
        }

    }

    /**
     * 修改数据
     *
     * @param article 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Article article) {

        return success(this.articleService.updateById(article));
    }

    @RequestMapping("update")
    public R das(Article article, String author) {
        int i = Integer.parseInt(article.getCollection()) + 1;
        article.setCollection(i + "");
        Collection collection = new Collection();
        collection.setArticleId(article.getId());
        collection.setArticleAuthorId(author);
        Member user = SessionUtils.getUser();
        collection.setUserId(user.getId());
        collection.setUserName(user.getNickname());
        boolean save = collectionService.save(collection);


        return success(this.articleService.updateById(article));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.articleService.removeByIds(idList));
    }

    @RequestMapping("setTop/{id}")
    public JsonResult setTop(@PathVariable String id) {
        JsonResult<Object> result = new JsonResult<>();
        boolean b = articleService.setTop(id);
        result.code(200);
        result.setMsg(b ? "置顶成功" : "置顶失败");
        return result;
    }
}