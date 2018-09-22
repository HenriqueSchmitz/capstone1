package de.openhpi.capstone1.game.model;

import de.openhpi.capstone1.game.graphics.FileReader;
import processing.core.PApplet;

public class Mover {
	
	private PApplet display;
	private int startMillis;
	private int startPosition;
	private int pixelSize;
	private double speed;	//Speed is given in pixels / second
	private boolean isDirectionPositive;
	
	
	public Mover(PApplet display, int startPosition, double speed) {
		this.display = display;
		startMillis = this.display.millis();
		this.startPosition = startPosition;
		this.speed = speed;
		isDirectionPositive = true;
		this.pixelSize = FileReader.readConfiguration(display, "pixelSize");
	}
	
	public void setDirectionNegative() {
		isDirectionPositive = false;
	}
	
	public int getPosition() {
		int currentPosition;
		int currentDisplacement = pixelSize * (int) ((display.millis() - startMillis) * speed / 1000);
		
		if(isDirectionPositive) {
			currentPosition = startPosition + currentDisplacement;
		} else {
			currentPosition = startPosition - currentDisplacement;
		}
		
		return currentPosition;
	}
}
