package com.rxh.complat.demo.opencv;

import com.rxh.complat.demo.Base64PreFix;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.IOException;

/**
 *
 * @Description:
 * @Author Zhang YuHui 
 * @Date 2020/12/7 11:04
 *
 */
public class OpenCvTest {
    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
    private static Mat imread = Imgcodecs.imread("F:\\zimage\\4.png");
    public static void main(String[] args) throws IOException {
        Mat clone = imread.clone();
        Size size = imread.size();
//        Imgproc.blur(imread,clone,new Size(size.width*0.01,size.height*0.01), new Point(-1,-1),Core.BORDER_DEFAULT);
        //均值滤波,
//        Imgproc.blur(imread,clone,new Size(9,9), new Point(-1,-1),Core.BORDER_DEFAULT);
        //高斯滤波
//        Imgproc.GaussianBlur(imread,clone,new Size(9,9),0,0,Core.BORDER_DEFAULT);
        //中值滤波,第三个参数为单数
        Imgproc.medianBlur(imread,clone,9);

        Base64PreFix.getBase64("F:\\zimage\\4.png");
        HighGui.imshow("test",clone);
        HighGui.waitKey(1000);
    }
}
