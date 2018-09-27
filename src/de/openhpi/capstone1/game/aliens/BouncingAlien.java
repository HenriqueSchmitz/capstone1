package de.openhpi.capstone1.game.aliens;

import de.openhpi.capstone1.game.graphics.FileReader;
import de.openhpi.capstone1.game.model.Mover;
import de.openhpi.capstone1.game.view.AbstractAlien;
import de.openhpi.capstone1.game.view.DamageManager;
import processing.core.PApplet;

public class BouncingAlien extends AbstractAlien{
	
	private Mover movementX;
	
	public BouncingAlien(PApplet display, int posX, int posY) {
		super(display, posX, posY, "SpaceInvader");
		double alienSideSpeed = FileReader.readConfigurationDouble(display, "alienSideSpeed");
		int alienSpacingX = FileReader.readConfiguration(display, "alienSpacingX");
		movementX = new Mover(display, posX, alienSideSpeed);
		movementX.setBounceOn();
		movementX.setMaxPosition(posX + 3 * alienSpacingX);
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
	
	@Override
	public int getPosX() {
		return movementX.getPosition();
	}
}

