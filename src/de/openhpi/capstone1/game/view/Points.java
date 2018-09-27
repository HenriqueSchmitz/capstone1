package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.graphics.FileReader;
import processing.core.PApplet;

public class Points extends AbstractView {
	private int score;
	private int highScore;
	private int credit;
	private boolean isNewHighScore;
	private int sideBorderSize;
	private int screenWidth;
	
	public Points(PApplet display) {
		super(display);
		this.sideBorderSize = FileReader.readConfiguration(display, "sideBorderSize");
		this.screenWidth = FileReader.readConfiguration(display, "screenWidth");
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
