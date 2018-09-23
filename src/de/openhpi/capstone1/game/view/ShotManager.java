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
		screen = new String("GameScreen");
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
		for(Shot shot: friendlyShots) {
			shot.update();
		}
	}
}
