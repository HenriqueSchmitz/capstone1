package de.openhpi.capstone1.game.aliens;

import java.util.ArrayList;

import de.openhpi.capstone1.game.graphics.FileReader;
import de.openhpi.capstone1.game.model.Mover;
import de.openhpi.capstone1.game.view.AbstractAlien;
import de.openhpi.capstone1.game.view.DamageManager;
import processing.core.PApplet;

public class BouncingAlien extends AbstractAlien{
	private int lastShotTime;
	private Mover movementX;
	
	public BouncingAlien(PApplet display, int posX, int posY) {
		super(display, posX, posY, "SpaceInvader");
		double alienSideSpeed = FileReader.readConfigurationDouble(display, "alienSideSpeed");
		int alienSpacingX = FileReader.readConfiguration(display, "alienSpacingX");
		movementX = new Mover(display, posX, alienSideSpeed);
		movementX.setBounceOn();
		movementX.setMaxPosition(posX + 3 * alienSpacingX);
		
		this.colors = new ArrayList<Float>();
		colors.add((float) 255);
		colors.add((float) 0);
		colors.add((float) 0);
	}
	
	public void shoot(DamageManager damageManager) {
		if(this.isAlive()) {
			if(this.display.millis() > lastShotTime + 2000) {
				damageManager.enemyShot(movementX.getPosition() + (this.image.getSizeX()/2), this.movement.getPosition() + this.image.getSizeY());
				lastShotTime = this.display.millis();
			}
		}
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
	
	@Override
	public int getPosX() {
		return movementX.getPosition();
	}
}

