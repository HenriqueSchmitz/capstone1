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
	private int maxPosition;
	private boolean isBounceOn;
	
	
	public Mover(PApplet display, int startPosition, double speed) {
		this.display = display;
		startMillis = this.display.millis();
		this.startPosition = startPosition;
		this.maxPosition = startPosition;
		this.speed = speed;
		isDirectionPositive = true;
		this.pixelSize = FileReader.readConfiguration(display, "pixelSize");
	}
	
	public void setDirectionNegative() {
		isDirectionPositive = false;
	}
	
	public void setMaxPosition(int maxPosition) {
		this.maxPosition = maxPosition;
	}
	
	public void setBounceOn() {
		this.isBounceOn = true;
	}
	
	public void setBounceOff() {
		this.isBounceOn = false;
	}
	
	public int getPosition() {
		int currentPosition;
		int currentDisplacement = pixelSize * (int) ((display.millis() - startMillis) * speed / 1000);
		
		if(isDirectionPositive) {
			currentPosition = startPosition + currentDisplacement;
		} else {
			currentPosition = startPosition - currentDisplacement;
		}
		
		if(this.maxPosition != this.startPosition) {
			boolean isMaxPositionReached = false;
			
			if(isDirectionPositive) {
				if(currentPosition >= this.maxPosition) {
					isMaxPositionReached = true;
				}
			}
			else {
				if(currentPosition <= this.maxPosition) {
					isMaxPositionReached = true;
				}
			}
			
			if(isMaxPositionReached) {
				currentPosition = this.maxPosition;
				if(isBounceOn) {
					int newMax = this.startPosition;
					this.startPosition = this.maxPosition;
					this.maxPosition = newMax;
					this.startMillis = display.millis();
					this.isDirectionPositive = !this.isDirectionPositive;
				}

			}
		}
		
		return currentPosition;
	}
	
	public int getStartTime() {
		return this.startMillis;
	}
	
	public void setStartTime(int startMillis) {
		this.startMillis = startMillis;
	}
}
