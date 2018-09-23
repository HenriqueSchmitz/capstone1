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
		boundaries[1] = posX + sizeX;
		boundaries[2] = posY;
		boundaries[3] = posY + sizeY;
		
		return boundaries;
	}
	
	public boolean checkCollision(BoundingBox target) {
		int[] targetBox = target.getBoundaries();
		int[] thisBox = this.getBoundaries();
		if((thisBox[2] > targetBox[2]) && (thisBox[3] < targetBox[3])) {
			if((thisBox[0] < targetBox[1]) && (thisBox[1] > targetBox[0])) {
				return true;
			}
		}
		
		return false;
	}
}
