package com.rxh.blog.controller;


import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.github.pagehelper.PageInfo;
import com.rxh.blog.Utiles.TreeVO;
import com.rxh.blog.entity.Comment;
import com.rxh.blog.entity.QuickReview;
import com.rxh.blog.mapper.TreeVOMapper;
import com.rxh.blog.service.CommentService;
import com.rxh.blog.service.QuickReviewService;
import com.rxh.blog.service.TreeVOService;
import com.rxh.complat.common.shiro.entity.Member;
import com.rxh.complat.common.util.JsonResult;
import com.rxh.complat.common.util.RedisUtil;
import com.rxh.complat.common.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章评论表(Comment)表控制层
 *
 * @author zyh
 * @Date 2021-01-19 15:47:22
 */
@RestController
@RequestMapping("comment")
public class CommentController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CommentService commentService;
    @Autowired
    TreeVOMapper treeVOMapper;
    @Autowired
    TreeVOService treeVOService;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    QuickReviewService quickReviewService;

    @RequestMapping("test")
    public Object s() {
        List<TreeVO> treeVOS = treeVOMapper.selectAllTree();
        return treeVOS;
    }

    @RequestMapping("test1")
    public Object test1() {
        List<Comment> treeVOS = treeVOMapper.findAllComment();
        return treeVOS;
    }

    @RequestMapping("test2")
    public Object test2() {
        List<Comment> treeVOS = treeVOMapper.findReplay();
        return treeVOS;
    }



    @RequestMapping("test4")
    public Object test4(String size, String curPage) {
        PageInfo page = treeVOService.findPage(size, curPage);
        return page;
    }

    @RequestMapping("test5")
    public boolean test5(String id) {
        return treeVOService.updataId(id);
    }

    /**
     * 分页查询所有数据
     *
     * @param size    分页数量
     * @param curPage 当前页码
     * @return 所有数据
     */
    @GetMapping
    public Object selectAll(String size, String curPage,String id) {
        PageInfo replay = commentService.findReplay(size, curPage,id);
        return replay;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(String id) {
        return success(this.commentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param comment 实体对象
     * @return 新增结果
     */
    @PostMapping
    public Object insert(Comment comment, String replay) {
        Member user = SessionUtils.getUser();
        comment.setUserId(user.getId());
        comment.setUserName(user.getNickname());
        boolean save = this.commentService.save(comment);
        JsonResult<Object> result = new JsonResult<>();
        if (save) {
            result.setMsg("保存成功");
        } else {
            result.setMsg("保存失败");
        }

        return result;
    }

    /**
     * 修改数据
     *
     * @param comment 实体对象
     * @return 修改结果
     */
    @PutMapping
    public JsonResult update(Comment comment) {
        boolean update = this.commentService.update(comment, new LambdaQueryWrapper<>());
        JsonResult<Object> result = new JsonResult<>();
        if (update) {
            result.message("success");
        } else {
            result.message("error");
        }
        return result;
    }

    /**
     * 删除数据
     *
     * @param id 主键结合
     * @return 删除结果
     */
    @RequestMapping("del")
    public JsonResult as(String id) {
        boolean b = commentService.deleteLogic(id);
        JsonResult<Object> result = new JsonResult<>();
        if (b) {
            result.message("success");
        } else {
            result.message("error");
        }
        return result;
    }


    /**
     * @param
     * @return com.rxh.complat.common.util.JsonResult
     * @Description 速评内容
     * @author Zhang YuHui
     * @date 2021/1/26
     */
    @GetMapping("quickReview")
    public JsonResult quickReview() {
        JsonResult<Object> result = new JsonResult<>();

        boolean hasKey = redisUtil.hasKey("quickReview");
        List<QuickReview> list = null;
        if (hasKey) {
            String quickReview = redisUtil.get("quickReview");
            list = JSONArray.parseArray(quickReview, QuickReview.class);
        } else {
            list = quickReviewService.list();
            redisUtil.set("quickReview", list);
        }
        int round = (int) Math.round(Math.random() * list.size() - 1);
        result.addParam("review", list.get(round));
        result.success("查询成功!");
        return result;
    }

    /**
     * @param quickReview
     * @return com.rxh.complat.common.util.JsonResult
     * @Description 后台添加速评
     * @author Zhang YuHui
     * @date 2021/1/26
     */
    @PostMapping("quickReview")
    public JsonResult saveQuickReview(QuickReview quickReview) {
        JsonResult<Object> result = new JsonResult<>();
        boolean save = quickReviewService.save(quickReview);
        if (save) {
            result.message("保存成功");
        } else {
            result.message("保存失败");
        }
        return result;
    }
}