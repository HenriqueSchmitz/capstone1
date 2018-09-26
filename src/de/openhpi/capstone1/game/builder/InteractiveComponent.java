package de.openhpi.capstone1.game.builder;

import java.util.ArrayList;

import de.openhpi.capstone1.game.model.Keyboard;
import de.openhpi.capstone1.game.view.AbstractView;
import processing.core.PApplet;

public abstract class InteractiveComponent {
	public abstract void handleEvent(PApplet display);
	public abstract void handleScreen(PApplet display);
	public abstract void handlePress(PApplet display);
	public abstract void handleRelease(PApplet display);
	protected ArrayList<AbstractView> game;
	protected ArrayList<AbstractView> menu;
	protected ArrayList<AbstractView> gameOver;
	protected String view;
	protected ArrayList<Keyboard> keyboards;
	
	public void setDefaultConfigurations() {
		for (AbstractView view : game) {
			view.setDefaultConfigurations(); 
		}
	}
	
	public void setView(String view) {
		this.view = view;
	}
	
	public void update() {
		try {
			for (Keyboard keyboard: keyboards) {
				keyboard.update();
			}
		} catch(NullPointerException e) {
			
		}
		
		if (view.equals("GameScreen")) {
			for (AbstractView view : game) {
				view.update(); 
			}
		}
		else if (view.equals("MenuScreen")) {
			for (AbstractView view : menu) {
				view.update(); 
			}
		}
		else if (view.equals("GameOverScreen")) {
			for (AbstractView view : gameOver) {
				view.update(); 
			}
		}
	}
}
