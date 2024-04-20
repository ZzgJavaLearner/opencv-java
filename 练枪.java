package test2;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;

public class 练枪 {
public static void main(String[] args) throws AWTException, InterruptedException {
		Robot robot=new Robot();
		//[r=26,g=223,b=224]  [r=24,g=211,b=215] [r=23,g=204,b=210]
		Thread.sleep(3000);

	//	int x = (int) b.getX();
	//	int y = (int) b.getY();
	//	Color c=robot.getPixelColor(x, y);
	//	System.out.println(c);
	/*	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
	
		double height = screenSize.getHeight();
		System.out.println("宽："+width+"  高："+height);
		*/
		
		int i=1;
		/*while(i<=853*4/1.13) {
			robot.mouseMove(853+i, 479);
			Thread.sleep(2);
			i++;
		}
		*/
		/*
		while(i<=479) {
			robot.mouseMove(853, 479+i);
			Thread.sleep(2);
			i+=10;
		}
		*/
		//1400 350
		int x=(int) (1400);
		int y=(int) (350+30);
		int fff=(int) ((479-y>0?479-y:y-479));
		int kkk=(int) ((853-x>0?853-x:x-853));
		while(i <= fff) {
			
			robot.mouseMove((int) (853), 479-i);
			Thread.sleep(0);
			i+=5;
		}
		int j=1;
		while(j<=kkk) {
			robot.mouseMove(853-j, (int) (y));
			Thread.sleep(0);
			j+=5;
		}
	/*	
		robot.mouseMove(1707, 960);
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		System.out.println(b);
        Thread.sleep(1000);
        robot.mouseMove(0, 0);
        PointerInfo aaa = MouseInfo.getPointerInfo();
		Point bbb = aaa.getLocation();
		System.out.println(b);
		Thread.sleep(1000);
		robot.mouseMove(1707/2, 960/2);
		PointerInfo ccc = MouseInfo.getPointerInfo();
		Point ddd = ccc.getLocation();
		System.out.println(b);
		
		*/
	}
}
