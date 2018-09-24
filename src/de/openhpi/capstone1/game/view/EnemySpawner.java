package de.openhpi.capstone1.game.view;

import java.util.ArrayList;

import de.openhpi.capstone1.game.aliens.SpaceInvader;
import de.openhpi.capstone1.game.builder.InteractiveCounter;
import de.openhpi.capstone1.game.graphics.FileReader;
import processing.core.PApplet;

public class EnemySpawner extends AbstractView{

	private InteractiveCounter interactiveCounter;
	private ArrayList<ArrayList<AbstractEnemy>> enemies;
	private DamageManager damageManager;
	private int aliensPerLine;
	private int alienStartX;
	private int alienStartY;
	private int alienSpacingX;
	private int alienSpacingY;
	private int lastLine;
	private int endlinePosition;
	
	public EnemySpawner(InteractiveCounter interactiveCounter, PApplet display, DamageManager damageManager){
		super(display);
		this.interactiveCounter = interactiveCounter;
		enemies = new ArrayList<ArrayList<AbstractEnemy>>();
		
		this.damageManager = damageManager;
		this.aliensPerLine = FileReader.readConfiguration(display, "aliensPerLine");
		this.alienStartX = FileReader.readConfiguration(display, "alienStartX");
		this.alienStartY = FileReader.readConfiguration(display, "alienStartY");
		this.alienSpacingX = FileReader.readConfiguration(display, "alienSpacingX");
		this.alienSpacingY = FileReader.readConfiguration(display, "alienSpacingY");
		int screenHeight = FileReader.readConfiguration(display, "screenHeight");
		int endlinePositionFromBottom = FileReader.readConfiguration(display, "endlinePositionFromBottom");
		this.endlinePosition = screenHeight - endlinePositionFromBottom;
	}
	
	private void spawnLine() {
		enemies.add(new ArrayList<AbstractEnemy>());
		this.lastLine = enemies.size() - 1;
		for(int column = 0; column < aliensPerLine; column++) {
			enemies.get(lastLine).add(new SpaceInvader(display, alienStartX + column * alienSpacingX, alienStartY));
			this.damageManager.addEnemy(enemies.get(lastLine).get(column));
			enemies.get(lastLine).get(column).setSpawnTime(enemies.get(lastLine).get(0).getSpawnTime());;
		}
	}
	
	private boolean isLineAlive(int line) {
		for(int column = 0; column < aliensPerLine; column++) {
			if(enemies.get(line).get(column).isAlive()) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isGameOver() {
		return (enemies.get(0).get(0).getPosY() + enemies.get(0).get(0).image.getSizeY()) > this.endlinePosition;
	}
	
	
	
	public void update() {
		if(enemies.size() == 0) {
			this.spawnLine();
		}
		else {
			if(enemies.get(this.lastLine).get(0).getPosY() > (this.alienStartY + this.alienSpacingY)) {
				spawnLine();
			}
			
			while(!isLineAlive(0)) {
				enemies.remove(0);
				this.lastLine--;
			}
			
			for(int line = 0; line <= this.lastLine; line++) {
				for(int column = 0; column < aliensPerLine; column++) {
					enemies.get(line).get(column).update();
				}
			}
		}
		
		if(isGameOver()) {
			interactiveCounter.setView("GameOver");
		}
	}
	
}
