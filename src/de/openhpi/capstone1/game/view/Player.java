package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.graphics.Image;
import de.openhpi.capstone1.game.logic.Lives;
import de.openhpi.capstone1.game.model.BoundingBox;
import de.openhpi.capstone1.game.model.Counter;
import processing.core.PApplet;

public class Player extends AbstractCounterView { 
	
	protected Lives lives;
	protected Image image;
	protected BoundingBox boundingBox;
	
	public Player(PApplet display, Counter counter) {
		super(display, counter);
		this.lives = new Lives();
		this.boundingBox = new BoundingBox();
		this.image = new Image(display, "Ship");
	}
	
	public BoundingBox getBoundingBox() {
		this.boundingBox.update(counter.getCount(), 470, image.getSizeX(), image.getSizeY());
		return this.boundingBox;
	}
	
	public Lives getLives() {
		return this.lives;
	}
	
	public void update() {
		try {
			int x = counter.getCount();
			display.fill(255);
			image.draw(x, 470);
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
