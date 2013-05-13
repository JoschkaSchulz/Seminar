import java.awt.Frame;

import processing.core.PApplet;


public class Vortrag extends PApplet {
	
	private static int HEAD_X = 10;
	private static int HEAD_Y = 10;
	private static int POINT1_X = 15;
	private static int POINT1_Y = 35;
	private static int POINT2_X = 15;
	private static int POINT2_Y = 45;
	private static int POINT3_X = 15;
	private static int POINT3_Y = 55;
	private static int POINT4_X = 15;
	private static int POINT4_Y = 65;
	private static int POINT5_X = 15;
	private static int POINT5_Y = 75;
	private static int PAGENUMBER_X = 49;
	private static int PAGENUMBER_Y = 95;
	
	private int current = 0;
	
	public boolean sketchFullScreen() {
	  return true;
	}
	
	public static void main(String[] args) {
		Frame frame = new Frame("Processing - Präsentation");
		frame.setUndecorated(true);
		// The name "sketch_name" must match the name of your program
		PApplet applet = new Vortrag();
		frame.add(applet);
		applet.init();
		frame.setBounds(0, 0, 1024, 600);//768); 
		frame.setVisible(true);
	}
	
	public int getPerX(int percent) {
		return width/100*percent;
	}
	
	public int getPerY(int percent) {
		return height/100*percent;
	}
	
	public void h1(String text, int x, int y) {
		fill(0);
		stroke(0);
		textSize(48.0f);
		text(text, x, y);
	}
	
	public void h2(String text, int x, int y) {
		fill(0);
		stroke(0);
		textSize(36.0f);
		text(text, x, y);
	}
	
	public void p(String text, int x, int y) {
		fill(0);
		stroke(0);
		textSize(24.0f);
		text(text, x, y);
	}
	
	public void bullet1(String text) { p(text, getPerX(POINT1_X), getPerY(POINT1_Y));}
	public void bullet2(String text) {	p(text, getPerX(POINT2_X), getPerY(POINT2_Y));}
	public void bullet3(String text) {	p(text, getPerX(POINT3_X), getPerY(POINT3_Y));}
	public void bullet4(String text) {	p(text, getPerX(POINT4_X), getPerY(POINT4_Y));}
	public void bullet5(String text) {	p(text, getPerX(POINT5_X), getPerY(POINT5_Y));}
	
	public void setup() {
		//Fullscreen
		size(displayWidth,displayHeight);
	}
	
	/*
	 * Master
	 */
	public void vortragMaster() {
		//Seitennummer
		if(current > 0) p("Seite "+current+"/6",getPerX(PAGENUMBER_X), getPerY(PAGENUMBER_Y));
	}
	
	/*
	 * Seite 0 - Titelseite
	 */
	public void vortragPage0() {
		h1("Processing",getPerX(HEAD_X), getPerY(HEAD_Y));
		h2("Processing",getPerX(50), getPerY(55));
		p("Processing", getPerX(50), getPerY(60));
	}
	
	/*
	 * Seite 1 - Gliederung
	 */
	public void vortragPage1() {
		h1("Gliederung",getPerX(HEAD_X),getPerY(HEAD_Y));
	}
	
	/*
	 * Seite 2 - Was ist Processing
	 */
	public void vortragPage2() {
		h1("Was ist Processing",getPerX(HEAD_X),getPerY(HEAD_Y));
	}
	
	/*
	 * Seite 3 - 
	 */
	public void vortragPage3() {
		h1("Seite 3",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("Test1");
		bullet2("Test2");
		bullet3("Test3");
		bullet4("Test4");
		bullet5("Test5");
	}
	
	/*
	 * Seite 4 - 
	 */
	public void vortragPage4() {
		h1("Seite 4",getPerX(HEAD_X),getPerY(HEAD_Y));
	}
	
	/*
	 * Seite 5 - 
	 */
	public void vortragPage5() {
		h1("Seite 5",getPerX(HEAD_X),getPerY(HEAD_Y));
	}
	
	/*
	 * Seite 6 - 
	 */
	public void vortragPage6() {
		h1("Seite 6",getPerX(HEAD_X),getPerY(HEAD_Y));
	}
	
	public void vortragEnd() {
		background(0);
	}
	
	public void keyPressed() {
		switch(keyCode) {
			default:
//				System.out.println("=>"+keyCode);
				break;
			case 37: //Links
				if(current > 0) current--;
				break;
			case 39: //Rechts
				current++;
				break;
		}
	}
	
	public void draw() {
		background(255);
		
		vortragMaster();
		switch(current) {
			default:
				vortragEnd();
				break;
			case 0: vortragPage0(); break;
			case 1: vortragPage1(); break;
			case 2: vortragPage2(); break;
			case 3: vortragPage3(); break;
			case 4: vortragPage4(); break;
			case 5: vortragPage5(); break;
			case 6: vortragPage6(); break;
		}
	}
}
