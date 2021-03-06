/*
 * Seminar Vortrag
 * 
 * Versuch eine komplette Präsentation in Processing zu halten...
 */

import java.awt.Frame;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.pdf.PGraphicsPDF;

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
	private static int FOOTER_PAGENUMBER_X = 90;
	private static int FOOTER_NAME_X = 1;
	
	private int current = 0;
	
	public boolean sketchFullScreen(   ) {
	  return true;
	}
	
	public static void main(String[] args) {
		Frame frame = new Frame("Processing - Präsentation");
		frame.setUndecorated(true);
		// The name "sketch_name" must match the name of your program
		PApplet applet = new Vortrag(   );
		frame.add(applet);
		applet.init(   );
		frame.setBounds(0, 0, 1024, 768); 
		frame.setVisible(true);
	}
	
	public int getPerX(int percent) {
		return width/100*percent;
	}
	
	public int getPerY(int percent) {
		return height/100*percent;
	}
	
	public void h1(String text, int x, int y) {
		textSize(48.0f);
		text(text, x, y);
	}
	
	public void h2(String text, int x, int y) {
		textSize(36.0f);
		text(text, x, y);
	}
	
	public void p(String text, int x, int y) {
		textSize(24.0f);
		text(text, x, y);
	}
	
	//(f)ooter text
	public void f(String text, int x, int y) {
		textSize(16.0f);
		text(text, x, y);
	}
	
	public void bullet1(String text) {	fill(255); stroke(255); ellipse(getPerX(POINT1_X)-20, getPerX(POINT1_Y)-115, 10, 10); p(text, getPerX(POINT1_X), getPerY(POINT1_Y));}
	public void bullet2(String text) {	fill(255); stroke(255); ellipse(getPerX(POINT2_X)-20, getPerX(POINT2_Y)-145, 10, 10); p(text, getPerX(POINT2_X), getPerY(POINT2_Y));}
	public void bullet3(String text) {	fill(255); stroke(255); ellipse(getPerX(POINT3_X)-20, getPerX(POINT3_Y)-175, 10, 10); p(text, getPerX(POINT3_X), getPerY(POINT3_Y));}
	public void bullet4(String text) {	fill(255); stroke(255); ellipse(getPerX(POINT4_X)-20, getPerX(POINT4_Y)-205, 10, 10); p(text, getPerX(POINT4_X), getPerY(POINT4_Y));}
	public void bullet5(String text) {	fill(255); stroke(255); ellipse(getPerX(POINT5_X)-20, getPerX(POINT5_Y)-235, 10, 10); p(text, getPerX(POINT5_X), getPerY(POINT5_Y));}
	
	private PImage bookcover, bg, demo, system, rotate, translate, clouds, logo, ide, eclipse,emptywindow, trenner;
	private PFont kreide;
	public void setup(   ) {
		//Fullscreen
		//size(1024,786,PDF,"test.pdf");
		size(1024,786);
		//size(displayWidth,displayHeight);
		
		//Set font
		kreide = createFont("Eraser.ttf", 32);
		setChalkWhite(   );
		
		bg = loadImage("background.jpg");
		bg.resize(width, height);
		
		logo = loadImage("processing_logo.png");
		logo.resize(300, 300);
		
		demo = loadImage("demowindow.png");
		ide = loadImage("ide.png");
		eclipse = loadImage("eclipse.png");
		emptywindow = loadImage("emptywindow.png");
		trenner = loadImage("trenner.png");
		bookcover = loadImage("bookcover.jpg");
		bookcover.resize(350, 450);
		
		system = loadImage("system.png");
		system.resize(400, 400);
		
		rotate = loadImage("rotate.png");
		rotate.resize(250, 200);
		
		translate = loadImage("translate.png");
		translate.resize(200, 200);
		
		clouds = loadImage("clouds.png");
	}
	
	public void setChalkWhite(   ) {
		fill(255);
		textFont(kreide);
	}
	public void setChalkBlack(   ) {
		fill(0);
		textFont(kreide);
	}
	
	/*
	 * Master
	 */
	public void vortragMaster(   ) {
		//BACKGROUND
		image(bg, 0, 0);
		
		image(trenner, 0, 75);
		image(trenner, 0, height-75);
		
		//Seitennummer
		if(current > 0) f("Joschka Schulz",getPerX(FOOTER_NAME_X), height-26);
				
		//Seitennummer
		if(current > 0) f("Seite "+current+"/22",getPerX(FOOTER_PAGENUMBER_X), height-26);
	}
	
	/*
	 * Seite 0 - Titelseite
	 */
	public void vortragPage0(   ) {
		h1("Processing",getPerX(25), getPerY(45));
		p("Ein Vortrag von Joschka Schulz",getPerX(25), getPerY(50));
	}
	
	/*
	 * Seite 1 - Gliederung
	 */
	public void vortragPage1(   ) {
		h1("Gliederung",getPerX(HEAD_X),getPerY(HEAD_Y));
		
		//Geschichte & Einleitung
		bullet1("Geschichte und Einleitung");
		//Grundlagen
		bullet2("Grundlagen Processing");
		//Platformen
		bullet3("Platformen und Internetseiten");
		//Fazit
		bullet4("Fazit");
	}
	
	/*
	 * Seite 2 - Was ist Processing
	 */
	public void vortragPage2(   ) {
		h1("Geschichte - Was ist Processing",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("Grafische Programmiersprache");
		bullet2("basierend auf Java");
		bullet3("2D und 3D");
		bullet4("Einsteigerfreundlich");
		bullet5("Prix Ars Electronica 2005");
		
		//Draw Processing Logo
		image(logo,getPerX(POINT1_X+40), getPerY(POINT1_Y));
	}
	
	/*
	 * Seite 2a - Entwicklung von Processing
	 */
	public void vortragPage2a(   ) {
		h1("Geschichte - Entwicklung von Processing",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("Massachusetts Institute of Technologie");
		bullet2("Ben Fry");
		bullet3("Casey Reas");
		bullet4("Beginn 2001");
		bullet5("Stabile Version 2008");
	}
	
	/*
	 * Seite 2b - Was ist Processing
	 */
	public void vortragPage2b(   ) {
		h1("Geschichte - Benjamin Fry und Casey Reas",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("Broad Institute");
		bullet2("http://benfry.com/");
		bullet3("UCLA Design / Media Arts");
		bullet4("http://www.reas.com/");
		bullet5("Getting Started with Processing");
		
		image(bookcover,getPerX(POINT1_X+40), getPerY(POINT1_Y-10));
	}
	
	/*
	 * Seite 3 - Einsatzgebiete
	 */
	public void vortragPage3(   ) {
		h1("Geschichte - Einsatzgebiete",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("Interaktive Lichtinstallation");
		bullet3("Forschung");
		bullet5("Grafische Visualisierungen");
	}
	
	/*
	 * Seite 4 - Wie benutze ich Processing
	 */
	boolean page4demo = false;
	public void vortragPage4(   ) {
		h1("Wie benutze ich Processing",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("Processing IDE");
		bullet4("Externe .jar Library");
		
		//Zeichne Processing IDE und Eclipse
		if(page4demo) {
			image(eclipse,getPerX(POINT1_X+30), getPerY(POINT1_Y+20));
		}else{
			if(keyCode == 68) page4demo = true;
			image(ide,getPerX(POINT1_X+30), getPerY(POINT1_Y-20));
		}
	}
	
	/*
	 * Seite 5 - Aufbau einer Anwendung
	 */
	public void vortragPage5(   ) {
		h1("Aufbau einer Anwendung",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("Klasse PApplet");
		bullet2("public void setup(   )");
		bullet3("public void draw(   )");
		
		//Bild
		image(emptywindow,getPerX(POINT1_X+30), getPerY(POINT1_Y));
	}
	
	/*
	 * Seite 6 - Das erste Fenster
	 */
	public void vortragPage6(   ) {
		h1("Das erste Fenster",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("size(width, height)");
		bullet2("smooth(   ) oder smooth(level)");			//Anti-Analysing/default ist auf on || level = 2x 4x 8x... 0 deaktiviert
		bullet3("framerate(fps)");
		
		//Bild
		//drawPlaceholder(getPerX(POINT1_X+35), getPerY(POINT1_Y-10), 500, 400);
		image(system,getPerX(POINT1_X+35), getPerY(POINT1_Y-10));
	}
	
	/*
	 * Seite 7 - Mauspos
	 */
	boolean page7demo = false;
	public void vortragPage7(   ) {
		h1("Mausposition abfragen",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("Position über Variablen");
		bullet2("mouseX");
		bullet3("mouseY");
		
		//Demo
		if(page7demo) {
			int x = getPerX(40);
			int y = getPerY(50);
			int size = demoScreen("Mausposition", x, y);
			x+=6; y+=48;//Koordinaten korigieren
			if(mouseX > x && mouseX < x+size && mouseY > y && mouseY < y+size) {
				p("Konsole",x+size+20,y-20);
				p("mouseX = "+(mouseX-x),x+size+20,y);
				p("mouseY = "+(mouseY-y),x+size+20,y+20);
			}
		}else{
			if(keyCode == 68) page7demo = true;
		}
	}
	
	/*
	 * Seite 8 - Tasten einlesen
	 */
	boolean page8demo = false;
	public void vortragPage8(   ) {
		h1("Tasten einlesen",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("Einlesen durch Variablen und Methoden");
		bullet2("keyCode und key");
		bullet3("überladen von keyPressed(   )");
		bullet4("Für Maus mit mousePressed");
		bullet5("Weitere Methoden: keyReleased(   ), keyTyped(   )");
		
		//Demo
		if(page8demo) {
			int x = getPerX(50);
			int y = getPerY(50);
			int size = demoScreen("Tasten", x, y);
			x+=6; y+=48;//Koordinaten korigieren
			if(keyPressed) {
				p("Konsole",x+size+20,y-20);
				p("key     = "+key,x+size+20,y);
				p("keyCode = "+keyCodeDemo,x+size+20,y+20);
			}
		}else{
			if(keyCode == 68) page8demo = true;
		}
	}
	
	/*
	 * Seite 9 - Das erste Rechteck
	 */
	private boolean page9demo = false;
	private int page9_x = 0, page9_y = 0, page9_w = 0, page9_h = 0;
	private int page9_rx = 0, page9_ry = 0, page9_rw = 0, page9_rh = 0;
	public void vortragPage9(   ) {
		h1("Das erste Rechteck...",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("Methode: rect(x,y,width,height)");
		bullet2("x,y koordinaten der linken oberen Kante");
		bullet3("width ist die Breite");
		bullet4("height ist die Höhe");

		//Demo
		if(page9demo) {
			int x = getPerX(40);
			int y = getPerY(50)+35;
			int size = demoScreen("Rechteck", x, y);
			x+=6; y+=48;//Koordinaten korigieren
			if(page9_x != 0 && page9_w != 0) {
				p("Konsole",x+size+20,y-20);
				p("rect("+page9_x+","+page9_y+","+page9_w+","+page9_h+");",x+size+20,y);
				noFill();
				stroke(0);
				rect(page9_rx,page9_ry,page9_rw,page9_rh);
				stroke(255);
			}
			if(mouseX > x && mouseX < x+size && mouseY > y && mouseY < y+size) {
				if(page9_x == 0){
					p("Konsole",x+size+20,y-20);
					p("rect("+(mouseX-x)+","+(mouseY-y)+",,);",x+size+20,y);
					if(mousePressed) {
						page9_x = (mouseX-x);
						page9_rx = mouseX;
						page9_y = (mouseY-y);
						page9_ry = mouseY;
					}
				}else if (page9_w == 0) {
					p("Konsole",x+size+20,y-20);
					p("rect("+page9_x+","+page9_y+","+((mouseX-x)-page9_x)+","+((mouseY-y)-page9_y)+");",x+size+20,y);
					if(mousePressed) {
						page9_w = ((mouseX-x)-page9_x);
						page9_rw = mouseX - page9_rx;
						page9_h = ((mouseY-y)-page9_y);
						page9_rh = mouseY - page9_ry;
					}
				}
			}
		}else{
			if(keyCode == 68) page9demo = true;
		}
	}
	
	/*
	 * Seite 10 - Der erste Kreis
	 */
	private boolean page10demo = false;
	private int page10_x = 0, page10_y = 0, page10_w = 0, page10_h = 0;
	private int page10_rx = 0, page10_ry = 0, page10_rw = 0, page10_rh = 0;
	private int page10_lx = 0, page10_ly = 0;
	public void vortragPage10(   ) {
		h1("...und der erste Kreis",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("Methode: ellipse(x,y,width,height)");
		bullet2("x,y koordinaten der Mittelpunkt");
		bullet3("width ist die Breite");
		bullet4("height ist die Höhe");
		bullet5("Methode ellipseMode(mode)");
		//Demo
		if(page10demo) {
			int x = getPerX(40);
			int y = getPerY(50)+35;
			int size = demoScreen("Rechteck", x, y-35);
			x+=6; y+=48;//Koordinaten korigieren
			if(page10_x != 0 && page10_w != 0) {
				p("Konsole",x+size+20,y-20);
				p("ellipse("+page10_x+","+page10_y+","+page10_w+","+page10_h+");",x+size+50,y);
				noFill(   );
				stroke(0);
				ellipse(page10_rx,page10_ry,page10_rw*2,page10_rh*2);
				color(255,0,0);
				strokeWeight(5f);
				line(page10_rx,page10_ry,page10_lx,page10_ry);
				line(page10_rx,page10_ry,page10_rx,page10_ly);
				strokeWeight(1f);
				color(0);
				stroke(255);
			}
			if(mouseX > x && mouseX < x+size && mouseY > y && mouseY < y+size) {
				if(page10_x == 0){
					p("Konsole",x+size+20,y-20);
					p("ellipse("+(mouseX-x)+","+(mouseY-y)+",,);",x+size+20,y);
					if(mousePressed) {
						page10_x = (mouseX-x);
						page10_rx = mouseX;
						page10_y = (mouseY-y);
						page10_ry = mouseY;
					}
				}else if (page10_w == 0) {
					p("Konsole",x+size+20,y-20);
					p("ellipse("+page10_x+","+page10_y+","+((mouseX-x)-page10_x)+","+((mouseY-y)-page10_y)+");",x+size+20,y);
					if(mousePressed) {
						page10_w = ((mouseX-x)-page10_x);
						page10_rw = mouseX - page10_rx;
						page10_h = ((mouseY-y)-page10_y);
						page10_rh = mouseY - page10_ry;
						page10_lx = mouseX;
						page10_ly = mouseY;
					}
				}
			}
		}else{
			if(keyCode == 68) page10demo = true;
		}
	}
	
	/*
	 * Seite 11 - Farbe Rand und Füllung
	 */
	boolean page11demo = false;
	public void vortragPage11(   ) {
		h1("Farbe, Rand und Füllung",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("Methode: color(r,g,b)");
		bullet2("Methode: fill(r,g,b)");
		bullet3("Methode: stroke(r,g,b)");
		bullet4("Vor dem Zeichnen anwenden");
		bullet5("alpha als 4. Parameter");
		
		//Demo
		if(page11demo) {
			int x = getPerX(50);
			int y = getPerY(50);
			int size = demoScreen("Mausposition", x, y);
			x+=6; y+=48;//Koordinaten korigieren
			
			int color_red = color((millis()/10) % 255, 0, 0,128f);
			int color_green = color(0, (millis()/10) % 255, 0,128f);
			int color_blue = color(0, 0, (millis()/10) % 255,128f);
			
			strokeWeight(5.0f);
			fill(color_red);
			stroke(color_green);
			rect(x+10,y+10,75,75);
			fill(color_green);
			stroke(color_blue);
			rect(x+60,y+60,75,75);
			fill(color_blue);
			stroke(color_red);
			rect(x+110,y+110,75,75);
			fill(255);
			strokeWeight(1.0f);
		}else{
			if(keyCode == 68) page11demo = true;
		}
	}
	
	/*
	 * Seite 12 - 
	 */
//	public void vortragPage12(   ) {
//		h1("Seite 12",getPerX(HEAD_X),getPerY(HEAD_Y));
//	}
	
	/*
	 * Seite 13 - 
	 */
//	public void vortragPage13(   ) {
//		h1("Seite 13",getPerX(HEAD_X),getPerY(HEAD_Y));
//	}
	
	/*
	 * Seite 14 - 
	 */
//	public void vortragPage14(   ) {
//		h1("Seite 14",getPerX(HEAD_X),getPerY(HEAD_Y));
//	}
	
	/*
	 * Seite 15 - Bilder laden
	 */
	boolean page15demo = false;
	boolean imgLoaded = false;
	PImage resize1,resize2, resize3, effect1;
	public void vortragPage15(   ) {
		h1("Bilder Laden",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("Methode: loadImage(filename)");
		bullet3("Klasse: PImage");
		bullet5("resize, filter, save...");
		
		//Als Demo evtl Pfeile oder Objekte in der Präsentation anklickbar?
		//Demo
		if(page15demo) {
			int x = getPerX(50);
			int y = getPerY(50);
			int size = demoScreen("Mausposition", x, y);
			x+=6; y+=48;//Koordinaten korigieren
			
			if(!imgLoaded) {
				try {
					resize1 = (PImage)logo.clone();
					resize2 = (PImage)logo.clone();
					resize3 = (PImage)logo.clone();
					effect1 = (PImage)logo.clone();
					resize1.resize(32, 32);
					resize2.resize(64, 64);
					resize3.resize(128, 128);
					effect1.resize(128, 128);
					effect1.filter(BLUR, 5.0f);
				} catch (CloneNotSupportedException e) {
				}
				imgLoaded = true;
			}
			
			image(resize1, x+10, y+10);
			image(resize2, x+10, y+42);
			image(resize3, x+10, y+106);
			image(effect1, x+138, y+106);
		}else{
			if(keyCode == 68) page15demo = true;
		}
	}
	
	/*
	 * Seite 16 - rotate, translate, pushmatix
	 */
	private boolean page16demo1 = false, page16demo2 = false, page16demo3 = false;
	public void vortragPage16(   ) {
		//Demo
		if(page16demo1) {
			translate(150f, 150f);
		}else{
			if(keyCode == 68) page16demo1 = true; // (d)emo
		}
		if(page16demo2) {
			translate(-150f, -150f);
		}else{
			if(keyCode == 66) page16demo2 = true; // (b)ack
		}
		if(page16demo3) {
			rotate(PI/5.0f);
		}else{
			if(keyCode == 82) page16demo3 = true; // (r)otate
		}
		h1("rotate and translate",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("translate(x,y)");
		bullet2("pushMatrix(   ) und popMatrix(   )");	//pushMatrix(   ) <- Merkt sich den Ausgangspunkt und mit popMatrix wird er zurück gesetzt
		bullet3("rotate(angle)");
		
		//Bild der des Zeichen Zettels
		image(translate, getPerX(POINT1_X+35), getPerY(POINT1_Y));
		image(rotate, getPerX(POINT1_X+55), getPerY(POINT3_Y));
	}
	
	/*
	 * Seite 17 - 
	 */
	boolean page17demo = false;
	int modus = 0;
	ArrayList<Point> al = new ArrayList<>();
	public void vortragPage17(   ) {
		h1("Shapes",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("mehrere vertex(x,y)");
		bullet2("beginShape(   ) und endShape(   )");
		bullet3("POINTS, LINES, TRIANGLES, QUADS");
		
		//Demo
		if(page17demo) {
			int x = getPerX(40);
			int y = getPerY(50);
			int size = demoScreen("Shapes", x, y);
			x+=6; y+=48;//Koordinaten korigieren
			
			
			noFill();
			stroke(0);
			strokeWeight(5f);
			
			//Modus
			if(modus == 0){
				beginShape(POINTS);
			}else if(modus == 1) {
				beginShape(LINES);
			}else if(modus == 2) {
				beginShape(TRIANGLES);
			}else if(modus == 3) {
				beginShape(QUADS);
			}
			for(Point p : al) {
				vertex(p.x, p.y);
			}
			endShape();
			stroke(255);
			strokeWeight(1f);
			fill(255);
		}else{
			if(keyCode == 68) page17demo = true;
		}
	}
	
	@Override
	public void mousePressed() {
		if(current == 16 && page17demo) {
			if(mouseButton == 39) {
				if(modus++ > 3) modus = 0;
			}else{
				int x = getPerX(40);
				int y = getPerY(50);
				x+=6; y+=48;
				if(mouseX > x && mouseX < x+300 && mouseY > y && mouseY < y+300) {
					if(mousePressed)
						al.add(new Point(mouseX, mouseY));
				}
			}
		}else {
			if(v == 0.01f) v = 0.05f;
			else if (v == 0.05f) v = 0.1f;
			else v = 0.01f;
		}
	}
	
	/*
	 * Seite 18 - 
	 */
	boolean page18demo = false;
	float t = 0; 
	float v = 0.01f;
	LinkedList<Float> n = new LinkedList<>();
	public void vortragPage18(   ) {
		h1("Noise und Constraint",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("noise(xoff)");
		bullet3("constraint(min,max)");
		
		//Demo
		if(page18demo) {
			int x = getPerX(50);
			int y = getPerY(50);
			int size = demoScreen("Tasten", x, y);
			x+=6; y+=48;//Koordinaten korigieren
			
			p("Konsole",x+size+20,y-20);
			p("noise = "+v,x+size+20,y);
			
			if(n.size() >= 250) {
				n.addLast(noise(t+=v));
				n.removeFirst();
			}else{
				n.add(noise(t+=v));
			}
			stroke(0);
			rect(x+10,y+10,250,100);
			for(int i = 0; i < n.size(); i++) {
				line(x+11+i,y+109,x+11+i,(y)+(n.get(i)*100));
			}
			stroke(255);
		}else{
			if(keyCode == 68) page18demo = true;
		}
	}
	
	/*
	 * Seite 18 - 
	 */
	public void vortragPage18a(   ) {
		h1("Zeiten",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("Lokale Zeiten");
		bullet2("second(   ) minute(   ) und hour(   )");
		bullet3("day(   ) month(   ) und year(   )");
		bullet4("Fortlaufende Zeiten");
		bullet5("millis(   )");
	}
	
	/*
	 * Seite 19 - Open Processing
	 */
	public void vortragPage19(   ) {
		h1("Seiten und Platformen",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("Open Processing");
		bullet2("http://www.openprocessing.org");
		
		bullet4("Processing.org");
		bullet5("http://www.processing.org");
	}
	
	
	/*
	 * Seite 20 - 
	 */
	public void vortragPage20(   ) {
		h1("Fazit",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("Vielseitig Nutzbar");
		bullet2("Leichte Handhabung");
		bullet3("Schnelles Programmieren");
	}
	
	/*
	 * Seite 21 - 
	 */
	public void vortragPage21(   ) {
		h1("Quellen",getPerX(HEAD_X),getPerY(HEAD_Y));
		bullet1("Processing (O'Reillys Basics) [978-3-89721-997-7]");
		bullet2("http://processing.org");
	}
	
	/*
	 * Seite 22 - 
	 */
	public void vortragPage22(   ) {
		h1("Vielen Dank",getPerX(25), getPerY(45));
	}
	
	
	public void vortragEnd(   ) {
		background(0);
	}
	
	
	public void drawPlaceholder(int x, int y, int w, int h) {
		noFill(   );
		line(x,y,x+w,y+h);
		line(x+w,y,x,y+h);
		rect(x,y,w,h);
	}
	
	
	//Start des Inhalts 6,48
	public int demoScreen(String text, int x, int y) {
		int size = 300;
		//image(clouds,x-500,y-150);	//Unbedingt Clouds anpassen!
		//fill(0);
		//rect(x+size+20,y,300,100);
		//fill(255);
		image(demo, x, y);
		return size;
	}
	
//	public void mousePressed() {
//		System.out.println("x:"+mouseX+" y:"+mouseY);
//		System.out.println("Test: "+getPerX(POINT1_Y));
//	}
	
	int keyCodeDemo = 0;
	public void keyPressed(   ) {
		keyCodeDemo = keyCode;
		switch(keyCode) {
			default:
//				System.out.println(key+"=>"+keyCode);
				break;
			case 33: //Bild runter für Presentor
			case 37: //Links
				if(current > 0) current--;
				break;
			case 34: //Bild auf für Presentor
			case 39: //Rechts
				current++;
				break;
			case 38: //Hoch
				current+=10;
				break;
			case 40: //Runter
				if(current > 10) current-=10;
				break;
			case 27: //Esc
				break;
		}
	}
	
	public void draw(   ) {
		background(255);
		
		vortragMaster(   );
		switch(current) {
			default:
				vortragEnd(   );
				break;
			case 0: vortragPage0(   ); break;
			case 1: vortragPage1(   ); break;
			case 2: vortragPage2(   ); break;
			case 3: vortragPage2a(   ); break;
			case 4: vortragPage2b(   ); break;
			case 5: vortragPage3(   ); break;
			case 6: vortragPage4(   ); break;
			case 7: vortragPage5(   ); break;
			case 8: vortragPage6(   ); break;
			case 9: vortragPage7(   ); break;
			case 10: vortragPage8(   ); break;
			case 11: vortragPage9(   ); break;
			case 12: vortragPage10(   ); break;
			case 13: vortragPage11(   ); break;
//			case 12: vortragPage12(   ); break;
//			case 13: vortragPage13(   ); break;
//			case 14: vortragPage14(   ); break;
			case 14: vortragPage15(   ); break;
			case 15: vortragPage16(   ); break;
			case 16: vortragPage17(   ); break;
			case 17: vortragPage18(   ); break;
			case 18: vortragPage18a(   ); break;
			case 19: vortragPage19(   ); break;
			case 20: vortragPage20(   ); break;
			case 21: vortragPage21(   ); break;
			case 22: vortragPage22(   ); break;
		}
		
		//For pdf mode
		//PGraphicsPDF pdf = (PGraphicsPDF) g;  // Get the renderer
		//pdf.nextPage();  // Tell it to go to the next page
		
		//save("folie"+current+".png");
		//if(current++ > 19) exit();
	}
}
