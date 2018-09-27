package de.openhpi.capstone1.game.aliens;

import java.util.ArrayList;

import de.openhpi.capstone1.game.view.AbstractAlien;
import de.openhpi.capstone1.game.view.DamageManager;
import processing.core.PApplet;

public class ShooterAlien extends AbstractAlien{
	
	private int lastShotTime;
	
	public ShooterAlien(PApplet display, int posX, int posY) {
		super(display, posX, posY, "ShooterAlien");
		lastShotTime = this.display.millis();
		
		this.colors = new ArrayList<Float>();
		colors.add((float) 200);
		colors.add((float) 200);
		colors.add((float) 0);
	}
	
	public void shoot(DamageManager damageManager) {
		if(this.isAlive()) {
			if(this.display.millis() > lastShotTime + 3000) {
				damageManager.enemyShot(this.posX + (this.image.getSizeX()/2), this.movement.getPosition() + this.image.getSizeY());
				lastShotTime = this.display.millis();
			}
		}
	}
	
	protected void setHealthPoints() {
		this.lives.setNumberOfLives(1);
	}
	
	protected void setScoreValue() {
		this.scoreValue = 20;
	}

	public void setDefaultConfigurations() {
		this.setHealthPoints();
	}

}
