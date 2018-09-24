package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.model.Counter;
import de.openhpi.capstone1.game.view.DamageManager;
import processing.core.PApplet;

public class CounterControllerStrategy {
	private Controller counterController;
	
	public CounterControllerStrategy(PApplet display, Counter counter, DamageManager shotManager) {
		this.counterController = new CounterController(display, counter, shotManager);
	}
	
	public void handleEvent(PApplet display) {
		counterController.handleEvent(display);
	}
	
}
