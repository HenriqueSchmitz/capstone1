package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.graphics.FileReader;
import de.openhpi.capstone1.game.graphics.Image;
import de.openhpi.capstone1.game.logic.Lives;
import de.openhpi.capstone1.game.model.Counter;
import processing.core.PApplet;

public class ViewLives extends AbstractView{
	
	protected Lives lives;
	protected Image image;
	protected int endlinePosition;
	
	public ViewLives(PApplet display, Counter counter, Player player) {
		super(display);
		this.lives = player.getLives();
		this.image = new Image(display, "Heart");
		int screenHeight = FileReader.readConfiguration(display, "screenHeight");
		int endlinePositionFromBottom = FileReader.readConfiguration(display, "endlinePositionFromBottom");
		this.endlinePosition = screenHeight - endlinePositionFromBottom;
	}
	
	public void setDefaultConfigurations() {
		// not sure what to write here
	}
	
	public void displayNumberOfLives() {
		display.textSize(40);
		display.fill(255);
		display.text(lives.getNumberOfLives() + "", 115, this.endlinePosition + 40);	// display.text (text, x, y);
	}
	
	public void displayLives() {
		int x = 160;
		for (int live = 0; live < lives.getNumberOfLives(); live++) {
			display.fill(255);
			image.draw(x, this.endlinePosition + 10);
			x = x + 50;
		}
	}
	
	public void update() {
		display.fill(0);
		displayLives();
		displayNumberOfLives();
	}
}
