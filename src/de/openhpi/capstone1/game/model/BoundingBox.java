package de.openhpi.capstone1.game.model;

public class BoundingBox {
	
	int posX;
	int posY;
	int sizeX;
	int sizeY;
	
	public void update(int posX, int posY, int sizeX, int sizeY) {
		this.posX = posX;
		this.posY = posY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	public int[] getBoundaries() {
		int[] boundaries = new int[4];
		
		boundaries[0] = posX;
		boundaries[1] = posY;
		boundaries[2] = sizeX;
		boundaries[3] = sizeY;
		
		return boundaries;
	}
	
	public boolean checkCollision(BoundingBox target) {
		int[] targetBox = target.getBoundaries();

		return false;
	}
}
