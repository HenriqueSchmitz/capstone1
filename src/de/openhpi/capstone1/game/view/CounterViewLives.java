package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.graphics.Image;
import de.openhpi.capstone1.game.logic.Lives;
import de.openhpi.capstone1.game.model.Counter;
import processing.core.PApplet;

public class CounterViewLives extends AbstractCounterView{
	Image image;
	
	public CounterViewLives(PApplet display, Counter counter) {
		super(display, counter);
		this.lives = new Lives();
		screen = new String("GameScreen");
		image = new Image(display, "Ship");
	}
	
	public void displayNumberOfLives() {
		display.textSize(40);
		display.fill(255);
		display.text(lives.getNumberOfLives() + "", 115, 575);	// display.text (text, x, y);
	}
	
	public void displayLives() {
		// display the number of lives (rectangles)
		int x = 160;
		for (int live = 0; live < lives.getNumberOfLives(); live++) {
			display.fill(255);
			image.draw(x, 535);
			x = x + 50;
		}
	}
	
	public void update() {
		display.fill(0);
		displayLives();
		displayNumberOfLives();
	}
}
