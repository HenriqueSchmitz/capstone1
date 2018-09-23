package de.openhpi.capstone1.game.builder;

import java.util.ArrayList;
import de.openhpi.capstone1.game.view.AbstractView;
import processing.core.PApplet;

public abstract class InteractiveComponent {
	public abstract void handleEvent(PApplet display);
	protected ArrayList<AbstractView> views; 
	protected String screen;
	
	public void update() {
		for (AbstractView view : views) {
			if (screen.equals(view.screen)) {
				view.update(); 
			}
		}
	}
}
