package de.openhpi.capstone1.game.model;

import de.openhpi.capstone1.game.graphics.FileReader;
import de.openhpi.capstone1.game.graphics.Image;
import de.openhpi.capstone1.game.view.DamageManager;
import processing.core.PApplet;

public class Keyboard {
	
	private boolean right;
	private boolean left;
	private boolean space;
	private DamageManager damageManager;
	private Counter counter;
	private int shotStartingY;
	private int maxDisplacement;
	private int minDisplacement;
	
	public Keyboard(PApplet display) {
		right = false;
		left = false;
		space = false;
		int screenHeight = FileReader.readConfiguration(display, "screenHeight");
		int endlinePositionFromBottom = FileReader.readConfiguration(display, "endlinePositionFromBottom");
		Image image = new Image(display, "Ship");
		this.shotStartingY = screenHeight - endlinePositionFromBottom - image.getSizeY();
		int screenWidth = FileReader.readConfiguration(display, "screenWidth");
		int sideBorderSize = FileReader.readConfiguration(display, "sideBorderSize");
		this.maxDisplacement = screenWidth - sideBorderSize - image.getSizeX();
		this.minDisplacement = sideBorderSize;	
	}
	
	public void checkMove(int count) {
		if ((counter.getCount() + count) > maxDisplacement) {	// MAX displacement
			counter.updateCount(maxDisplacement - counter.getCount()); 
		}
		else if ((counter.getCount() + count) < minDisplacement) {	// MIN displacement
			counter.updateCount(counter.getCount() - minDisplacement);
		}
		else counter.updateCount(count);
	}
	
	public void addDamageManager(DamageManager damageManager) {
		this.damageManager = damageManager;
	}
	
	public void addCounter(PApplet display, Counter counter) {
		this.counter = counter;
		int screenWidth = FileReader.readConfiguration(display, "screenWidth");
		counter.setCount(screenWidth/2);
	}
	
	public void pressRight() {
		right = true;
	}
	
	public void pressLeft() {
		left = true;
	}
	
	public void pressSpace() {
		space = true;
	}
	
	public void releaseRight() {
		right = false;
	}
	
	public void releaseLeft() {
		left = false;
	}
	
	public void releaseSpace() {
		space = false;
	}
	
	public void update() {
		try {
			if(right) {
				checkMove(5);
			} else if(left) {
				checkMove(-5);
			}
			if(space) {
				damageManager.friendlyShot(counter.getCount() + 15, this.shotStartingY - 10);
			}
		} catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
}
