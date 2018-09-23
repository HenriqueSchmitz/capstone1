package de.openhpi.capstone1.game.builder;

import java.util.ArrayList;

import de.openhpi.capstone1.game.view.AbstractView;

public abstract class InteractiveComponent {
	public abstract void handleEvent(int count);
	protected ArrayList<AbstractView> views; 
	
	public void update() {
		for (AbstractView view : views) {
			view.update(); 
		}
	}
}
