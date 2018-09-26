package de.openhpi.capstone1.game.view;
import processing.core.PApplet;

public class GameOverScreen extends AbstractView{
	private Points points;
	
	public GameOverScreen(PApplet display, Points points) {
		super(display);
		this.points = points;
	}
	
	public void setDefaultConfigurations() {
		
	}
	
	public void showOptions() {
		display.textSize(40);
		display.fill(255);
		display.text("CLICK TO PLAY AGAIN", 330, 600);
	}
	
	public void showHighScore() {
		display.textSize(60);
		display.fill(255);
		if (points.getIsNewHighScore()) {
			display.text("NEW HIGH SCORE", 300, 380);
		}
		else {
			display.text("HIGH SCORE", 350, 380);
		}
		points.pointSystemDesign(points.getHighScore(), 520, 500);
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
