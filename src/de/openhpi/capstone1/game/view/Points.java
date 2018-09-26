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
	
	/*public void pointSystemDesign(int value, int posX, int posY) {
		display.textAlign(PApplet.CENTER);
		if (value > 99) {
			display.text("00" + value, posX, posY);
		}
		else if (value > 999) {
			display.text("0" + value, posX, posY);
		}
		else if (value > 9999) {
			display.text("" + value, posX, posY);
		}
		else if (value < 9) {
			display.text("0000" + value, posX, posY);
		}
		else {
			display.text("000" + value, posX, posY);
		}
		display.textAlign(PApplet.LEFT);
	}
	
	public void showPoints() {
		display.textSize(28);
		display.fill(255);
		pointSystemDesign(this.score, sideBorderSize*2, 70);
		//pointSystemDesign(this.score2, screenWidth - sideBorderSize*2, 70);
		pointSystemDesign(this.highScore, screenWidth/2, 70);
		pointSystemDesign(this.credit, 730, 665);
	}*/

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
		//showPoints();
	}

}
