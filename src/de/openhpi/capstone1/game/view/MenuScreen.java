package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.graphics.Image;
import processing.core.PApplet;

public class MenuScreen extends AbstractView{
	private Image image;
	
	public MenuScreen(PApplet display) {
		super(display);
		image = new Image(display, "Ship");
	}
	
	public void setDefaultConfigurations() {
		// not sure what to write here
	}
	
	@Override
	public void update() {
		display.background(0);
		display.textSize(140);
		display.fill(255);
		display.text("SPACE", 350, 200);
		display.text("INVADERS", 230, 350);
		display.textSize(50);
		display.text("CLICK TO START", 370, 520);
		image.draw(300, 480);
		image.draw(800, 480);
	}

}
