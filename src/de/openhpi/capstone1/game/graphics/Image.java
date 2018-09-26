package de.openhpi.capstone1.game.graphics;

import processing.core.PApplet;

public class Image {
	
	private PApplet display;
	private int[][] image;
	private int pixelSize;
	private String imageName;
	
	public Image(PApplet display, String imageName) {
		this.display = display;
		this.image = FileReader.readImage(display, imageName);
		this.pixelSize = FileReader.readConfiguration(display, "pixelSize");
		this.imageName = imageName;
	}
	
	public void draw(Object posX, Object posY) {
		int x = (int) posX;
		int y = (int) posY;
		
		display.strokeWeight(0);
		for(int line = 0; line < this.image.length; line++) {
			for(int column = 0; column < this.image[line].length; column++) {
				if(this.image[line][column] > 0) {
					display.rect( (x + column * pixelSize), (y + line * pixelSize), pixelSize, pixelSize);
				}
			}
		}
	}
	
	public int getSizeX() {
		return this.image[0].length * pixelSize;
	}
	
	public int getSizeY() {
		return this.image.length * pixelSize;
	}
	
	public void updateImage(String imageName) {
		this.image = FileReader.readImage(display, imageName);
	}
	
	public String getImageName() {
		return this.imageName;
	}
	
}
