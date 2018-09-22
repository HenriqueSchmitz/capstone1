package de.openhpi.capstone1.game.view;

import java.util.ArrayList;

import de.openhpi.capstone1.game.aliens.SpaceInvader;
import de.openhpi.capstone1.game.graphics.FileReader;
import processing.core.PApplet;

public class EnemySpawner extends AbstractView{

	private ArrayList<ArrayList<AbstractEnemy>> enemies;
	private int aliensPerLine;
	private int alienStartX;
	private int alienStartY;
	private int alienSpacingX;
	private int alienSpacingY;
	private int lastLine;
	
	public EnemySpawner(PApplet display){
		super(display);
		enemies = new ArrayList<ArrayList<AbstractEnemy>>();
		
		this.aliensPerLine = FileReader.readConfiguration(display, "aliensPerLine");
		this.alienStartX = FileReader.readConfiguration(display, "alienStartX");
		this.alienStartY = FileReader.readConfiguration(display, "alienStartY");
		this.alienSpacingX = FileReader.readConfiguration(display, "alienSpacingX");
		this.alienSpacingY = FileReader.readConfiguration(display, "alienSpacingY");
		
		spawnLine();
		
		screen = new String("GameScreen");
		
	}
	
	private void spawnLine() {
		enemies.add(new ArrayList<AbstractEnemy>());
		this.lastLine = enemies.size() - 1;
		for(int column = 0; column < aliensPerLine; column++) {
			enemies.get(lastLine).add(new SpaceInvader(display, alienStartX + column * alienSpacingX, alienStartY));
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
	
	
	
	public void update() {
			if(enemies.get(this.lastLine).get(0).getPosY() > (this.alienStartY + this.alienSpacingY)) {
				spawnLine();
			}
			
			while(!isLineAlive(0)) {
				enemies.remove(0);
			}
			
			for(int line = 0; line <= this.lastLine; line++) {
				for(int column = 0; column < aliensPerLine; column++) {
					enemies.get(line).get(column).update();
				}
			}
	}
	
}
