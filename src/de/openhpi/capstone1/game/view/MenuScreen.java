package de.openhpi.capstone1.game.view;

import processing.core.PApplet;

public class MenuScreen extends AbstractView{
	
	public MenuScreen(PApplet display) {
		super(display);
	}
	
	@Override
	public void update() {
		display.background(0);
		display.textSize(140);
		display.fill(255);
		display.text("SPACE", 350, 200);
		display.text("INVADERS", 230, 350);
		display.textSize(50);
		display.fill(0);
		display.rect(330, 440, 480, 100, 7);
		display.rect(330, 550, 480, 100, 7);
		display.fill(255);
		display.textSize(60);
		display.text("ONE PLAYER", 380, 510);
		display.text("TWO PLAYERS", 375, 620);
	}

}
