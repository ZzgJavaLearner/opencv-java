package test2;
import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JFrame;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;
public class findFace<t1> {
    public static void main(String[] args) throws AWTException {
       findEye f=new findEye();
       f.find();
    }
}
class findEye{
	public void find() {
		 // 加载OpenCV库
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        // 创建CascadeClassifier对象并加载人眼识别模型
        CascadeClassifier faceDetector = new CascadeClassifier();
        faceDetector.load("D:\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_default.xml");
        CascadeClassifier eyeDetector = new CascadeClassifier();
        eyeDetector.load("D:\\opencv\\sources\\data\\haarcascades\\haarcascade_eye_tree_eyeglasses.xml");
        // 创建VideoCapture对象并打开计算机摄像头
        VideoCapture capture = new VideoCapture(0);
        // 捕获视频帧
        Mat frame = new Mat();
        while (capture.read(frame)) {
            // 对视频帧进行灰度化和直方图均衡化预处理
            Mat grayFrame = new Mat();	
            Imgproc.cvtColor(frame, grayFrame, Imgproc.COLOR_BGR2GRAY);   //转化为灰度图
            Imgproc.equalizeHist(grayFrame, grayFrame);             //均衡化直方图 直方图是图像中像素强度分布的图形表达方式.它统计了每一个强度值所具有的像素个数.
            
            // 进行人眼检测
            MatOfRect faces = new MatOfRect();
            faceDetector.detectMultiScale(grayFrame, faces);
            MatOfRect eyes = new MatOfRect();
            eyeDetector.detectMultiScale(grayFrame, eyes);
           
            // 在原始视频帧上绘制检测到的人脸和人眼区域
            for (Rect face : faces.toArray()) {
                Imgproc.rectangle(frame,new Point(face.x,face.y),new Point(face.x+face.width,face.y+face.height), new Scalar(0, 12, 255), 2);
            }
           for(Rect eye : eyes.toArray()) {
            	Imgproc.rectangle(frame,new Point(eye.x,eye.y),new Point(eye.x+eye.width,eye.y+eye.height), new Scalar(0, 255, 0), 2);
            }
          
            HighGui.imshow(null, frame); 
            HighGui.waitKey(1);  
            
        }    
      // 释放资源
        capture.release();
	}
}