package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.model.Keyboard;
import de.openhpi.capstone1.game.view.DamageManager;
import processing.core.PApplet;

public class CounterController implements Controller {

	private Keyboard keyboard;


	public CounterController(Keyboard keyboard, DamageManager shotManager) { 
		this.keyboard = keyboard;
	}

	@Override
	public void handleEvent(PApplet display) {
		
	}
	
	@Override
	public void handlePress(PApplet display) {
		if (display.key == PApplet.CODED) {	//	moving
			if (display.keyCode == PApplet.RIGHT) {	// moving right
				keyboard.pressRight();
			}
			else if (display.keyCode == PApplet.LEFT) {	// moving left
				keyboard.pressLeft();
			}
		}
		if (display.key == ' ') {	// shooting
			keyboard.pressSpace();
		}
	}

	@Override
	public void handleRelease(PApplet display) {
		if (display.key == PApplet.CODED) {	//	moving
			if (display.keyCode == PApplet.RIGHT) {	// moving right
				keyboard.releaseRight();
			}
			else if (display.keyCode == PApplet.LEFT) {	// moving left
				keyboard.releaseLeft();
			}
		}
		if (display.key == ' ') {	// shooting
			keyboard.releaseSpace();
		}
	}
}
