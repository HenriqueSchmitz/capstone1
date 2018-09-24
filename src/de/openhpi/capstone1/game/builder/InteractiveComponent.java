package de.openhpi.capstone1.game.builder;

import java.util.ArrayList;
import de.openhpi.capstone1.game.view.AbstractView;
import processing.core.PApplet;

public abstract class InteractiveComponent {
	public abstract void handleEvent(PApplet display);
	public abstract void handleScreen(PApplet display);
	protected ArrayList<AbstractView> game;
	protected ArrayList<AbstractView> menu;
	protected String view;
	
	public void setView(String view) {
		this.view = view;
	}
	
	public void update() {
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
		else if (view.equals("GameOver")) {
			System.out.println("GameOver screen called");
			//Insert the game over screen here and delete the println
		}
	}
}
