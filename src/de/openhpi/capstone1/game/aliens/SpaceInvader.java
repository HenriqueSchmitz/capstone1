package de.openhpi.capstone1.game.aliens;

import java.util.ArrayList;

import de.openhpi.capstone1.game.view.AbstractAlien;
import de.openhpi.capstone1.game.view.DamageManager;
import processing.core.PApplet;

public class SpaceInvader extends AbstractAlien{
	
	public SpaceInvader(PApplet display, int posX, int posY) {
		super(display, posX, posY, "SpaceInvader");
		
		this.colors = new ArrayList<Float>();
		colors.add((float) 0);
		colors.add((float) 32);
		colors.add((float) 155);
	}
	
	public void shoot(DamageManager damageManager) {
		
	}
	
	protected void setHealthPoints() {
		this.lives.setNumberOfLives(2);
	}
	
	protected void setScoreValue() {
		this.scoreValue = 10;
	}
	
	public void setDefaultConfigurations() {
		this.lives.setNumberOfLives(2);
	}
	
}

