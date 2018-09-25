package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.graphics.FileReader;
import processing.core.PApplet;

public class Stage extends AbstractView{	// stage elements

	private int screenHeight;
	private int screenWidth;
	private int sideBorderSize;
	private int endlinePositionFromBottom;
	
	public Stage(PApplet display) {
		super(display);
		this.screenHeight = FileReader.readConfiguration(display, "screenHeight");
		this.screenWidth = FileReader.readConfiguration(display, "screenWidth");
		this.sideBorderSize = FileReader.readConfiguration(display, "sideBorderSize");
		this.endlinePositionFromBottom = FileReader.readConfiguration(display, "endlinePositionFromBottom");
	}
	
	public void setDefaultConfigurations() {
		// not sure what to write here
	}
	
	@Override
	public void update() {
		int endlinePosition = screenHeight - endlinePositionFromBottom;
		display.fill(0);
		// display the line above the credits and lives
		display.strokeWeight(7);	
		display.stroke(255);	// line color
		display.line(sideBorderSize, endlinePosition, screenWidth - sideBorderSize, endlinePosition);
	}
	
}
