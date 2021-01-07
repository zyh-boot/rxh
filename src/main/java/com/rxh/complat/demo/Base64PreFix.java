package com.rxh.complat.demo;

import com.rxh.complat.common.exception.MyException;
import org.springframework.context.annotation.PropertySource;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @Description: 文件转Base64
 * @Author Zhang YuHui 
 * @Date 2020/11/30 9:40
 *
 */
public class Base64PreFix {


    public static String getPrefix(String name){
        InputStream inputStream = Base64PreFix.class.getClassLoader().getResourceAsStream("Base64Prefix.properties");
        Properties properties = new Properties();
        String type = "";
        try {
            properties.load(inputStream);
            type = properties.getProperty(name);
        } catch (IOException e) {
            e.printStackTrace();
            new MyException(e.getMessage());
        }
        return type;
    }


    public static String getBase64(String basePath) throws IOException {
//        String basePath = "C:\\Users\\zyh\\Pictures\\Camera Roll\\";
        File file = new File(basePath);
        if(file.isFile()){
            String baseEncode = getBaseEncode(file);
            String s1 = Files.probeContentType(Paths.get(basePath));
            System.out.println("文件类型:>>>>>>"+s1);
            return "data:"+s1+";base64," + baseEncode;
        }
        File[] files = file.listFiles();
        ArrayList<String> imgList = new ArrayList<>();
        for(File file1 : files){
            imgList.add(file1.getName());
        }
        System.out.println(imgList.size());
        int v = (int)(Math.random() * (imgList.size()));
        String s = imgList.get(v);
        String imgPath = basePath + s;


        File imgFile = new File(imgPath);
        String s1 = Files.probeContentType(Paths.get(imgPath));
        System.out.println("文件类型:>>>>>>"+s1);
        String encode = getBaseEncode(imgFile);

        return "data:"+s1+";base64," + encode;
    }

    /**
     * @Description 目前只做图片转Base64
     * @author zyh
     * @date 2020/12/1 14:02
     */
    private static String getBaseEncode(File imgFile) throws IOException {
        BufferedImage read = ImageIO.read(imgFile);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(read,"jpg",outputStream);
        byte[] bytes = outputStream.toByteArray();
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(bytes);
    }
}
