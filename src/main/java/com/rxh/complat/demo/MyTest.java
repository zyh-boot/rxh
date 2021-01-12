package com.rxh.complat.demo;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
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
import java.util.HashSet;
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

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        ArrayList<Object> list = new ArrayList<>();
        HashMap<Object, Object> hashMap = new HashMap<>();
        String imgPath = "";
        try{
            Resource[] resources = resolver.getResources("classpath:/static/images/check/*.jpg");
            for (Resource resource : resources) {
                String filename = resource.getFilename();
                hashMap.put("filename",filename);
                String url = resource.getURL().getPath();
               if(url.startsWith("/")){
                  url = url.substring(1);
               }

                list.add(url);
            }

            int v = (int) (Math.random() * (resources.length));
            imgPath = list.get(v).toString();
        }catch (IOException e){
            e.printStackTrace();
        }

        String s1 = Files.probeContentType(Paths.get(imgPath));
        String[] split = s1.split("/");
        ImageEntity verifyImage = null;
        if(split[0].equals("image")){
            verifyImage = ImageCheck.getVerifyImage(imgPath);
        }

        return verifyImage;
    }

    public Object oldImage(String with, String height) throws IOException {
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

        String s1 = Files.probeContentType(Paths.get(imgPath));
        System.out.println(s1);
        String[] split = s1.split("/");
        System.out.println(split);
        ImageEntity verifyImage = null;
        if(split[0].equals("image")){
            verifyImage = ImageCheck.getVerifyImage(imgPath);
        }

        return verifyImage;
    }

}
