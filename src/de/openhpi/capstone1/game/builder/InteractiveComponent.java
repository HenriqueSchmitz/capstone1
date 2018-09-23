package de.openhpi.capstone1.game.builder;

import java.util.ArrayList;

import de.openhpi.capstone1.game.view.AbstractView;

public abstract class InteractiveComponent {
	public abstract void handleEvent(int count);
	protected ArrayList<AbstractView> game;
	protected ArrayList<AbstractView> menu;
	
	public void update() {
		for (AbstractView view : game) {
			view.update(); 
		}
	}
}
