package de.openhpi.capstone1.game.view;

import java.util.ArrayList;

import de.openhpi.capstone1.game.graphics.FileReader;
import processing.core.PApplet;

public class ViewPoints extends AbstractView{
	private ArrayList<Points> points;
	private int screenWidth;
	private int sideBorderSize;
	
	public ViewPoints(PApplet display, ArrayList<Points> points) {
		super(display);
		this.screenWidth = FileReader.readConfiguration(display, "screenWidth");
		this.sideBorderSize = FileReader.readConfiguration(display, "sideBorderSize");
		this.points = points;
	}
	
	public void pointSystemDesign(int value, int posX, int posY) {
		display.textAlign(PApplet.CENTER);
		if (value > 99) {
			display.text("00" + value, posX, posY);
		}
		else if (value > 999) {
			display.text("0" + value, posX, posY);
		}
		else if (value > 9999) {
			display.text("" + value, posX, posY);
		}
		else if (value < 9) {
			display.text("0000" + value, posX, posY);
		}
		else {
			display.text("000" + value, posX, posY);
		}
		display.textAlign(PApplet.LEFT);
	}
	
	public void showPoints() {
		display.textSize(28);
		display.fill(255);
	
		pointSystemDesign(points.get(0).getScore(), sideBorderSize*2, 70);
		if (points.size() > 1) {
			pointSystemDesign(points.get(1).getScore(), screenWidth - sideBorderSize*2, 70);
			
			if (points.get(0).getHighScore() > points.get(1).getHighScore()) {
				pointSystemDesign(points.get(0).getHighScore(), screenWidth/2, 70);
			}
			else {
				pointSystemDesign(points.get(1).getHighScore(), screenWidth/2, 70);
			}
		}
		else {
			pointSystemDesign(points.get(0).getHighScore(), screenWidth/2, 70);
		}
	}
	
	public void update() {
		display.fill(0);
		showPoints();
	}
}
