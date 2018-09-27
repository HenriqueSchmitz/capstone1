package de.openhpi.capstone1.game.view;

import java.util.ArrayList;
import de.openhpi.capstone1.game.graphics.FileReader;
import de.openhpi.capstone1.game.graphics.Image;
import processing.core.PApplet;

public class ViewLives extends AbstractView{
	protected ArrayList<Player> players;
	protected Image image;
	protected int endlinePosition;
	
	public ViewLives(PApplet display, ArrayList<Player> players) {
		super(display);
		this.players = players;
		this.image = new Image(display, "Heart");
		int screenHeight = FileReader.readConfiguration(display, "screenHeight");
		int endlinePositionFromBottom = FileReader.readConfiguration(display, "endlinePositionFromBottom");
		this.endlinePosition = screenHeight - endlinePositionFromBottom;
	}
	
	public void displayNumberOfLives() {
		display.textSize(40);
		display.fill(255);
		int x = 115;
		for (Player player: players) {
			display.text(player.getLives().getNumberOfLives() + "", x, this.endlinePosition + 40);	// display.text (text, x, y);
			x = 750;
		}
	}
	
	public void displayLives() {
		int x = 160;	
		for (Player player: players) {
			for (int live = 0; live < player.getLives().getNumberOfLives(); live++) {
				display.fill(255);
				image.draw(x, this.endlinePosition + 10);
				x = x + 50;
			}
			x = 800;
		}
	}
	
	public void update() {
		display.fill(0);
		displayLives();
		displayNumberOfLives();
	}
}
