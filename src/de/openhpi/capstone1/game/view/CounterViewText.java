package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.model.Counter;
import processing.core.PApplet;

public class CounterViewText extends AbstractCounterView {
	
	public CounterViewText(PApplet display, Counter counter) {
		super(display, counter);
		screen = new String("GameScreen");
	}
	
	public void displayCreditTitle() {
		display.textSize(28);
		display.fill(255);
		display.text("CREDIT", 560, 570);
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
		displayCreditTitle();
		displayScore1Title();
		displayScore2Title();
		displayHighScoreTitle();
	}
}
