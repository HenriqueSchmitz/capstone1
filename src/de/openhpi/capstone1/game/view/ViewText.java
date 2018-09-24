package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.graphics.FileReader;
import de.openhpi.capstone1.game.model.Counter;
import processing.core.PApplet;

public class ViewText extends AbstractView {
	
	private int endlinePosition;
	private int scoreAreaHeight;
	private int screenWidth;
	private int sideBorderSize;
	
	public ViewText(PApplet display) {
		super(display);
		int screenHeight = FileReader.readConfiguration(display, "screenHeight");
		int endlinePositionFromBottom = FileReader.readConfiguration(display, "endlinePositionFromBottom");
		this.endlinePosition = screenHeight - endlinePositionFromBottom;
		this.scoreAreaHeight = FileReader.readConfiguration(display, "scoreAreaHeight");
		this.screenWidth = FileReader.readConfiguration(display, "screenWidth");
		this.sideBorderSize = FileReader.readConfiguration(display, "sideBorderSize");
	}
	
	public void displayCreditTitle() {
		display.textSize(28);
		display.fill(255);
		display.text("CREDIT", 560, endlinePosition + 35);
	}
	
	public void displayScoreBox() {
		display.fill(0);
		display.rect(0, 0, this.screenWidth, this.scoreAreaHeight);
		display.fill(255);
		display.strokeWeight(4);	
		display.stroke(255);	// line color
		display.line(sideBorderSize, scoreAreaHeight, screenWidth - sideBorderSize, scoreAreaHeight);
	}
	
	public void displayScore1Title() {
		display.textSize(28);
		display.fill(255);
		display.text("SCORE <1> ", 110, 40);
	}
	
	public void displayScore2Title() {
		display.textSize(28);
		display.fill(255);
		display.text("SCORE <2> ", 630, 40);
	}
	
	public void displayHighScoreTitle() {
		display.textSize(28);
		display.fill(255);
		display.text("HI-SCORE", 380, 40);
	}
	
	@Override
	public void update() {
		display.fill(0);
		displayScoreBox();
		displayCreditTitle();
		displayScore1Title();
		displayScore2Title();
		displayHighScoreTitle();
	}
}
