package com.rxh.blog.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.rxh.blog.Utiles.TreeVO;
import com.rxh.blog.entity.Comment;
import com.rxh.blog.mapper.TreeVOMapper;
import com.rxh.blog.service.CommentService;
import com.rxh.blog.service.TreeVOService;
import com.rxh.complat.common.shiro.entity.Member;
import com.rxh.complat.common.util.JsonResult;
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

    @RequestMapping("test3")
    public Object test3(String size, String curPage) {
//        List<Comment> comments = commentService.queryAllByLimit(size, curPage);
        PageInfo replay = commentService.findReplay(size, curPage);
        return replay;
    }

    @RequestMapping("test4")
    public Object test4(String size, String curPage) {
        PageInfo page = treeVOService.findPage(size, curPage);
        return page;
    }

    @RequestMapping("test5")
    public Object test5(String size, String curPage) {
        Page<Comment> page = treeVOService.findPlusPage(size, curPage);
        return page;
    }
    /**
     * 分页查询所有数据
     *
     * @param size 分页数量
     * @param curPage 当前页码
     * @return 所有数据
     */
    @GetMapping
    public Object selectAll(String size, String curPage) {
        PageInfo replay = commentService.findReplay(size, curPage);
        return replay;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne( String id) {
        return success(this.commentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param comment 实体对象
     * @return 新增结果
     */
    @PostMapping
    public Object insert(Comment comment) {
        Member user = SessionUtils.getUser();
        comment.setUserId(user.getId());
        comment.setUserName(user.getNickname());
        boolean save = this.commentService.save(comment);
        JsonResult<Object> result = new JsonResult<>();
        if(save){
            result.setMsg("保存成功");
        }else{
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
    public R update(@RequestBody Comment comment) {
        return success(this.commentService.updateById(comment));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.commentService.removeByIds(idList));
    }
}