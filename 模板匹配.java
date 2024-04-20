package test2;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class 模板匹配 {
public static void main(String[] args) {
	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	Mat img=Imgcodecs.imread("C:\\Users\\86175\\Desktop\\images\\cat.jpg");
	Mat example=Imgcodecs.imread("C:\\Users\\86175\\Desktop\\images\\catface.jpg");
	Mat result=new Mat();
	Imgproc.matchTemplate(img, example, result, Imgproc.TM_CCOEFF);
	Core.MinMaxLocResult mml=Core.minMaxLoc(result);
	Point p=mml.maxLoc;
	Imgproc.rectangle(img, p,new Point(p.x+example.cols(),p.y+example.rows()), new Scalar(255,0,0));
	HighGui.imshow(null, img);
	HighGui.waitKey(0); 	 
}
}
