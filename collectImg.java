package test;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.video.BackgroundSubtractor;
import org.opencv.video.Video;

public class collectImg {
   public static void main(String[] args) throws AWTException, IOException, InterruptedException {
	   System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    /*   BackgroundSubtractor background;
       background=Video.createBackgroundSubtractorMOG2();
       int weight=1700;int height=1080;
       Rectangle screenRect = new Rectangle(new Rectangle()) ;
     int i=0;
       while(true) {
    	   Thread.sleep(1000);
      i++;
        // 截取屏幕图像
       BufferedImage capture = new Robot().createScreenCapture(screenRect);
        // 保存图像文件
       File imgFile=new File("C:\\Users\\86175\\Desktop\\cfImages2\\"+i+".jpeg");
       ImageIO.write(capture, "jpeg",imgFile );
       Mat mat=Imgcodecs.imread("C:\\Users\\86175\\Desktop\\images\\temp");
       background.apply(mat, mat);    //第一个mat为前景
       HighGui.imshow(null, mat);
*/
      int i=0;
    		while(true) {
    		i++;
    		Thread.sleep(1000);
    			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    			Robot robot = new Robot();
    			BufferedImage bufferedImage = robot.createScreenCapture(new Rectangle(d.width, d.height));
    			ImageIO.write(bufferedImage, "jpg", new File("C:\\Users\\86175\\Desktop\\csgo\\" +i+ ".jpg"));
    			System.out.println("ok");
    		
    		}
    	
       
      
       
       
   }
}

