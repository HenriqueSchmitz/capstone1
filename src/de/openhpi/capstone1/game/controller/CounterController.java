package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.graphics.FileReader;
import de.openhpi.capstone1.game.graphics.Image;
import de.openhpi.capstone1.game.model.Counter;
import de.openhpi.capstone1.game.view.DamageManager;
import processing.core.PApplet;

public class CounterController implements Controller {

	private PApplet display;
	private Counter counter;
	private DamageManager shotManager;
	private int shotStartingY;

	public CounterController(PApplet display, Counter counter, DamageManager shotManager) { 
		this.display = display;
		this.counter = counter;
		this.counter.updateCount(100);
		this.shotManager = shotManager;
		int screenHeight = FileReader.readConfiguration(display, "screenHeight");
		int endlinePositionFromBottom = FileReader.readConfiguration(display, "endlinePositionFromBottom");
		Image image = new Image(display, "Ship");
		this.shotStartingY = screenHeight - endlinePositionFromBottom - image.getSizeY();
	}
	
	public void checkMove(int count) {
		if ((counter.getCount() + count) > 900) {	// MAX displacement
			counter.updateCount(900 - counter.getCount()); 
		}
		else if ((counter.getCount() + count) < 100) {	// MIN displacement
			counter.updateCount(counter.getCount() - 100);
		}
		else counter.updateCount(count);
	}
	
	public void handleEvent(PApplet display) {
		if (display.key == PApplet.CODED) {	//	moving
			if (display.keyCode == PApplet.RIGHT) {	// moving right
				checkMove(5);
			}
			else if (display.keyCode == PApplet.LEFT) {	// moving left
				checkMove(-5);
			}
		}
		if (display.key == ' ') {	// shooting
			shotManager.friendlyShot(counter.getCount() + 15, this.shotStartingY - 10);
		}
	}
	

}
