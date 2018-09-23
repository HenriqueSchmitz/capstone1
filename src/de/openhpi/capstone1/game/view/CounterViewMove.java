package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.graphics.Image;
import de.openhpi.capstone1.game.model.Counter;
import processing.core.PApplet;

public class CounterViewMove extends AbstractCounterView { 
	
	Image image;
	
	public CounterViewMove(PApplet display, Counter counter) {
		super(display, counter);
		image = new Image(display, "Ship");
		screen = new String("GameScreen");
	}
	
	public void update() {
		try {
			int x = counter.getCount();
			display.fill(255);
			image.draw(x, 460);
			//display.rect(x, 485, counter.getWidth(), counter.getHeight(), 2);	// I'm using rectangles for the moment
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
