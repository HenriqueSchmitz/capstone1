package de.openhpi.capstone1.game.builder;

import de.openhpi.capstone1.game.controller.CounterControllerStrategy;
import de.openhpi.capstone1.game.logic.Shot;
import de.openhpi.capstone1.game.model.Counter;
import de.openhpi.capstone1.game.view.AbstractView;
import de.openhpi.capstone1.game.view.CounterViewColor;
import de.openhpi.capstone1.game.view.CounterViewEnemies;
import de.openhpi.capstone1.game.view.CounterViewLives;
import de.openhpi.capstone1.game.view.CounterViewMove;
import de.openhpi.capstone1.game.view.CounterViewNumber;
import de.openhpi.capstone1.game.view.CounterViewShots;
import de.openhpi.capstone1.game.view.CounterViewStage;
import de.openhpi.capstone1.game.view.CounterViewText;
import de.openhpi.capstone1.game.view.EnemySpawner;
import de.openhpi.capstone1.game.view.MenuScreen;
import processing.core.PApplet;

public class InteractiveCounter extends InteractiveComponent {
	CounterControllerStrategy counterControllerStrategy;
	Counter counter;
	Shot shot;
	
	public InteractiveCounter() {}
	
	public void addModel() {
		counter = new Counter();
		shot = new Shot();
	}
	
	public void createViews(PApplet applet) {
		screen = new String("MenuScreen");
		views = new AbstractView[10];
		views[0] = new MenuScreen(applet);
		views[1] = new CounterViewMove(applet, counter);
		views[2] = new CounterViewColor(applet, counter);
		views[3] = new CounterViewNumber(applet, counter);
		views[4] = new CounterViewText(applet, counter);
		views[5] = new CounterViewStage(applet, counter);
		views[6] = new CounterViewShots(applet, counter, shot);
		views[7] = new CounterViewEnemies(applet, counter);
		views[8] = new CounterViewLives(applet, counter);
		views[9] = new EnemySpawner(applet);
	}
	
	public void addController() {
		counterControllerStrategy = new CounterControllerStrategy(counter, shot);
	}
	
	/*public void displayGameScreen(PApplet display) {
		this.update();
	}
	
	public void displayMainMenuScreen(PApplet display) {	
		display.background(0);
		display.textSize(60);
		display.fill(255);
		display.text("SPACE INVADERS", 150, 100);
		if (display.mousePressed) {
			screen = 2;
		}
	}
	
	public void handleScreen(PApplet display) {
		if (screen == 1) {
			displayMainMenuScreen(display);
		}
		if (screen == 2) {
			displayGameScreen(display);
		}
	}*/
	
	@Override
	public void handleEvent(PApplet display) {
		if (screen.equals("MenuScreen")) {
			screen = "GameScreen";
		}
		counterControllerStrategy.handleEvent(display);
	}
}
