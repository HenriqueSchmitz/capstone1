package de.openhpi.capstone1.game.logic;

import java.util.ArrayList;

public class Shot {

	private ArrayList<Integer> shotYPosition = new ArrayList<Integer>();
	private ArrayList<Integer> shotXPosition = new ArrayList<Integer>();
	
	public void updateShotYPosition(int index, int value) {	
		int y = shotYPosition.get(index);
		shotYPosition.set(index, y + value);
	}
	
	public ArrayList<Integer> getShotYPosition() {
		return shotYPosition;
	}
	
	public void addShotYPosition(int value) {
		shotYPosition.add(value);
	}
	
	public void updateShotXPosition(int index, int value) {	
		int x = shotXPosition.get(index);
		shotXPosition.set(index, x + value);
	}
	
	public ArrayList<Integer> getShotXPosition() {
		return shotXPosition;
	}
	
	public void addShotXPosition(int value) {
		shotXPosition.add(value);
	}
	
	public void firstShot(int shotXPosition, int shotYPosition) {
		this.addShotXPosition(shotXPosition);
		this.addShotYPosition(shotYPosition);
	}
	
	public void modifyShotsArrayList(ArrayList<Integer> shotsPosition) {
		for (int index = 0; index < shotsPosition.size(); index++) {
			if (shotsPosition.get(index) == 0) {
				shotsPosition.set(index, shotsPosition.get(shotsPosition.size() - 1));
				shotsPosition.remove(shotsPosition.size() - 1);
			}
		}
	}
	
	public void checkShoot(int count) {	// 80 is the score Y position
		for (int index = 0; index < this.getShotYPosition().size(); index++) {
			if (this.getShotYPosition().get(index) + count < 80) {
				this.getShotXPosition().set(index, 0);
				this.getShotYPosition().set(index, 0);
				this.modifyShotsArrayList(this.getShotXPosition());
				this.modifyShotsArrayList(this.getShotYPosition());
			}
			else this.updateShotYPosition(index, count);
		}
	}
}
