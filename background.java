package test2;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.video.BackgroundSubtractor;
import org.opencv.video.Video;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class background {
    public static void main(String[] args) throws Exception {
    	//背景减法，0为黑 255为白
       System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
       BackgroundSubtractor background;
       background=Video.createBackgroundSubtractorMOG2();
       int weight=500;int height=400; Rectangle screenRect = new Rectangle(853-weight/2,480-height/2,weight,height);
     int i=0;
       while(true) {
    	 
      i++;
        // 截取屏幕图像
       BufferedImage capture = new Robot().createScreenCapture(screenRect);
        // 保存图像文件
       File imgFile=new File("C:\\Users\\86175\\Desktop\\cfImages\\"+i+".jpeg");
       ImageIO.write(capture, "jpeg",imgFile );
       Mat mat=Imgcodecs.imread("C:\\Users\\86175\\Desktop\\cfImages\\"+i+".jpeg");
       background.apply(mat, mat);    //第一个mat为前景
       HighGui.imshow(null, mat);
       HighGui.waitKey(1);

    }
       
    } 
}