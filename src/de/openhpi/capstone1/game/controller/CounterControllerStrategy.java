package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.model.Keyboard;
import de.openhpi.capstone1.game.view.DamageManager;
import processing.core.PApplet;

public class CounterControllerStrategy {
	private Controller counterController;
	
	public CounterControllerStrategy(PApplet display, Keyboard keyboard, DamageManager shotManager) {
		this.counterController = new CounterController(keyboard, shotManager);
	}
	
	public void handleEvent(PApplet display) {
		counterController.handleEvent(display);
	}
	
	public void handlePress(PApplet display) {
		counterController.handlePress(display);
	}
	
	public void handleRelease(PApplet display) {
		counterController.handleRelease(display);
	}
	
}
