package de.openhpi.capstone1.game.model;

import java.util.ArrayList;

public class Counter {
	
	private int count;
	
	public Counter() {
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
