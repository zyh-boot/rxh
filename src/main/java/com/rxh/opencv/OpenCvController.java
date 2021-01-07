package com.rxh.opencv;

import com.rxh.complat.demo.Base64PreFix;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 *
 * @Description:
 * @Author Zhang YuHui 
 * @Date 2020/12/7 11:55
 *
 */
@RestController
@RequestMapping("opencv")
public class OpenCvController {
//    static {}


    @RequestMapping("img")
    public String get() throws IOException {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
         Mat imread = Imgcodecs.imread("F:\\zimage\\4.png");
        Mat clone = imread.clone();
        Size size = imread.size();
//        Imgproc.blur(imread,clone,new Size(size.width*0.01,size.height*0.01), new Point(-1,-1),Core.BORDER_DEFAULT);
        //均值滤波,
//        Imgproc.blur(imread,clone,new Size(9,9), new Point(-1,-1),Core.BORDER_DEFAULT);
        //高斯滤波
//        Imgproc.GaussianBlur(imread,clone,new Size(9,9),0,0,Core.BORDER_DEFAULT);
        //中值滤波,第三个参数为单数
        Imgproc.medianBlur(imread,clone,9);

        String base64 = Base64PreFix.getBase64("F:\\zimage\\4.png");
        return base64;
    }
}
