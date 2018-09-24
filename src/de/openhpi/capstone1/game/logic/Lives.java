package de.openhpi.capstone1.game.logic;

public class Lives {
	
	private int numberOfLives;
	
	public Lives() {
		this.numberOfLives = 3;
	}
	
	public void setNumberOfLives(int lives) {
		this.numberOfLives = lives;
	}
	
	public int getNumberOfLives() {
		return this.numberOfLives;
	}
	
	public void updateNumberOfLives() {
		this.numberOfLives++;
	}
}
