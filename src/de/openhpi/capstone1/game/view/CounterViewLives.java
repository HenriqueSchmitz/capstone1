package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.logic.Lives;
import de.openhpi.capstone1.game.model.Counter;
import processing.core.PApplet;

public class CounterViewLives extends AbstractCounterView{

	public CounterViewLives(PApplet display, Counter counter) {
		super(display, counter);
		this.lives = new Lives();
	}
	
	public void displayNumberOfLives() {
		display.textSize(28);
		display.fill(255);
		display.text(lives.getNumberOfLives() + "", 120, 570);	// display.text (text, x, y);
	}
	
	public void displayLives() {
		// display the number of lives (rectangles)
		int x = 150;
		for (int live = 0; live < lives.getNumberOfLives(); live++) {
			display.fill(255);
			display.rect(x, 545, counter.getWidth(), counter.getHeight(), 2);	// I'm using rectangles for the moment
			x = x + counter.getWidth() + 15;
		}
	}
	
	public void update() {
		display.fill(0);
		displayLives();
		displayNumberOfLives();
	}
}
