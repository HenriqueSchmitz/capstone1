package de.openhpi.capstone1.game.model;

import java.util.ArrayList;

import de.openhpi.capstone1.game.aliens.BlankAlien;
import de.openhpi.capstone1.game.aliens.ShooterAlien;
import de.openhpi.capstone1.game.aliens.SpaceInvader;
import de.openhpi.capstone1.game.graphics.FileReader;
import de.openhpi.capstone1.game.view.AbstractEnemy;
import de.openhpi.capstone1.game.view.DamageManager;
import de.openhpi.capstone1.game.view.Points;
import processing.core.PApplet;

public class FormationManager {

	private DamageManager damageManager;
	private ArrayList<Points> points;
	private Randomizer randomizer;
	private int aliensPerLine;
	private int alienStartX;
	private int alienStartY;
	private int alienSpacingX;
	private int alienSpacingY;
	private PApplet display;

	
	public FormationManager(PApplet display, ArrayList<Points> points, DamageManager damageManager) {
		this.damageManager = damageManager;
		this.display = display;
		this.points = points;
		this.randomizer = new Randomizer(display);
		
		AbstractEnemy exampleAlien = new SpaceInvader(display,0,0);
		this.aliensPerLine = FileReader.readConfiguration(display, "aliensPerLine");
		this.alienStartY = FileReader.readConfiguration(display, "alienStartY");
		this.alienSpacingX = FileReader.readConfiguration(display, "alienSpacingX");
		this.alienSpacingY = FileReader.readConfiguration(display, "alienSpacingY");
		int screenWidth = FileReader.readConfiguration(display, "screenWidth");
		this.alienStartX = (screenWidth - (aliensPerLine-1) * alienSpacingX - exampleAlien.getImage().getSizeX())/2 ;
		
	}
	
	private ArrayList<ArrayList<AbstractEnemy>> generateFormation(String formationName){
		int[][] data = FileReader.readFormation(display, formationName);
		ArrayList<ArrayList<AbstractEnemy>> formation = new ArrayList<ArrayList<AbstractEnemy>>();
		for(int line = 0; line < data.length; line++) {
			formation.add(new ArrayList<AbstractEnemy>());
			for( int column = 0; column < data[line].length; column++) {
				int posX = alienStartX + column * alienSpacingX;
				int posY = alienStartY - line * alienSpacingY;
				AbstractEnemy enemy = translateNumber(data[line][column], posX, posY);
				formation.get(line).add(enemy);
				formation.get(line).get(column).setSpawnTime(formation.get(line).get(0).getSpawnTime());
				this.damageManager.addEnemy(formation.get(line).get(column));
			}
		}
		return formation;
	}
	
	private AbstractEnemy translateNumber(int number, int posX, int posY) {
		switch(number) {
		case 0: return new BlankAlien(display, posX, posY);
		case 1: return new SpaceInvader(display, posX, posY);
		case 2: return new ShooterAlien(display, posX, posY);
		
		default: return new BlankAlien(display, posX, posY);
		}
	}
	
	public ArrayList<ArrayList<AbstractEnemy>> getFormation(){
		int totalPoints = 0;
		for(Points point: points) {
			totalPoints += point.getScore();
		}
		
		ArrayList<ArrayList<AbstractEnemy>> formation;
		if(totalPoints <= 500) {
			formation = getStage1(damageManager);
		}
		else if(totalPoints <= 1000){
			formation = getStage2(damageManager);
		}
		else {
			formation = getStage3(damageManager);
		}
		return formation;
	}
	
	private ArrayList<ArrayList<AbstractEnemy>> getStage1(DamageManager damageManager){
		randomizer.clear();
		randomizer.add("5LinesEasy", 1);
		randomizer.add("CheckersEasy", 1);
		randomizer.add("SidesEasy", 1);
		return generateFormation(randomizer.get());
	}
	
	private ArrayList<ArrayList<AbstractEnemy>> getStage2(DamageManager damageManager){
		return generateFormation("Wedge");
	}
	
	private ArrayList<ArrayList<AbstractEnemy>> getStage3(DamageManager damageManager){
		return generateFormation("Wedge");
	}
}
