package com.rxh.onlineStore.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rxh.onlineStore.entity.SysUser;
import com.rxh.onlineStore.mapper.LineUserMapper;
import com.rxh.onlineStore.service.LineUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 运营后台用户表(Member)表控制层
 *
 * @author zyh
 * @Date 2021-01-06 14:39:53
 */
@RestController
@RequestMapping("lineSysUser")
public class LineSysUserController  {
    /**
     * 服务对象
     */
    @Resource
    private LineUserService lineUserService;

    /**
     * 分页查询所有数据
     *
     * @param size 分页数量
     * @param curPage 当前页
     * @return 所有数据
     */

    @GetMapping
    public Object selectAll(String size,String curPage) {
//        Page<Member> page = new Page<>();
//        page.setSize(Integer.parseInt(size));
//        page.setCurrent(Integer.parseInt(curPage));
        PageHelper.startPage(Integer.parseInt(curPage),Integer.parseInt(size));
        List<SysUser> list = lineUserService.findAll(Integer.parseInt(curPage),Integer.parseInt(size));
        PageInfo<SysUser> page1 = PageInfo.of(list);

//        Page<Member> page1 = this.lineUserService.page(page,null);
        return page1;
    }

//    /**/     * 通过主键查询单条数据
////     *
////     * @param id 主键
////     * @return 单条数据
////     */
////    @GetMapping("{id}")
////    public Object selectOne(@PathVariable Serializable id) {
////        return this.lineUserService.getById(id);
////    }
////
////    /**
////     * 新增数据
////     *
////     * @param sysUser 实体对象
////     * @return 新增结果
////     */
////    @PostMapping
////    public Object insert(@RequestBody Member sysUser) {
////        return this.lineUserService.save(sysUser);
////    }



}