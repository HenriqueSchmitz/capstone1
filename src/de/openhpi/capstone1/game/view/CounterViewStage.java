package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.model.Counter;
import processing.core.PApplet;

public class CounterViewStage extends AbstractCounterView{	// stage elements

	public CounterViewStage(PApplet display, Counter counter) {
		super(display, counter);
	}
	
	@Override
	public void update() {
		display.fill(0);
		// display the line above the credits and lives
		display.strokeWeight(7);	
		display.stroke(255);	// line color
		display.line(100, 530, 800, 530);
	}
	
}
