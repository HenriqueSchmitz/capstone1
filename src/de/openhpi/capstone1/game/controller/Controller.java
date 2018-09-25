package de.openhpi.capstone1.game.controller;

import processing.core.PApplet;

public interface Controller {
	void handleEvent(PApplet display);
	public void handlePress(PApplet display);
	public void handleRelease(PApplet display);
}
