package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.graphics.FileReader;
import processing.core.PApplet;

public class Points extends AbstractView {
	private int numberOfAliensDead;
	private int sideBorderSize;
	
	public Points(PApplet display) {
		super(display);
		this.sideBorderSize = FileReader.readConfiguration(display, "sideBorderSize");
	}
	
	public void showPoints() {
		display.textSize(28);
		display.fill(255);
		display.textAlign(PApplet.CENTER);
		display.text((numberOfAliensDead * 10) + "", sideBorderSize*2, 70);
		display.textAlign(PApplet.LEFT);
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
