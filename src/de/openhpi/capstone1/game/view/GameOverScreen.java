package de.openhpi.capstone1.game.view;
import processing.core.PApplet;

public class GameOverScreen extends AbstractView{
	private Points points;
	
	public GameOverScreen(PApplet display, Points points) {
		super(display);
		this.points = points;
	}
	
	public void setDefaultConfigurations() {
		// not sure what to write here
	}
	
	public void showOptions() {
		display.textSize(40);
		display.fill(255);
		display.text("CLICK TO PLAY AGAIN", 430, 600);
	}
	
	public void showHighScore() {
		display.textSize(60);
		display.fill(255);
		if (points.getIsNewHighScore()) {
			display.text("NEW HIGH SCORE", 430, 400);
		}
		else {
			display.text("HIGH SCORE", 430, 400);
		}
		points.pointSystemDesign(points.getHighScore(), 600, 500);
	}
	
	@Override
	public void update() {
		display.background(0);
		display.textSize(120);
		display.fill(255);
		display.text("GAME OVER", 180, 200);
		showHighScore();
		showOptions();		
	}
}
