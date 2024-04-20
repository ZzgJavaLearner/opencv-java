package test;
import org.bytedeco.opencv.opencv_dnn.Model;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.List;
import ai.djl.*;
public class BodyDtct {

	public static void main(String[] args) throws IOException {
	    String url="C:\\Users\\86175\\Desktop\\csgo\\9.jpg";
		String[] command = {"python", "F:\\yolov5-master\\detect.py", "--weights", "F:\\yolov5-master\\weight\\yolov5s.pt", "--img-size", "900", "--conf-thres", "0.25", "--source", url};
		Process process = Runtime.getRuntime().exec(command);

        
	}
}
