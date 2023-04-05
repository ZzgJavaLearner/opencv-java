package test2;
import java.io.*;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
public class find {
public static void main(String[] args) throws IOException, InterruptedException, AWTException {
	/*
	 * 本程序为本人学习java+opencv的一点点小想法，因本人暂时没学python，所以只能通过这种办法使用yolo，实现方法效率较低，延迟大概为6-8秒，可结合
	 * Robot类进行一些自动化操作
	 * */
	 new Yolov5Do();
}
  
}
class Yolov5Do{
	Yolov5Do() throws IOException, InterruptedException, AWTException{
	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);     
	//卸磨杀驴
	File exp=new File("F:\\yolov5-master\\runs\\detect\\exp");   //yolo处理后的图片存放文件夹（非默认）
	File[] files=exp.listFiles();
	if(files!=null) {
	for(int i=0;i<files.length;i++) {
		files[i].delete();
	}
	}else {
	exp.delete();
	}
	//截取屏幕中心区域的图片  此法消耗资源过多，建议使用obs推流减少功耗
	int weight=500;int height=400;         //截取大小，可根据自己需要截取
	 int x=853-weight/2;   int y=480-height/2;
	 Rectangle screenRect = new Rectangle(853-weight/2,480-height/2,weight,height);
	 //yolo输出路径
	 File outputImage=new File("F:\\yolov5-master\\data\\images\\inputImgs.jpg"); 
		  while(true) { 
			  try { BufferedImage capture = new
		  Robot().createScreenCapture(screenRect);
		 ImageIO.write(capture,"jpg",outputImage);  
		  } catch (AWTException e) { 
				  // TODO *自动生成的 catch 块
		 System.out.println("截取屏幕失败");
		 e.printStackTrace(); } //yolov5处理
			  //通过dos命令执行detect脚本，检测图片
		  Process proc=Runtime.getRuntime().exec("cmd /c cd C:\\Users\\86175 && start /b run_yolo.bat"); 
		//以下注释部分功能在detect.py即可实现，无需再写
			/*
			 * //载入已经过yolov5处理后图像 //图像预处理 //转化为灰度图 // Imgproc.cvtColor(image,
			 * image,Imgproc.COLOR_GRAY2BGR); //均衡化直方图
			 * 直方图是图像中像素强度分布的图形表达方式.它统计了每一个强度值所具有的像素个数. //Imgproc.equalizeHist(image,
			 * image);
			 */
			 		//休眠6秒，以等待yolo处理完
		  Thread.sleep(6000); 
     //坐标获取计算及鼠标移动，我这里之监控一个物体，因此长度为四，可按需求更改
		  String locaStr[] = new String[4];
		  //坐标位置存放路径
			 BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\86175\\Desktop\\images\\location.txt"));
			 int j=0;
			for(int i=0;i<locaStr.length;i++) {
				locaStr[i]=br.readLine();
			}  //yolo识别后的坐标位置读取并计算中心位置，可在yolo自己修改
			int x1= Integer.parseInt(locaStr[0]);
			int y1= Integer.parseInt(locaStr[1]);
			int x2= Integer.parseInt(locaStr[2]);
			int y2= Integer.parseInt(locaStr[3]);
			int body_x=(x1+x2)/2;
			int body_y=(y1+y2)/2;
			Robot robot=new Robot();
			System.out.println(body_x+""+body_y);
			robot.mouseMove(body_x, body_y);
		   }
	}
}