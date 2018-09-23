package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.graphics.FileReader;
import de.openhpi.capstone1.game.model.Mover;
import processing.core.PApplet;

public abstract class AbstractAlien extends AbstractEnemy{
	
	public AbstractAlien(PApplet display, int posX, int posY, String imageName) {
		super(display, posX, posY, imageName);
		double alienSpeed = FileReader.readConfigurationDouble(display, "alienSpeed");
		movement = new Mover(display, posY, alienSpeed);
	}
	
	@Override
	public void update() {
		if(isAlive()) {
			image.draw(posX, movement.getPosition());
		}
	}
}
