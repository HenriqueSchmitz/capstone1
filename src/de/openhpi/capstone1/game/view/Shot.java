package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.graphics.FileReader;
import de.openhpi.capstone1.game.graphics.Image;
import de.openhpi.capstone1.game.model.BoundingBox;
import de.openhpi.capstone1.game.model.Mover;
import processing.core.PApplet;

public class Shot extends AbstractView {
	
	protected Image image;
	protected Mover movement;
	protected BoundingBox boundingBox;
	protected int posX;
	protected int posY;
	protected boolean isFriendly;
	protected int identificationNumber;
	
	public Shot(PApplet display, int posX, int posY, boolean isFriendly, int identificationNumber) {
		super(display);
		this.boundingBox = new BoundingBox();
		
		this.posX = posX;
		this.posY = posY;
		this.isFriendly = isFriendly;
		this.identificationNumber = identificationNumber;
		double shotSpeed = FileReader.readConfigurationDouble(display, "shotSpeed");
		movement = new Mover(display, posY, shotSpeed);
		if(this.isFriendly) {
			movement.setDirectionNegative();
		}
		image = new Image(display, "Shot");
	}
	
	public int getIdentificationNumber() {
		return this.identificationNumber;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return movement.getPosition();
	}
	
	public BoundingBox getBoundingBox() {
		this.boundingBox.update(this.getPosX(), this.getPosY(), image.getSizeX(), image.getSizeY());
		return this.boundingBox;
	}

	@Override
	public void update() {
		image.draw(posX, movement.getPosition());
	}
	
	
}
