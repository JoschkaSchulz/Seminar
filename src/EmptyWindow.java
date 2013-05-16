import java.awt.Point;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PShape;


public class EmptyWindow extends PApplet {
	
	private ArrayList<Point> vertexList;
	private int mode;
	
	public void setup() {
		size(300,300);
		vertexList = new ArrayList<>();
		mode = POINTS;
	}
	
	public void mousePressed() {
		vertexList.add(new Point(mouseX, mouseY));
	}
	
	
	public void keyPressed() {
		if(!mousePressed) {
			System.out.println("change...");
			if(mode == POINTS) {
				mode = LINES;
			}else if (mode == LINES) {
				mode = TRIANGLES;
			}else if( mode == TRIANGLES) {
				mode = TRIANGLE_STRIP;
			}else if( mode == TRIANGLE_STRIP) {
				mode = TRIANGLE_FAN;
			}else if( mode == TRIANGLE_FAN) {
				mode = QUADS;
			}else if( mode == QUADS) {
				mode = QUAD_STRIP;
			}else if( mode == QUAD_STRIP) {
				mode = POINTS;
			}
		}
	}
	
	public void draw() {
		background(255);
		
		stroke(255,0,0);
		strokeWeight(6f);
		beginShape(mode);
		for(Point p : vertexList) {
			vertex(p.x,p.y);
		}
		endShape();
	}
}
