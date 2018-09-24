package de.openhpi.capstone1.game.builder;

import java.util.ArrayList;

import de.openhpi.capstone1.game.controller.CounterControllerStrategy;
import de.openhpi.capstone1.game.model.Counter;
import de.openhpi.capstone1.game.view.AbstractView;
import de.openhpi.capstone1.game.view.ViewLives;
import de.openhpi.capstone1.game.view.Stage;
import de.openhpi.capstone1.game.view.ViewText;
import de.openhpi.capstone1.game.view.DamageManager;
import de.openhpi.capstone1.game.view.EnemySpawner;
import de.openhpi.capstone1.game.view.MenuScreen;
import de.openhpi.capstone1.game.view.Player;
import de.openhpi.capstone1.game.view.Points;
import processing.core.PApplet;

public class InteractiveCounter extends InteractiveComponent {
	CounterControllerStrategy counterControllerStrategy;
	Counter counter;
	DamageManager damageManager;
	Player player;
	
	Points points;
	
	public InteractiveCounter(PApplet applet) {
		game = new ArrayList<AbstractView>();
		menu = new ArrayList<AbstractView>();
		
		points = new Points(applet);
		
		damageManager = new DamageManager(applet, points);
		view = new String("MenuScreen");
		
		
	}
	
	public void addModel() {
		counter = new Counter();
	}
	
	public void createViews(PApplet applet) {
		player = new Player(this, applet, counter);
		damageManager.addPlayer(player);
		game.add(player);
		game.add(new Stage(applet));
		game.add(new ViewLives(applet, counter, player));
		game.add(new EnemySpawner(this, applet, damageManager));
		game.add(damageManager);
		game.add(points);
		game.add(new ViewText(applet));
		menu.add(new MenuScreen(applet));
	}
	
	public void addController(PApplet applet) {
		counterControllerStrategy = new CounterControllerStrategy(applet, counter, damageManager);
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
