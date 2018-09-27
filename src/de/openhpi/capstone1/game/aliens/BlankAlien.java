package de.openhpi.capstone1.game.aliens;

import java.util.ArrayList;

import de.openhpi.capstone1.game.view.AbstractAlien;
import de.openhpi.capstone1.game.view.DamageManager;
import processing.core.PApplet;

public class BlankAlien extends AbstractAlien{
		
		private int lastShotTime;
		
		public BlankAlien(PApplet display, int posX, int posY) {
			super(display, posX, posY, "ShooterAlien");
			lastShotTime = this.display.millis();
			
			this.colors = new ArrayList<Float>();
			colors.add((float) 255);
			colors.add((float) 255);
			colors.add((float) 255);
		}
		
		public void shoot(DamageManager damageManager) {
			if(this.isAlive()) {
				if(this.display.millis() > lastShotTime + 3000) {
					damageManager.enemyShot(this.posX + (this.image.getSizeX()/2), this.movement.getPosition() + this.image.getSizeY());
					lastShotTime = this.display.millis();
				}
			}
		}
		
		protected void setHealthPoints() {
			this.lives.setNumberOfLives(0);
		}
		
		protected void setScoreValue() {
			this.scoreValue = 20;
		}

	}
