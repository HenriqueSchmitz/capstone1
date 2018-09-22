package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.logic.Shot;
import de.openhpi.capstone1.game.model.Counter;
import processing.core.PApplet;

public class CounterControllerStrategy {
	private Controller counterController;
	
	public CounterControllerStrategy(Counter counter, Shot shot) {
		this.counterController = new CounterController(counter, shot);
	}
	
	public void handleEvent(PApplet display) {
		counterController.handleEvent(display);
	}
	
}
