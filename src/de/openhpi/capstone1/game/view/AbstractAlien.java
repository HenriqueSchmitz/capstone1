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
			display.fill(colors.get(0), colors.get(1), colors.get(2));
			
			image.draw(getPosX(), movement.getPosition());
			
			display.fill(255);
		}
	}
}

