package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.logic.Shot;
import de.openhpi.capstone1.game.model.Counter;
import processing.core.PApplet;

public class CounterViewShots extends AbstractCounterView{

	public CounterViewShots(PApplet display, Counter counter, Shot shot) {
		super(display, counter);
		this.shot = shot;
		screen = new String("GameScreen");
	}

	public void displayShots() {
		// display the number of shots (dots/lines)
		for (int index = 0; index < shot.getShotXPosition().size(); index++) {
			if (shot.getShotXPosition().get(index) != 0) {
				display.strokeWeight(2);	
				display.stroke(255);	// line color
				display.fill(0);
				display.line(shot.getShotXPosition().get(index) + counter.getWidth()/2, shot.getShotYPosition().get(index), shot.getShotXPosition().get(index) + counter.getWidth()/2 + 1, shot.getShotYPosition().get(index) - 10);
				/*display.fill(255);
				display.rect(counter.getCountShotsX(), counter.getCountShotsY() - 3, 15, 15, 2);	// I'm using rectangles for the moment*/
			}
		}
	}
	
	public void update() {
		display.fill(0);
		if (!(shot.getShotXPosition().isEmpty())) {
			shot.checkShoot(-5);	// -5 on the Y axis. Makes the shot go up
			displayShots();
		}
	}
}
