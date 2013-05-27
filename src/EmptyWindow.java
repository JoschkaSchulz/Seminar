import java.awt.Point;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PShape;


public class EmptyWindow extends PApplet {
	
	public void setup() {
		size(640,480);
	}
	
	public void draw() {
		background(255);
		
		int color = color(255, 0, 0);
		stroke(color);
		
		rect(50,50,100,100);
	}
}
