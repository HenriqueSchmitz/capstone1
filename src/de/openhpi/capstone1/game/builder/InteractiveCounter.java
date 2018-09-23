package de.openhpi.capstone1.game.builder;

import java.util.ArrayList;

import de.openhpi.capstone1.game.controller.CounterControllerStrategy;
import de.openhpi.capstone1.game.model.Counter;
import de.openhpi.capstone1.game.view.AbstractView;
import de.openhpi.capstone1.game.view.CounterViewEnemies;
import de.openhpi.capstone1.game.view.CounterViewLives;
import de.openhpi.capstone1.game.view.CounterViewMove;
import de.openhpi.capstone1.game.view.CounterViewStage;
import de.openhpi.capstone1.game.view.CounterViewText;
import de.openhpi.capstone1.game.view.EnemySpawner;
import de.openhpi.capstone1.game.view.ShotManager;
import processing.core.PApplet;

public class InteractiveCounter extends InteractiveComponent {
	CounterControllerStrategy counterControllerStrategy;
	Counter counter;
	ShotManager shotManager;
	
	public InteractiveCounter(PApplet applet) {
		views = new ArrayList<AbstractView>();
		shotManager = new ShotManager(applet);
	}
	
	public void addModel() {
		counter = new Counter();
		
	}
	
	public void createViews(PApplet applet) {
		views.add(new CounterViewMove(applet, counter));
		views.add(new CounterViewText(applet, counter));
		views.add(new CounterViewStage(applet, counter));
		views.add(new CounterViewEnemies(applet, counter));
		views.add(new CounterViewLives(applet, counter));
		views.add(new EnemySpawner(applet, shotManager));
		views.add(shotManager);
	}
	
	public void addController() {
		counterControllerStrategy = new CounterControllerStrategy(counter, shotManager);
	}
	
	@Override
	public void handleEvent(int count) {
		counterControllerStrategy.handleEvent(count);
	}
}
