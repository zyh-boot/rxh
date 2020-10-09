package com.rxh.wechat.comment.mybatisPlus;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.util.Scanner;

/**
 *
 * @Description: 入口函数
 * @Author Zhang YuHui 
 * @Date 2020/10/8 9:41
 *
 */
public class MyBatisPlusCode {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入模块名：");
        String modelName = scanner.next();
        System.out.println("请输入表名：");
        String tableName = scanner.next();
        if (!StringUtils.isNotBlank(modelName) && !StringUtils.isNotBlank(tableName)) {
            throw new MybatisPlusException("请输入正确的表名或模块名！");
        }

        MyBatisPlusConfig mybatisConfig = new MyBatisPlusConfig();
        mybatisConfig.codeGenerator(modelName,tableName);
    }

}
