package test2;

import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
public class 边缘检测 {
public static void main(String[] args) {
	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	Mat img=Imgcodecs.imread("C:\\Users\\86175\\Desktop\\images\\8.jpg");
	Mat img2=Imgcodecs.imread("C:\\Users\\86175\\Desktop\\images\\catExample.jpg");
	Mat mat1=new Mat();
	Mat mat2=new Mat();
	Imgproc.Sobel(img, mat1, -1, 0, 1);
	HighGui.imshow(null, mat1);
	HighGui.waitKey(0);
	Imgproc.Scharr(img, mat2, -1, 0, 1);
	HighGui.imshow(null, mat2);
	HighGui.waitKey(0);
}
}
