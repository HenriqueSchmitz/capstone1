package de.openhpi.capstone1.game.view;

import java.util.ArrayList;

import de.openhpi.capstone1.game.graphics.FileReader;
import processing.core.PApplet;

public class DamageManager extends AbstractView {

	private ArrayList<Player> players;
	private ArrayList<AbstractEnemy> enemies;
	private ArrayList<Shot> friendlyShots;
	private ArrayList<Shot> enemyShots;
	private int minimumShotDistance;
	private ArrayList<Points> points;
	private int endlinePosition;
	private int scoreAreaHeight;
	
	public DamageManager(PApplet display, ArrayList<Points> points) {
		super(display);
		players = new ArrayList<Player>();
		enemies = new ArrayList<AbstractEnemy>();
		friendlyShots = new ArrayList<Shot>();
		enemyShots = new ArrayList<Shot>();
		minimumShotDistance = FileReader.readConfiguration(display, "minimumShotDistance");	
		this.points = points;
		
		int screenHeight = FileReader.readConfiguration(display, "screenHeight");
		int endlinePositionFromBottom = FileReader.readConfiguration(display, "endlinePositionFromBottom");
		this.endlinePosition = screenHeight - endlinePositionFromBottom;
		this.scoreAreaHeight = FileReader.readConfiguration(display, "scoreAreaHeight");
	}
	
	public void setDefaultConfigurations() {
		enemies.removeAll(enemies);
		players.removeAll(players);
		friendlyShots.removeAll(friendlyShots);
	}
	
	public void addEnemy(AbstractEnemy enemy) {
		enemies.add(enemy);
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public void friendlyShot(int posX, int posY, int player) {
		if(friendlyShots.size() == 0) {
			friendlyShots.add(new Shot(this.display, posX, posY, true, player));
		}
		else {
			Shot mostRecentShot = friendlyShots.get(friendlyShots.size() - 1);
			if(mostRecentShot.movement.getPosition() < mostRecentShot.posY - minimumShotDistance) {
				friendlyShots.add(new Shot(this.display, posX, posY, true, player));
			}
		}
	}
	
	public void enemyShot(int posX, int posY) {
		enemyShots.add(new Shot(this.display, posX, posY, false, 0));
	}
	
	public void update() {
		for(int friendlyShot = 0; friendlyShot < friendlyShots.size(); friendlyShot++) {
			for(int enemyShot = 0; enemyShot < enemyShots.size(); enemyShot++) {
				if(this.friendlyShots.get(friendlyShot).getBoundingBox().checkCollision(enemyShots.get(enemyShot).getBoundingBox())) {
					this.friendlyShots.remove(friendlyShot);
					this.enemyShots.remove(enemyShot);
					break;
				}
			}
		}
		
		for(int shot = 0; shot < friendlyShots.size(); shot++) {
			for(AbstractEnemy targetEnemy: this.enemies) {
				if(targetEnemy.isAlive()) {
					if(this.friendlyShots.get(shot).getBoundingBox().checkCollision(targetEnemy.getBoundingBox())) {
						targetEnemy.takeDamage(points.get(friendlyShots.get(shot).getIdentificationNumber()));
						this.friendlyShots.remove(shot);
						break;
					}
				}
			}
		}
		
		for(int shot = 0; shot < enemyShots.size(); shot++) {
			for(Player targetPlayer: this.players) {
				if(targetPlayer.isAlive()) {
					if(this.enemyShots.get(shot).getBoundingBox().checkCollision(targetPlayer.getBoundingBox())) {
						this.enemyShots.remove(shot);
						targetPlayer.takeDamage();
						break;
					}
				}
			}
		}
		
		for(int player = 0; player < this.players.size(); player++) {
			for(AbstractEnemy targetEnemy: this.enemies) {
				if(targetEnemy.isAlive()) {
					if(players.get(player).getBoundingBox().checkCollision(targetEnemy.getBoundingBox())) {
						targetEnemy.die(points.get(player));
						players.get(player).takeDamage();
						break;
					}
				}
			}
		}
		
		for(Shot shot: friendlyShots) {
			shot.update();
		}
		
		for(int shot = 0; shot < friendlyShots.size(); shot++) {
			if(friendlyShots.get(shot).getPosY() < scoreAreaHeight) {
				friendlyShots.remove(shot);
			}
		}
		
		for(Shot shot: enemyShots) {
			shot.update();
		}
		
		for(int shot = 0; shot < enemyShots.size(); shot++) {
			if(enemyShots.get(shot).getPosY() > endlinePosition) {
				enemyShots.remove(shot);
			}
		}
		
	}
}
