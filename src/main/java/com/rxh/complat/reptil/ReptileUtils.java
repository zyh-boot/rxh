/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.rxh.complat.reptil;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;

/**
 *
 * @Description: 爬虫工具类
 * @Author Zhang YuHui 
 * @Date 2021/1/8 11:19
 *
 */
public class ReptileUtils {
    public static final String webUrl = "http://demo.kangjingept.com:8020/cssthemes6/1.06ZF24/";

//    public static void main(String[] args) {
//        String name = "daohang.html";
//        Document link = extractTags(webUrl + name, "link");
//        System.out.println(link);
//    }


    /**
     * @Description extractTags 获取URL返回值
     * @author Zhang YuHui
     * @date 2021/1/8 15:12
     *
     * @params url 目标URL
     * @return byte[] 返回文件二进制数组 也可以直接返回字符串 考虑到会有图片资源 所以统一全部返回数组后续解析 便于管理
     */
    public static byte[] extractTags(String url) {

        JSONObject object = new JSONObject();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse execute = null;
        Document parse = null;
        String html = null;
        byte[] bytes = null;
        try {
            execute = client.execute(get);
            int statusCode = execute.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                System.out.println("连接访问有误, 状态码: " + statusCode+ "网址: " + url);
                return bytes;
            }
            //获取原始html 并转换为Dom对象
//            html = EntityUtils.toString(execute.getEntity(),"UTF-8");
//            parse = Jsoup.parse(html);

            bytes = EntityUtils.toByteArray(execute.getEntity());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bytes;
    }


    /**
     * @Description getTagHtml 获取标签内容
     * @author Zhang YuHui
     * @date 2021/1/8 15:06
     *
     * @params documentStr HTMl元素
     * @params tagName  标签名称 支持级联分级精确查找 目前仅支持id class tag结合
     * 例如: div > ul > li > a > span 最终返回span内容
     * @return java.lang.String
     */
    public static String getTagHtml(String documentStr, String tagName) {

        Document document = Jsoup.parse(documentStr);

        //消除代码格式化时,字符串中的空格
        tagName.trim();
        tagName = tagName.replaceAll("\\s*","");


        String[] split = tagName.split(">");
        Elements elements = getElementType(document, split[0]);


        if (split.length == 1) {
            return elements.html();
        } else {
            String substring = tagName.substring(tagName.indexOf(">") + 1);
            return getTagHtml(elements.html(), substring);
        }
    }
    public static String getTagHtml(String documentStr, String tagName,String attrName) {

        Document document = Jsoup.parse(documentStr);

        //消除代码格式化时,字符串中的空格
        tagName = clearStr(tagName);


        String[] split = tagName.split(">");
        Elements elements = getElementType(document, split[0]);


        if (split.length == 1) {
            return elements.toString();
        } else {
            String substring = tagName.substring(tagName.indexOf(">") + 1);
            return getTagHtml(elements.toString(), substring);
        }
    }

    private static String clearStr(String tagName) {
        tagName.trim();
        tagName = tagName.replaceAll("\\s*", "");
        return tagName;
    }

    private static Elements getElementType(Document document, String tmp1) {
        Elements elements = null;
        Element element = null;
        String tmp = tmp1;
        String prefix = tmp.substring(0, 1);
        switch (prefix) {
            case ".":
                elements = document.getElementsByClass(tmp.substring(1));
                break;
            case "#":
                element = document.getElementById(tmp.substring(1));
                elements.add(element);
                break;
            default:
                elements = document.getElementsByTag(tmp);
                break;
        }
        return elements;
    }

    /**
     * @Description getTagAttrHtml 获取标签属性
     * @author Zhang YuHui
     * @date 2021/1/8 15:15
     *
     * @params documentStr HTML元素
     * @params tagName 标签名
     * @params attrName 属性名 href src ref等等非CSS属性.
     * @return java.util.ArrayList<java.lang.Object>
     */
    public static HashSet<String> getTagAttrHtml(String documentStr, String tagName, String attrName) {

        HashSet<String> hashSet = new HashSet<>();

        tagName = clearStr(tagName);


        String endTag = tagName.substring(tagName.lastIndexOf(">")+1);
        String html = documentStr;
        if(tagName.indexOf(">") > -1){
            tagName = tagName.substring(0,tagName.lastIndexOf(">"));
            html = getTagHtml(documentStr, tagName);
        }

//        System.out.println(html);
//        System.out.println("**********************************************8");
        Document parse = Jsoup.parse(html);

        Elements elements = parse.getElementsByTag(endTag);
//        System.out.println(elements);
        for (Element element : elements) {
            String attr = element.attr(attrName);
//            System.out.println("tag: " + attr);
            hashSet.add(attr);
        }

        return hashSet;
    }

    /**
     * @Description getIdAttrHtml 根据ID获取子标签的属性内容
     * @author Zhang YuHui
     * @date 2021/1/8 15:17
     *
     * @params documentStr
     * @params id
     * @params tagName
     * @params attrName
     * @return java.util.ArrayList<java.lang.Object>
     */
    public static HashSet<String> getIdAttrHtml(String documentStr, String id, String tagName, String attrName) {
        Document document = Jsoup.parse(documentStr);
        Element element = document.getElementById(id);

//        获取上一级dom树
//        element.ownerDocument();
        HashSet<String> hashSet = getTagAttrHtml(element.toString(), tagName, attrName);
        return hashSet;
    }

    public static String getIdHtml(String documentStr, String id, String tagName) {
        Document document = Jsoup.parse(documentStr);
        Element element = document.getElementById(id);

//        获取上一级dom树
//        element.ownerDocument();
        String html = getTagHtml(element.toString(), tagName);
        return html;
    }


    /**
     * @Description createFile 创建文件
     * @author Zhang YuHui
     * @date 2021/1/8 14:35
     *
     * @params path 文件保存路径
     * @params bytes 数据byte二进制数组
     * @return void
     */
    public static boolean createFile(String path, byte[] bytes) {
        System.out.println("文件保存路径: " + path);
        File file = new File(path);

        if(bytes == null || bytes.length ==0){
            System.out.println("文件资源为空,无法保存!");
            return false;
        }
        boolean flag = false;
        try {
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
                FileOutputStream outputStream  = new FileOutputStream(file,true);
                outputStream.write(bytes);
                Thread.sleep(1000);
                outputStream.flush();
                outputStream.close();
            }
            flag = true;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return flag;
    }
}
