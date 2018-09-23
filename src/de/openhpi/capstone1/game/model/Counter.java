package de.openhpi.capstone1.game.model;

import java.util.ArrayList;

public class Counter {
	
	private int count = 0;
	private int width = 30;
	private int height = 30;
	
	public void updateCount(int value) {	
		this.count += value;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
}
