package test2;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class findFullBody {
      public static void main(String[] args) throws AWTException {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	//截屏
		Robot robot=new Robot();
		 int weight=1000;int height=700;
		 int x=853-weight/2;   int y=480-height/2;
		 Rectangle screenRect = new Rectangle(853-weight/2,480-height/2,weight,height);
		 CascadeClassifier bodyDetector = new CascadeClassifier();
		
	        bodyDetector.load("D:\\opencv\\sources\\data\\haarcascades\\hand.xml");  //加载人体识别器
	       while(true) {
	        // 截取屏幕图像
	       BufferedImage capture = new Robot().createScreenCapture(screenRect);
	        // 保存图像文件
	       File imgFile=new File("C:\\Users\\86175\\Desktop\\cfImages\\cf.jpg");
	       try {
			ImageIO.write(capture, "jpg",imgFile );
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			System.out.println("写入文件异常");
			e.printStackTrace();
		}
	       Mat mat=Imgcodecs.imread("C:\\Users\\86175\\Desktop\\cfImages\\cf.jpg");
	       imgFile.delete();
	        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_BGR2GRAY);   //转化为灰度图
            Imgproc.equalizeHist(mat, mat);             //均衡化直方图 直方图是图像中像素强度分布的图形表达方式.它统计了每一个强度值所具有的像素个数.
           MatOfRect fullBody = new MatOfRect();         
            bodyDetector.detectMultiScale(mat, fullBody);    //人体检测
           
         Rect rects[]=fullBody.toArray();
         for(int i=0;i<rects.length;i++) {
        	   
        	   if(rects[i].x>=x&&rects[i].x<=x+rects[i].width&&rects[i].y>=y&&rects[i].y<=y+rects[i].height) {
        		//   Imgproc.rectangle(mat, new Point(rects[i].x,rects[i].y),new Point(rects[i].width+rects[i].x,rects[i].height+rects[i].y),new Scalar(0,250,30) , 2);        		   
        	   System.out.println("检测到人体，坐标为：("+rects[i].x+","+rects[i].y+")");
        	   robot.mouseMove(rects[i].x, rects[i].y);
        	   }
         } 
          HighGui.imshow(null, mat);
          HighGui.waitKey(1);
	}
}
}
