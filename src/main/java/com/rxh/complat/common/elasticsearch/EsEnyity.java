package com.rxh.complat.common.elasticsearch;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.lang.annotation.Documented;

/**
 *
 * @Description:
 * @Author Zhang YuHui 
 * @Date 2020/11/25 15:35
 *
 */
@Data
public class EsEnyity {
    @Id
    String id;
    String name;
    String namePin;
    String userName;
    String sex;
    String carNum;
    String author;
    String text;
    String[] targs;
}
