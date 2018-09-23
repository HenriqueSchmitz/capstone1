package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.graphics.FileReader;
import de.openhpi.capstone1.game.graphics.Image;
import de.openhpi.capstone1.game.model.Mover;
import processing.core.PApplet;

public class Shot extends AbstractView {
	
	protected Image image;
	protected Mover movement;
	protected int posX;
	protected int posY;
	protected boolean isFriendly;
	
	public Shot(PApplet display, int posX, int posY, boolean isFriendly) {
		super(display);
		this.posX = posX;
		this.posY = posY;
		this.isFriendly = isFriendly;
		double shotSpeed = FileReader.readConfigurationDouble(display, "shotSpeed");
		movement = new Mover(display, posY, shotSpeed);
		if(this.isFriendly) {
			movement.setDirectionNegative();
		}
		image = new Image(display, "Shot");
		screen = new String("GameScreen");
	}

	@Override
	public void update() {
		image.draw(posX, movement.getPosition());
	}
	
	
}
