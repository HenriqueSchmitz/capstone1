package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.model.Counter;
import de.openhpi.capstone1.game.view.ShotManager;

public class CounterControllerStrategy {
	private Controller counterController;
	
	public CounterControllerStrategy(Counter counter, ShotManager shotManager) {
		this.counterController = new CounterController(counter, shotManager);
	}
	
	public void handleEvent(int count) {
		counterController.handleEvent(count);
	}
	
}
