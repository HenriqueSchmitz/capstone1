package de.openhpi.capstone1.game.model;

import processing.core.PApplet;

public class Counter {
	
	private int count;
	
	public Counter(PApplet display) {
		this.count = 0;
	}
	
	public void updateCount(int value) {	
		this.count += value;
		
	}

	public int getCount() {
		return this.count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
}
