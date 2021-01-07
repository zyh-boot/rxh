package com.rxh.complat.demo;

import lombok.Data;

/**
 *
 * @Description: 拼图验证实体类
 * @Author Zhang YuHui 
 * @Date 2020/11/30 14:57
 *
 */
@Data
public class ImageEntity {
    //切割后的大图
    private String backName;
    //切割出来的小图
    private String markName;
    //在原图切割的x坐标
    private int xLocation;
    //在原图切割的x坐标
    private int yLocation;
    //原图宽度
    private int backLength;
    //原图高度
    private int backHeight;
    //数据token保存在缓存中,用于校验超时以及后台校验
    private String token;

    public ImageEntity(){}
    public ImageEntity(String backName, String markName, int xLocation, int yLocation,int backLength,int backHeight){
        this.backName = backName;
        this.markName = markName;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.backLength = backLength;
        this.backHeight = backHeight;
    }

}
