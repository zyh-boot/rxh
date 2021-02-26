package com.rxh.backstage;

import com.alibaba.fastjson.JSONObject;
import com.rxh.blog.entity.Labels;
import com.rxh.blog.service.LabelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description 数据表格
 * @author Zhang YuHui
 * @date 2021/2/23 11:19
 */
@RestController
@RequestMapping("table")
public class TableDataController {

    @Autowired
    LabelsService labelsService;

    @RequestMapping("list")
    public Object list() {
//        {"code":0,"msg":"","count":1000,"data":
        List<Labels> list = labelsService.list();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "0");
        jsonObject.put("msg", "");
        jsonObject.put("count", list.size());
        jsonObject.put("data", list);

        return jsonObject;
    }

}
