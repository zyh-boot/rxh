package com.rxh.blog.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rxh.blog.entity.MessageBoard;
import com.rxh.blog.service.MessageBoardService;
import com.rxh.complat.common.shiro.entity.Member;
import com.rxh.complat.common.util.JsonResult;
import com.rxh.complat.common.util.SessionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 留言板(MessageBoard)表控制层
 *
 * @author zyh
 * @since 2021-02-10 12:23:13
 */
@RestController
@RequestMapping("messageBoard")
public class MessageBoardController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private MessageBoardService messageBoardService;

    /**
     * 分页查询所有数据
     *
     * @param size 分页数量
     * @param curPage 当前页码
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(String size, String curPage) {
        size = StringUtils.isNotBlank(size) ? size : "10";
        curPage = StringUtils.isNotBlank(curPage) ? curPage : "1";
        Page<MessageBoard> page = new Page<>();
        page.setSize(Integer.parseInt(size));
        page.setCurrent(Integer.parseInt(curPage));

        return success(this.messageBoardService.page(page));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.messageBoardService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param messageBoard 实体对象
     * @return 新增结果
     */
    @PostMapping
    public JsonResult<Object> insert(MessageBoard messageBoard) {
        Member user = SessionUtils.getUser();
        messageBoard.setUserId(user.getId());
        messageBoard.setUserName(user.getNickname());
        boolean save = this.messageBoardService.save(messageBoard);
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
     * @param messageBoard 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(MessageBoard messageBoard) {
        return success(this.messageBoardService.updateById(messageBoard));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.messageBoardService.removeByIds(idList));
    }

    /**
     * @Description 逻辑删除留言
     * @author Zhang YuHui
     * @date 2021/2/26
     *
     * @param id 留言ID
     * @return com.rxh.complat.common.util.JsonResult
     */
    @RequestMapping("delBoard")
    public JsonResult deleteBoard(String id){
        boolean b = this.messageBoardService.deleteLogic(id);
        JsonResult<Object> result = new JsonResult<>();
        if (b) {
            result.setMsg("评论已删除");
        } else {
            result.setMsg("系统错误, 删除失败");
        }
        return result;
    }
}