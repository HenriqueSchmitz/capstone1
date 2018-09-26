package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.builder.InteractiveCounter;
import de.openhpi.capstone1.game.graphics.FileReader;
import de.openhpi.capstone1.game.graphics.Image;
import de.openhpi.capstone1.game.logic.Lives;
import de.openhpi.capstone1.game.model.BoundingBox;
import de.openhpi.capstone1.game.model.Counter;
import processing.core.PApplet;

public class Player extends AbstractCounterView { 
	
	private Lives lives;
	private Image image;
	private BoundingBox boundingBox;
	private InteractiveCounter interactiveCounter;
	private int playerPositionY;
	
	public Player(InteractiveCounter interactiveCounter, PApplet display) {
		super(display, new Counter(display));
		this.interactiveCounter = interactiveCounter;
		this.lives = new Lives();
		this.boundingBox = new BoundingBox();
		this.image = new Image(display, "Ship");
		
		int screenHeight = FileReader.readConfiguration(display, "screenHeight");
		int endlinePositionFromBottom = FileReader.readConfiguration(display, "endlinePositionFromBottom");
		this.playerPositionY = screenHeight - endlinePositionFromBottom - image.getSizeY() - 10;
	}
	
	public Counter getCounter() {
		return this.counter;
	}
	
	public void setDefaultConfigurations() {
		lives.setNumberOfLives(3);
	}
	
	public BoundingBox getBoundingBox() {
		this.boundingBox.update(counter.getCount(), playerPositionY, image.getSizeX(), image.getSizeY());
		return this.boundingBox;
	}
	
	public Lives getLives() {
		return this.lives;
	}
	
	public boolean isAlive() {
		return this.lives.isAlive();
	}
	
	public void takeDamage() {
		this.lives.takeDamage();
	}
	
	public void die() {
		this.lives.die();
	}
	
	public void update() {
		try {
			int x = counter.getCount();
			display.fill(255);
			image.draw(x, playerPositionY);
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
		
		if(!lives.isAlive()) {
			interactiveCounter.setView("GameOverScreen");
		}
		
	}
}
