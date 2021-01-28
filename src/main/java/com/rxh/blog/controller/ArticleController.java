package com.rxh.blog.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rxh.blog.entity.Article;
import com.rxh.blog.service.ArticleService;
import com.rxh.complat.common.shiro.entity.Member;
import com.rxh.complat.common.util.JsonResult;
import com.rxh.complat.common.util.SessionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.time.LocalDateTime;
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
    public R selectOne(@PathVariable Serializable id) {
        Article byId = this.articleService.getById(id);
        LocalDateTime createTime = byId.getCreateTime();
        return success(this.articleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param article 实体对象
     * @return 新增结果
     */
    @PostMapping
    public JsonResult<Object> insert(Article article) {
        JsonResult<Object> result = new JsonResult<>();

        Member user = SessionUtils.getUser();
        article.setAuthor(user.getNickname());
        article.setAuthorId(user.getId());
        article.setContent(article.getContent());

        String abstractTxt = article.getAbstractTxt();
        boolean blank = StringUtils.isBlank(abstractTxt);
        if (blank) {

        }

        boolean save = this.articleService.save(article);
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
     * 修改数据
     *
     * @param article 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Article article) {
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
    public JsonResult setTop(@PathVariable String id){
        JsonResult<Object> result = new JsonResult<>();
        boolean b = articleService.setTop(id);
        result.code(200);
        result.setMsg(b? "置顶成功" : "置顶失败");
        return result;
    }
}