package de.openhpi.capstone1.game.controller;

import java.util.ArrayList;

import de.openhpi.capstone1.game.model.Keyboard;
import de.openhpi.capstone1.game.view.DamageManager;
import processing.core.PApplet;

public class CounterControllerStrategy {
	private ArrayList<Controller> controllers;
	
	public CounterControllerStrategy(PApplet display, ArrayList<Keyboard> keyboards, ArrayList<DamageManager> shotManagers) {
		controllers = new ArrayList<Controller>();
		controllers.add(new CounterController2(keyboards.get(0), shotManagers.get(0)));
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
	
	public void addSecondPlayer( ArrayList<Keyboard> keyboards, ArrayList<DamageManager> shotManagers) {
		controllers.add(new CounterController1(keyboards.get(1), shotManagers.get(1)));
	}
	
	/*private Controller counterController1;
	private Controller counterController2;
	
	public CounterControllerStrategy(PApplet display, ArrayList<Keyboard> keyboards, ArrayList<DamageManager> shotManagers) {
		this.counterController1 = new CounterController1(keyboards.get(1), shotManagers.get(0));
		this.counterController2 = new CounterController2(keyboards.get(0), shotManagers.get(1));
	}
	
	public void handleEvent(PApplet display) {
		counterController1.handleEvent(display);
		counterController2.handleEvent(display);
	}
	
	public void handlePress(PApplet display) {
		counterController1.handlePress(display);
		counterController2.handlePress(display);
	}
	
	public void handleRelease(PApplet display) {
		counterController1.handleRelease(display);
		counterController2.handleRelease(display);
	}
	
	public void addSecondPlayer() {
		
	}*/
	
}
