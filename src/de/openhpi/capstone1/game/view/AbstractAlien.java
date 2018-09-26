/*package de.openhpi.capstone1.game.view;

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
}*/

package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.graphics.FileReader;
import de.openhpi.capstone1.game.model.Mover;
import processing.core.PApplet;

public abstract class AbstractAlien extends AbstractEnemy{
	
	static String alienImage = "SpaceInvader";
	static String alienImage2 = "SpaceInvader2";
	
	public AbstractAlien(PApplet display, int posX, int posY, String imageName) {
		super(display, posX, posY, imageName);
		double alienSpeed = FileReader.readConfigurationDouble(display, "alienSpeed");
		movement = new Mover(display, posY, alienSpeed);
	}
	
	@Override
	public void update() {
		if(isAlive()) {
			image.draw(posX, movement.getPosition());
			int temp = (Math.random() <= 0.5) ? 1 : 2;
			
			if ( temp == 1 ) {
				image.updateImage(alienImage2);
			} else {
				image.updateImage(alienImage);
			}
		}
	}
}
