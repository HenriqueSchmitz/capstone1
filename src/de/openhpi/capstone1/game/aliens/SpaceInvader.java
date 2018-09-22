package de.openhpi.capstone1.game.aliens;

import de.openhpi.capstone1.game.view.AbstractAlien;
import processing.core.PApplet;

public class SpaceInvader extends AbstractAlien{

	public SpaceInvader(PApplet display, int posX, int posY) {
		super(display, posX, posY, "SpaceInvader");
		
	}
	
	public void attack() {
		
	}
	
	protected void setHealthPoints() {
		this.healthPoints = 2;
	}
	
	protected void setScoreValue() {
		this.scoreValue = 10;
	}
	
	
}
