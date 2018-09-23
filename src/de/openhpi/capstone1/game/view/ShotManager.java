package de.openhpi.capstone1.game.view;

import java.util.ArrayList;

import de.openhpi.capstone1.game.graphics.FileReader;
import processing.core.PApplet;

public class ShotManager extends AbstractView {

	private ArrayList<AbstractEnemy> enemies;
	private ArrayList<Shot> friendlyShots;
	private int minimumShotDistance;
	
	public ShotManager(PApplet display) {
		super(display);
		enemies = new ArrayList<AbstractEnemy>();
		friendlyShots = new ArrayList<Shot>();
		minimumShotDistance = FileReader.readConfiguration(display, "minimumShotDistance");
	}
	
	public void addEnemy(AbstractEnemy enemy) {
		enemies.add(enemy);
	}
	
	public void friendlyShot(int posX, int posY) {
		if(friendlyShots.size() == 0) {
			friendlyShots.add(new Shot(this.display, posX, posY, true));
		}
		else {
			Shot mostRecentShot = friendlyShots.get(friendlyShots.size() - 1);
			if(mostRecentShot.movement.getPosition() < mostRecentShot.posY - minimumShotDistance) {
				friendlyShots.add(new Shot(this.display, posX, posY, true));
			}
		}
	}
	
	public void update() {
		for(int shot = 0; shot < friendlyShots.size(); shot++) {
			for(AbstractEnemy targetEnemy: this.enemies) {
				if(targetEnemy.isAlive()) {
					if(this.friendlyShots.get(shot).getBoundingBox().checkCollision(targetEnemy.getBoundingBox())) {
						this.friendlyShots.remove(shot);
						targetEnemy.takeDamage();
						break;
					}
				}
			}
		}
		
		for(Shot shot: friendlyShots) {
			shot.update();
		}
		
	}
}