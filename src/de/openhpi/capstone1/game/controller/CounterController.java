package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.logic.Shot;
import de.openhpi.capstone1.game.model.Counter;
import processing.core.PApplet;

public class CounterController implements Controller {

	Counter counter;
	Shot shot;	

	public CounterController(Counter counter, Shot shot) { 
		this.counter = counter;
		this.counter.updateCount(100);
		this.shot = shot;
	}
	
	public void checkMove(int count) {
		if ((counter.getCount() + count) > 770) {	// MAX displacement
			counter.updateCount(770 - counter.getCount());
		}
		else if ((counter.getCount() + count) < 100) {	// MIN displacement
			counter.updateCount(counter.getCount() - 100);
		}
		else counter.updateCount(count);
	}
	
	public void handleEvent(PApplet display) {
		if (display.key == display.CODED) {	//	moving
			if (display.keyCode == display.RIGHT) {	// moving right
				checkMove(5);
			}
			else if (display.keyCode == display.LEFT) {	// moving left
				checkMove(-5);
			}
		}
		if (display.key == ' ') {	// shooting
			shot.firstShot(counter.getCount() ,485 - counter.getHeight()/2);
		}
	}

}
