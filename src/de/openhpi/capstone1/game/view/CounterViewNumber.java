package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.model.Counter;
import processing.core.PApplet;

public class CounterViewNumber extends AbstractCounterView {
			
	public CounterViewNumber(PApplet display, Counter counter) {
		super(display, counter);
		screen = new String("GameScreen");
	}
	
	public void displayCreditNumber() {
		display.textSize(28);
		display.fill(255);
		display.text("0000", 700, 570);	// display.text (text, x, y);
		//display.text(counter.getCredit(), 500, 550); 
	}
	
	public void displayScore1Number() {
		display.textSize(28);
		display.fill(255);
		display.text("0000", 130, 70);	// display.text (text, x, y);
		//display.text(counter.getScore1(), 100, 100);
	}
	
	public void displayScore2Number() {
		display.textSize(28);
		display.fill(255);
		display.text("0000", 650, 70);	// display.text (text, x, y);
		//display.text(counter.getScore2(), 600, 100); 
	}
	
	public void displayHighScoreNumber() {
		display.textSize(28);
		display.fill(255);
		display.text("0000", 395, 70);	// display.text (text, x, y);
		//display.text(counter.getHighScore(), 350, 100); 
	}
	
	@Override
	public void update() {
		display.fill(0);
		displayCreditNumber();
		displayScore1Number();
		displayScore2Number();
		displayHighScoreNumber();
	}
	
}
