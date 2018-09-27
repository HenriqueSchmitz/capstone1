package de.openhpi.capstone1.game.controller;

import java.util.ArrayList;

import de.openhpi.capstone1.game.model.Keyboard;
import de.openhpi.capstone1.game.view.DamageManager;
import processing.core.PApplet;

public class CounterControllerStrategy {
	private ArrayList<Controller> controllers;
	
	public CounterControllerStrategy() {
		controllers = new ArrayList<Controller>();
	}
	
	public void handleEvent(PApplet display) {
		for (Controller controller: controllers) {
			controller.handleEvent(display);
		}
	}
	
	public void handlePress(PApplet display) {
		for (Controller controller: controllers) {
			controller.handlePress(display);
		}
	}
	
	public void handleRelease(PApplet display) {
		for (Controller controller: controllers) {
			controller.handleRelease(display);
		}
	}
	
	public void addPlayer( Keyboard keyboard, DamageManager damageManager) {
		if(controllers.size() == 0) {
			controllers.add(new CounterController2(keyboard, damageManager));
		}
		else {
			controllers.add(new CounterController1(keyboard, damageManager));
		}
	}	
}
