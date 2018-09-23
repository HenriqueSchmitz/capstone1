package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.graphics.Image;
import processing.core.PApplet;

public class MenuScreen extends AbstractView{
	Image image;
	
	public MenuScreen(PApplet display) {
		super(display);
		//screen = new String("MenuScreen");
		image = new Image(display, "Ship");
	}
	
	@Override
	public void update() {
		display.background(0);
		display.textSize(120);
		display.fill(255);
		display.text("SPACE", 260, 200);
		display.text("INVADERS", 170, 320);
		display.textSize(30);
		display.text("CLICK TO START", 320, 410);
		image.draw(270, 380);
		image.draw(570, 380);
		if (display.mousePressed) {
			//screen = "GameScreen";
		}
	}

}
