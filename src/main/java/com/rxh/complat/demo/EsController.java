package com.rxh.complat.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rxh.complat.common.elasticsearch.EsEnyity;
import com.rxh.complat.common.elasticsearch.EsSearchService;
import com.rxh.complat.common.util.JsonResult;
import com.rxh.complat.common.util.PinYinUtils;
import com.rxh.wechat.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @Description:
 * @Author Zhang YuHui 
 * @Date 2020/11/25 10:31
 *
 */
@RestController
public class EsController {

    @Autowired
    EsSearchService esSearchService;

    @RequestMapping("addIndex")
    public Object es(String index,String pian,String bei,String analyzer) throws Exception {
        boolean zzx = esSearchService.createIndex(index,pian,bei,analyzer);
        return zzx;
    }
    @RequestMapping("del")
    public Object del(String... name) throws IOException {
        Object o = esSearchService.delIndex(name);
        return o;
    }
    @RequestMapping("addDoc")
    public Object del(String name,String userName,String text,String targes) throws IOException {
        EsEnyity esEnyity = new EsEnyity();
        UUID uuid = UUID.randomUUID();
        esEnyity.setId(uuid.toString());
        esEnyity.setName(userName);
        esEnyity.setCarNum(Math.random() * 10000 + "");
        esEnyity.setUserName(userName);
        esEnyity.setSex("nan");
        esEnyity.setAuthor(userName);
        esEnyity.setText(text);
        esEnyity.setNamePin(PinYinUtils.getAllPin(userName,""));
        esEnyity.setTargs(targes.split(","));
        Object o = esSearchService.createDoc(name,esEnyity);
        return o;
    }

    @RequestMapping("updateDoc")
    public Object update(String indexName, Map<String,Object> map,String id) throws IOException {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("username","tom");
        Object o = esSearchService.updateDoc(indexName, hashMap, id);
        return o;
    }

    @RequestMapping("delDoc")
    public Object delDoc(String index,String docID) throws IOException {
        Object o = esSearchService.delDoc(index, docID);
        return o;
    }
    @RequestMapping("getDoc")
    public Object getDoc(String index,String docId) throws IOException {
        Object query = esSearchService.getDoc(index, docId);
        return query;
    }

    @RequestMapping("query")
    public Object query(String index,String fild,String value,String size) throws IOException, NoSuchFieldException, IllegalAccessException {
        Object query = esSearchService.query(index, fild, value,size);
        System.out.println(query);
        JSONArray objects = JSONArray.parseArray(JSON.toJSONString(query));
        JsonResult result = new JsonResult();
        result.code(200);
        result.data(objects);
        result.message("success");
//        result.code(200).data(objects).message("success");
        return result;
    }
//    @RequestMapping("queryPin")
//    public Object queryPin(String index,String fild,String value,String size,String targ) throws IOException {
//        Object query = esSearchService.queryPin(index, fild, value,size,targ);
//        return query;
//    }

}
