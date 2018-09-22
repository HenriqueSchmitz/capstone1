package de.openhpi.capstone1.game.starter;

import de.openhpi.capstone1.game.builder.GUIComponent;
import de.openhpi.capstone1.game.builder.InteractiveComponent;
import de.openhpi.capstone1.game.builder.InteractiveCounterBuilder;
import processing.core.PApplet;

public class TheApp extends PApplet {

	InteractiveComponent interactiveCounter;
	
	//https://github.com/adasilva25/SpaceInvaders.git
	
	@Override
	public void settings() {
		size(900, 600);	// (width, height)
	}

	@Override
	public void setup() {  // setup() runs once
		frameRate(30);	// number of frames to be displayed every second
		surface.setTitle("SPACE INVADERS");
		InteractiveCounterBuilder builder = new InteractiveCounterBuilder();
		GUIComponent.construct(this, builder);
		interactiveCounter = builder.getComponent();
	}
	
	@Override
	public void draw() {  // draw() loops forever, until stopped
		background(0);	
		interactiveCounter.update();
	}
	
	//Add further user interaction as necessary
	@Override
	public void keyPressed() {
		interactiveCounter.handleEvent(this);
	}
	
	public void mousePressed() {
		interactiveCounter.handleEvent(this);
	}
}
