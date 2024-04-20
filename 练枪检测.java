package test2;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
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
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class 练枪检测 {
public static void main(String[] args) throws IOException, AWTException, InterruptedException {
	 // 加载OpenCV库
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    Dimension d;
    Thread.sleep(3000);
    int i=0;
    while(i<400) {
    	i++;
	d = Toolkit.getDefaultToolkit().getScreenSize();
	Robot robot = new Robot();
	//200, 50, 1200, 650	
	BufferedImage bufferedImage = robot.createScreenCapture(new Rectangle(d.width,d.height));
	ImageIO.write(bufferedImage, "jpg", new File("D:\\res\\dac.jpg"));

    // 加载训练模型
    CascadeClassifier ballDetector = new CascadeClassifier();
    ballDetector.load("C:\\Users\\86175\\Pictures\\xml\\cascade.xml");
    Mat mat=Imgcodecs.imread("D:\\res\\dac.jpg");			
    Imgproc.cvtColor(mat, mat, Imgproc.COLOR_BGR2GRAY);   //转化为灰度图
    MatOfRect rec=new MatOfRect();
    ballDetector.detectMultiScale(mat, rec);
    int count=0;
    for (Rect rect : rec.toArray()) {
        Imgproc.rectangle(mat, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                new Scalar(0, 255, 0), 2);
        
        count++;
        if(count==1) {    	   

        int x=(int) ((rect.x+rect.x + rect.width)/2);
        int y=(int) ((rect.y+rect.y + rect.height)/2);
        int jbx=853;
        int jby=479;
        int dx=(int) ((jbx-x>0?jbx-x:x-jbx));
        int dy=(int) ((jby-y>0?jby-y:y-jby));
        int xi=1;
        int yj=1;
        if(x>=jbx) {	
        	while(xi<=dx) {
        		//Thread.sleep(10);
                robot.mouseMove(jbx+xi, jby);
                xi+=1;
                }
        }else {
        	while(xi<=dx) {
        		//Thread.sleep(10);
                robot.mouseMove(jbx-xi, jby);
                xi+=1;
                }
        }
        if(jby>y) {
        	while(yj<=dy) {
        		//Thread.sleep(10);
        		robot.mouseMove(x, jby-yj);
        		yj+=1;
        	}
        }else {
        	while(yj<=dy) {
        		//Thread.sleep(10);
        		robot.mouseMove(x, jby+yj);
        		yj+=1;
        	}
        }
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(10);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(10);
        }
        
        
        /*
        //1033 379
        int x=(rect.x+rect.x + rect.width)/2;
        int y=(rect.y+rect.y + rect.height)/2;
        System.out.println(x+" "+y);
        */

    }
    //	Imgcodecs.imwrite("D:\\res\\dac.jpg", mat);
    }
}
}

