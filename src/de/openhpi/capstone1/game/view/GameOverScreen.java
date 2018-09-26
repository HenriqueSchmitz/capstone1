package de.openhpi.capstone1.game.view;
import java.util.ArrayList;

import processing.core.PApplet;

public class GameOverScreen extends AbstractView{
	private ArrayList<Points> points;
	private ViewPoints viewPoint;
	
	public GameOverScreen(PApplet display, ArrayList<Points> points, ViewPoints viewPoint) {
		super(display);
		this.points = points;
		this.viewPoint = viewPoint;
	}
	
	public void setDefaultConfigurations() {
		
	}
	
	public void showOptions() {
		display.textSize(40);
		display.fill(255);
		display.text("CLICK TO PLAY AGAIN", 330, 600);
	}
	
	public void showHighScoreTitle(boolean newHighScore) {
		display.textSize(60);
		display.fill(255);
		if (newHighScore) {
			display.text("NEW HIGH SCORE", 300, 380);
		}
		else {
			display.text("HIGH SCORE", 350, 380);
		}
	}
	
	public void showHighScore() {
		if (points.size() > 1) {
			if (points.get(1).getHighScore() > points.get(0).getHighScore()) {
				viewPoint.pointSystemDesign(points.get(1).getHighScore(), 520, 500);
				showHighScoreTitle(points.get(1).getIsNewHighScore());
			}
			else {
				viewPoint.pointSystemDesign(points.get(0).getHighScore(), 520, 500);
				showHighScoreTitle(points.get(0).getIsNewHighScore());
			}
		}
		else {
			viewPoint.pointSystemDesign(points.get(0).getHighScore(), 520, 500);
			showHighScoreTitle(points.get(0).getIsNewHighScore());
		}
	}
	
	@Override
	public void update() {
		display.background(0);
		display.textSize(120);
		display.fill(255);
		display.text("GAME OVER", 200, 200);
		showHighScore();
		showOptions();		
	}
}
