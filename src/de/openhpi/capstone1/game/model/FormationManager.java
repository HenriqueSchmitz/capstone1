package de.openhpi.capstone1.game.model;

import java.util.ArrayList;

import de.openhpi.capstone1.game.aliens.ShooterAlien;
import de.openhpi.capstone1.game.aliens.SpaceInvader;
import de.openhpi.capstone1.game.graphics.FileReader;
import de.openhpi.capstone1.game.view.AbstractEnemy;
import de.openhpi.capstone1.game.view.DamageManager;
import de.openhpi.capstone1.game.view.Points;
import processing.core.PApplet;

public class FormationManager {

	private ArrayList<Points> points;
	private int aliensPerLine;
	private int alienStartX;
	private int alienStartY;
	private int alienSpacingX;
	private PApplet display;

	
	public FormationManager(PApplet display, ArrayList<Points> points) {
		this.display = display;
		this.points = points;
		
		AbstractEnemy exampleAlien = new SpaceInvader(display,0,0);
		this.aliensPerLine = FileReader.readConfiguration(display, "aliensPerLine");
		this.alienStartY = FileReader.readConfiguration(display, "alienStartY");
		this.alienSpacingX = FileReader.readConfiguration(display, "alienSpacingX");
		int screenWidth = FileReader.readConfiguration(display, "screenWidth");
		this.alienStartX = (screenWidth - (aliensPerLine-1) * alienSpacingX - exampleAlien.getImage().getSizeX())/2 ;
		
	}
	
	public ArrayList<ArrayList<AbstractEnemy>> getFormation(DamageManager damageManager){
		int totalPoints = 0;
		for(Points point: points) {
			totalPoints += point.getScore();
		}
		
		ArrayList<ArrayList<AbstractEnemy>> formation;
		if(totalPoints <= 300) {
			formation = getStage1(damageManager);
		}
		else {
			formation = getStage2(damageManager);
		}
		return formation;
	}
	
	private ArrayList<ArrayList<AbstractEnemy>> getStage1(DamageManager damageManager){
		ArrayList<ArrayList<AbstractEnemy>> formation = new ArrayList<ArrayList<AbstractEnemy>>();
		formation.add(new ArrayList<AbstractEnemy>());
		for(int column = 0; column < aliensPerLine; column++) {
			formation.get(0).add(new SpaceInvader(display, alienStartX + column * alienSpacingX, alienStartY));
			damageManager.addEnemy(formation.get(0).get(column));
			formation.get(0).get(column).setSpawnTime(formation.get(0).get(0).getSpawnTime());;
		}
		return formation;
	}
	
	private ArrayList<ArrayList<AbstractEnemy>> getStage2(DamageManager damageManager){
		ArrayList<ArrayList<AbstractEnemy>> formation = new ArrayList<ArrayList<AbstractEnemy>>();
		formation.add(new ArrayList<AbstractEnemy>());
		for(int column = 0; column < aliensPerLine; column++) {
			formation.get(0).add(new ShooterAlien(display, alienStartX + column * alienSpacingX, alienStartY));
			damageManager.addEnemy(formation.get(0).get(column));
			formation.get(0).get(column).setSpawnTime(formation.get(0).get(0).getSpawnTime());;
		}
		return formation;
	}
}
