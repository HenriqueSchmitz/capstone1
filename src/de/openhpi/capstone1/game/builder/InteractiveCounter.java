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
import de.openhpi.capstone1.game.view.MenuScreen;
import de.openhpi.capstone1.game.view.DamageManager;
import processing.core.PApplet;

public class InteractiveCounter extends InteractiveComponent {
	CounterControllerStrategy counterControllerStrategy;
	Counter counter;
	DamageManager damageManager;
	CounterViewMove player;
	
	public InteractiveCounter(PApplet applet) {
		game = new ArrayList<AbstractView>();
		menu = new ArrayList<AbstractView>();
		damageManager = new DamageManager(applet);
		view = new String("MenuScreen");
		
		
	}
	
	public void addModel() {
		counter = new Counter();
	}
	
	public void createViews(PApplet applet) {
		player = new CounterViewMove(applet, counter);
		damageManager.addPlayer(player);
		game.add(player);
		game.add(new CounterViewText(applet, counter));
		game.add(new CounterViewStage(applet, counter));
		game.add(new CounterViewEnemies(applet, counter));
		game.add(new CounterViewLives(applet, counter));
		game.add(new EnemySpawner(this, applet, damageManager));
		game.add(damageManager);
		menu.add(new MenuScreen(applet));
	}
	
	public void addController() {
		counterControllerStrategy = new CounterControllerStrategy(counter, damageManager);
	}
	
	public void handleScreen(PApplet display) {
		if (view.equals("MenuScreen")) {
			setView("GameScreen");
		}
	}
	
	@Override
	public void handleEvent(PApplet display) {
		if (view.equals("GameScreen")) {
			counterControllerStrategy.handleEvent(display);
		}
	}
}
