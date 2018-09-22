package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.logic.Enemy;
import de.openhpi.capstone1.game.model.Counter;
import processing.core.PApplet;

public class CounterViewEnemies extends AbstractCounterView{
	
	public CounterViewEnemies(PApplet display, Counter counter) {
		super(display, counter);
		this.enemy = new Enemy();
	}
	
	public void displayEnemies() {
		// display the enemies
		if (enemy.getNumberOfEnemies() != 0) {
			
		}
	}
	
	public void createEnemies() {
		if (enemy.isRandomize()) {
			//enemy.randomizeNumberOfEnemies();
			enemy.setRandomize(false);
		}
	}
	
	public void update() {
	}

}
