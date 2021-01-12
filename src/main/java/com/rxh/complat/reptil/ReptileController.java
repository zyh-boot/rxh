/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.rxh.complat.reptil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rxh.complat.common.util.JsonResult;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @Description:
 * @Author Zhang YuHui 
 * @Date 2021/1/8 10:48
 *
 */
@RestController
@RequestMapping("reptile")
public class ReptileController {
//    public static final String webUrl = "http://demo.kangjingept.com:8020/cssthemes6/1.06ZF24/";

    public static final HashSet<String> others = new HashSet();

    @RequestMapping("file")
    public void ss() throws IOException {
        Map<String,Object> imgMap = new HashMap<>();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        try{
            Resource[] resources = resolver.getResources("classpath:/static/images/check/*.jpg");
            for (Resource resource : resources) {
//                byte[] bytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
//                String string = Base64Utils.encodeToString(bytes);
                String filename = resource.getFilename();
//                imgMap.put(filename,string);
                System.out.println(resource);
            }


        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("imgMap = " + imgMap);
    }

    @RequestMapping("load")
    private static JsonResult<Object> reptileFile(String url, String savePath) {
        JsonResult<Object> result = new JsonResult<>();
        JSONObject htmlList = getHtmlList(url);
        String baseUrl = htmlList.getString("baseUrl");
        HashSet<String> list = htmlList.getObject("list", HashSet.class);
        getBlog(baseUrl, savePath, list);

        System.out.println(list);
        System.out.println("缺失资源: " + others);

        for (String name : others) {
            byte[] bytes = null;
            if (name.indexOf("http://") > 0 || name.indexOf("https://") > 0) {
                bytes = ReptileUtils.extractTags(name);
            } else if (name.indexOf(".jpg") > 0 || name.indexOf(".png") > 0 || name.indexOf(".gif") > 0) {
                name = name.replaceAll("url\\(", "");
                name = name.replaceAll("\\.\\.", "");
                name = name.replaceAll("\\)", "");
                bytes = ReptileUtils.extractTags(baseUrl + name);

            }
            if (bytes != null && bytes.length > 0) {
                ReptileUtils.createFile(savePath + name, bytes);
            }

        }
        System.out.println("补充下载完毕;");
        result.code(200);
//        result.addParam("load", "下载完成");

        result.message("下载完成");
        return result;
    }

    /**
     * @Description getResource 解析css中内置的图片以及字体链接
     * @author Zhang YuHui
     * @date 2021/1/11 10:41
     *
     * @params name
     * @params str
     * @return void
     */
    private static void getResource(String name, String str) {
        Pattern compile = Pattern.compile("url\\(['\"]?\\s*(?<url>[^>]+?)['\"]?\\s*\\)");
        Matcher matcher = compile.matcher(str);
        HashSet<Object> objects = new HashSet<>();
        while (matcher.find()) {
            objects.add(matcher.group());
            others.add(matcher.group());
        }
        if (objects != null && objects.size() > 0) {
            System.out.println("提取资源: " + objects.toString() + "; 大小: " + objects.size());
//            others.add(name+"@"+objects);
//            writeOthers(objects.toString());
        }

    }

    private static JSONObject getHtmlList(String url) {
        url = url.substring(url.indexOf("url=") + 4, url.indexOf("&id="));
        String baseUrl = url.substring(0, url.lastIndexOf("/") + 1);
        System.out.println(baseUrl);

        //获取这套模板需要的HTML列表
        byte[] bytes = ReptileUtils.extractTags(baseUrl + "/_menu.json");
        JSONObject parse = JSONObject.parseObject(new String(bytes), JSONObject.class);
        String code = parse.getString("code");
        HashSet<String> hashSet = new HashSet<>();
        if ("success".equals(code)) {
            JSONArray data = JSONObject.parseObject(parse.getString("data"), JSONArray.class);

            for (int i = 0; i < data.size(); i++) {
                JSONObject o = JSONObject.parseObject(data.get(i).toString());
//                System.out.println( data.get(i));
                String dataSrc = o.getString("dataSrc");
                hashSet.add(dataSrc);
            }
        } else {
            System.out.println("HTML列表获取失败! 可能接口改变请确认");
        }
        System.out.println(hashSet);

        JSONObject object = new JSONObject();
        object.put("baseUrl", baseUrl);
        object.put("list", hashSet);
        return object;
    }


    /**
     * @Description getBlog 爬取模板之家 博客模块
     * @author Zhang YuHui
     * @date 2021/1/8 17:37
     *
     * @params
     * @return void
     */
    private static void getBlog(String utl, String savePath, HashSet<String> href) {
        String path = "C:\\Users\\zyh\\Desktop\\model\\";
        path = savePath;

        System.out.println(href);

        long start = System.currentTimeMillis();
        for (String name : href) {
            byte[] bytes = ReptileUtils.extractTags(utl);
            if (bytes == null) {
                continue;
            }
            //保存HTML文件
            ReptileUtils.createFile(path + name, bytes);
            String html = new String(bytes);
            //保存css
            loadFile(path, html, "link", "href", utl);
            //保存js
            loadFile(path, html, "script", "src", utl);
            //保存image
            loadFile(path, html, "img", "src", utl);
        }

        long end = System.currentTimeMillis();

        System.out.println("下载完成; 用时: " + (end - start) + "s");
    }

    private static void loadFile(String path, String html, String tagName, String attrName, String webUrl) {
        HashSet<String> href = ReptileUtils.getTagAttrHtml(html, tagName, attrName);
        for (String name : href) {
            byte[] bytes1 = ReptileUtils.extractTags(webUrl + name);
            boolean file = ReptileUtils.createFile(path + name, bytes1);

            if (file && name.indexOf(".html") < 0) {
                getResource(name, new String(bytes1));
            } else {
                System.out.println("网络资源: " + name);
                others.add(name);
            }
        }
    }


}
