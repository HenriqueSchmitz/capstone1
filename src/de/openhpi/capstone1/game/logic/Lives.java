package de.openhpi.capstone1.game.logic;

public class Lives {
	
	private int lives;
	
	public Lives() {
		this.lives = 3;
	}
	
	public void setNumberOfLives(int lives) {
		this.lives = lives;
	}
	
	public int getNumberOfLives() {
		return this.lives;
	}
	
	public void takeDamage() {
		this.lives--;
	}
	
	public void die() {
		this.lives = 0;
	}
	
	public boolean isAlive() {
		return this.lives > 0;
	}
}
