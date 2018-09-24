package de.openhpi.capstone1.game.view;

import processing.core.PApplet;

public class Points extends AbstractView {
	private int numberOfAliensDead;
	
	public Points(PApplet display) {
		super(display);
	}
	
	public void showPoints() {
		display.textSize(28);
		display.fill(255);
		display.text((numberOfAliensDead * 10) + "", 130, 70);
	}

	public void updateNumberOfAliensDead(int numberOfAliensDead) {
		this.numberOfAliensDead = this.numberOfAliensDead + numberOfAliensDead;
	}
	
	public int getNumberOfAliensDead() {
		return this.numberOfAliensDead;
	}
	
	@Override
	public void update() {
		display.fill(0);
		showPoints();
	}

}
