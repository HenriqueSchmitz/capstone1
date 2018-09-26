package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.model.Keyboard;
import de.openhpi.capstone1.game.view.DamageManager;
import processing.core.PApplet;

public class CounterController2 implements Controller {

	private Keyboard keyboard;

	public CounterController2(Keyboard keyboard, DamageManager shotManager) { 
		this.keyboard = keyboard;
	}

	@Override
	public void handleEvent(PApplet display) {
		
	}
	
	@Override
	public void handlePress(PApplet display) {
		if ((display.key == 'd') || (display.key == 'D')) {
			keyboard.pressRight();
		}
		else if ((display.key == 'a') || (display.key == 'A')){
			keyboard.pressLeft();
		}
		if ((display.key == 'w') || (display.key == 'W')){	// shooting
			keyboard.pressSpace();
		}
	}

	@Override
	public void handleRelease(PApplet display) {
		if ((display.key == 'd') || (display.key == 'D')) {
			keyboard.releaseRight();
		}
		else if ((display.key == 'a') || (display.key == 'A')) {
			keyboard.releaseLeft();
		}
		if ((display.key == 'w') || (display.key == 'W')) {	// shooting
			keyboard.releaseSpace();
		}
	}
}