package org.easypr.core;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.junit.Test;

import java.io.File;

/**
 *
 */
public class PlateLocateTest {


    @Test
    public  void  plateLocate(){


        String directory = System.getProperty("user.dir");

        //1、获取图片
        String picPath = directory+File.separator +"src"+File.separator +"main"+File.separator +"resources"+File.separator + "image"+File.separator + "test.jpg";
        System.out.println("picPath=" + picPath );
        opencv_core.Mat image = opencv_imgcodecs.imread(picPath);
        //2、处理
        PlateLocate plateLocate=new PlateLocate();
        plateLocate.setLifeMode(false);
        plateLocate.plateLocate(image);
        //3、返回结果

    }


}
