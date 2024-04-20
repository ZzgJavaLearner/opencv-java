package test2;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.Point;

public class 别踩白块儿 {
public static void main(String[] args) throws AWTException, InterruptedException {
	Robot robot=new Robot();
	Color black=new Color(51,51,51);
	Color white=new Color(255,255,255);
	int p[][]=new int[4][2];
	p[0]= new int[] {577,600};
	p[1]=new int[] {730,600};
	p[2]=new int[] {869,600};
	p[3]= new int[] {1043,600};
	Color c[]=new Color[4];
	Thread.sleep(1000);
	while(true) {
	for(int i=0;i<4;i++) {
		c[i]=robot.getPixelColor(p[i][0],p[i][1]);
		if(c[i].equals(black)) {
			robot.mouseMove(p[i][0],p[i][1]);
			//Thread.sleep(5);;
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			//Thread.sleep(5);;
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		}
	}
	}
}
}
