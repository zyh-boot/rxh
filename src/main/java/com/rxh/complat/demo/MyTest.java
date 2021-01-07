package com.rxh.complat.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Description:
 * @Author Zhang YuHui 
 * @Date 2020/11/27 17:32
 *
 */
@RestController
public class MyTest {


    @RequestMapping("img")
    public Object image(String with, String height) throws IOException {
        String basePath = "C:\\Users\\zyh\\Pictures\\Saved Pictures\\";
        File file = new File(basePath);
        File[] files = file.listFiles();
        ArrayList<String> imgList = new ArrayList<>();
        for (File file1 : files) {
            imgList.add(file1.getName());
        }
        int v = (int) (Math.random() * (imgList.size()));
        String s = imgList.get(v);
        String imgPath = basePath + s;
        System.out.println(imgPath);

        File imgFile = new File(imgPath);
        String s1 = Files.probeContentType(Paths.get(imgPath));
        String[] split = s1.split("/");
        ImageEntity verifyImage = null;
        if(split[0].equals("image")){
            verifyImage = ImageCheck.getVerifyImage(imgPath);
        }



        return verifyImage;
    }

}
