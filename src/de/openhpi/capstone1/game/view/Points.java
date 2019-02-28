package de.openhpi.capstone1.game.view;

import processing.core.PApplet;

public class Points extends AbstractView {
	private int score;
	private int highScore;
	private boolean isNewHighScore;
	
	public Points(PApplet display) {
		super(display);
	}
	
	public void setDefaultConfigurations() {
		this.score = 0;
		this.isNewHighScore = false;
	}
	
	public int getHighScore() {
		return this.highScore;
	}
	
	public void setIsNewHighScore(boolean isNewHighScore) {
		this.isNewHighScore = isNewHighScore;
	}
	
	public boolean getIsNewHighScore() {
		return this.isNewHighScore;
	}

	public void updateScore(int score) {
		this.score = this.score + score;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setNewHighScore() {
		if (this.highScore < this.score) {
			this.highScore = this.score;
			this.isNewHighScore = true;
		}
	}
	
	@Override
	public void update() {
		display.fill(0);
	}

}
