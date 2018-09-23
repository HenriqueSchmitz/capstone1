package de.openhpi.capstone1.game.starter;

import de.openhpi.capstone1.game.builder.InteractiveComponent;
import de.openhpi.capstone1.game.builder.GUIComponent;
import de.openhpi.capstone1.game.builder.InteractiveCounterBuilder;
import de.openhpi.capstone1.game.graphics.Image;
import de.openhpi.capstone1.game.model.Mover;

// 0 up

import processing.core.PApplet;

public class TheApp extends PApplet {

	InteractiveComponent interactiveCounter;
	private int stage = 1;
	
	@Override
	public void settings() {
		size(1200, 750);	// (width, height)
	}

	@Override
	public void setup() {  // setup() runs once
		frameRate(30);	// number of frames to be displayed every second
		surface.setTitle("SPACE INVADERS");
		InteractiveCounterBuilder builder = new InteractiveCounterBuilder();
		GUIComponent.construct(this, builder);
		interactiveCounter = builder.getComponent();
	}

	public void displayGameScreen() {
		background(0);
		interactiveCounter.update();
	}
	
	public void displayMainMenuScreen() {	// testing
		background(0);
		textSize(60);
		fill(255);
		text("SPACE INVADERS", 150, 100);
	}
	
	@Override
	public void draw() {  // draw() loops forever, until stopped
		background(0);	// 0 -> black color	| 255 -> white color
		displayGameScreen();
	}
	
	//Add further user interaction as necessary
	@Override
	public void keyPressed() {
		if (key == CODED) {	//	moving
			if (keyCode == RIGHT) {	// moving right
				interactiveCounter.handleEvent(5);
			}
			if (keyCode == LEFT) {	// moving left
				interactiveCounter.handleEvent(-5);
			}
		}
		if (key == ' ') {	// shooting
			interactiveCounter.handleEvent(0);
		}
	}
	
	@Override
	public void keyReleased() {
		
	}
}
