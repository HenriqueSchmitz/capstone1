package de.openhpi.capstone1.game.builder;

import processing.core.PApplet;

public interface Builder {
	public void buildComponent(PApplet applet);
	public void buildModel(); 
	public void buildView(PApplet applet);
	public void buildController(PApplet applet);
	
	public InteractiveComponent getComponent();
}
