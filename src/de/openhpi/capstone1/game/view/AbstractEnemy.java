package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.graphics.Image;
import de.openhpi.capstone1.game.logic.Lives;
import de.openhpi.capstone1.game.model.BoundingBox;
import de.openhpi.capstone1.game.model.Mover;
import processing.core.PApplet;

public abstract class AbstractEnemy extends AbstractView{
	
	protected Mover movement;
	protected Image image;
	protected BoundingBox boundingBox;
	protected Lives lives;
	protected int scoreValue;
	protected int posX;
	protected int posY;
	
	public AbstractEnemy(PApplet display) {
		super(display);
		boundingBox = new BoundingBox();
	}
	
	public AbstractEnemy(PApplet display, int posX, int posY, String imageName) {
		super(display);
		this.posX = posX;
		this.posY = posY;
		this.lives = new Lives();
		this.boundingBox = new BoundingBox();
		this.image = new Image(display, imageName);
		setHealthPoints();
		setScoreValue();
	}
	
	protected abstract void setHealthPoints();
	protected abstract void setScoreValue();
	
	public void takeDamage(Points points) {
		if(lives.isAlive()) {
			lives.takeDamage();
	
			if (!lives.isAlive()) {
				points.updateScore(this.scoreValue);
			}
		}
	}
	
	public void die(Points points) {
		this.lives.die();
		points.updateScore(this.scoreValue);
	}
	
 	public boolean isAlive() {
		return lives.isAlive();
	}
 	
 	public int getPosX() {
 		return this.posX;
 	}
 	
 	public int getPosY() {
 		return this.movement.getPosition();
 	}
	
 	public BoundingBox getBoundingBox() {
 		boundingBox.update(this.getPosX(), this.getPosY(), image.getSizeX(), image.getSizeY());
 		return this.boundingBox;
 	}
	
	public int getSpawnTime() {
		return this.movement.getStartTime();
	}
	
	public void setSpawnTime(int spawnTime) {
		this.movement.setStartTime(spawnTime);
	}
 	
	public abstract void shoot(DamageManager damageManager);
	
}
