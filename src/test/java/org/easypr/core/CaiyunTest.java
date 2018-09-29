package org.easypr.core;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_imgcodecs;

import java.io.File;

import static org.bytedeco.javacpp.opencv_core.BORDER_DEFAULT;
import static org.bytedeco.javacpp.opencv_imgcodecs.imwrite;
import static org.bytedeco.javacpp.opencv_imgproc.*;

public class CaiyunTest {

    public static void main(String[] args){

        //1、读取图片
        String directory = System.getProperty("user.dir");

        //1、获取图片
        String picPath = directory+File.separator +"src"+File.separator +"main"+File.separator +"resources"+File.separator + "image"+File.separator + "201809181631.png";
        System.out.println("picPath=" + picPath );
        opencv_core.Mat src = opencv_imgcodecs.imread(picPath);
        //2、高斯模糊
        opencv_core.Mat src_blur = new opencv_core.Mat();
        opencv_core.Mat src_gray = new opencv_core.Mat();
        opencv_core.Mat grad = new opencv_core.Mat();
        // 高斯模糊。Size中的数字影响车牌定位的效果。
        int gaussianBlurSize=1;
        GaussianBlur(src, src_blur, new opencv_core.Size(gaussianBlurSize, gaussianBlurSize), 0, 0, BORDER_DEFAULT);
        imwrite("target/caiyun_GaussianBlur_"+gaussianBlurSize+".jpg", src_blur);
        //3、图片灰度化
        cvtColor(src_blur, src_gray, CV_RGB2GRAY);
        imwrite("target/caiyun_gray.jpg", src_gray);

        opencv_core.Mat src_HSV = new opencv_core.Mat();;
        cvtColor(src_blur, src_HSV, COLOR_BGR2HSV);
        imwrite("target/caiyun_hsv.jpg", src_HSV);
        //opencv_core.Mat img_threshold = new opencv_core.Mat();
        //threshold(grad, img_threshold, 0, 255, CV_THRESH_OTSU + CV_THRESH_BINARY);
        //
        //imwrite("target/debug_threshold.jpg", img_threshold);





    }

}
