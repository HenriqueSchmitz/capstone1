package de.openhpi.capstone1.game.logic;

import java.util.Random;

public class Enemy {
	private int numberOfEnemies;
	private boolean randomize = true;

	public int getNumberOfEnemies() {
		return numberOfEnemies;
	}

	public void randomizeNumberOfEnemies() {
		Random random = new Random();
		numberOfEnemies = random.nextInt(10) + 1;	// numbers from 0 to 10
	}
	
	public void setRandomize (boolean randomize) {
		this.randomize = randomize;
	}
	
	public boolean isRandomize() {
		return this.randomize;
	}
}
