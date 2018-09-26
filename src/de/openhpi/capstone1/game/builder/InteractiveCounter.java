package de.openhpi.capstone1.game.builder;

import java.util.ArrayList;

import de.openhpi.capstone1.game.controller.CounterControllerStrategy;
import de.openhpi.capstone1.game.model.Counter;
import de.openhpi.capstone1.game.model.Keyboard;
import de.openhpi.capstone1.game.view.AbstractView;
import de.openhpi.capstone1.game.view.DamageManager;
import de.openhpi.capstone1.game.view.EnemySpawner;
import de.openhpi.capstone1.game.view.GameOverScreen;
import de.openhpi.capstone1.game.view.MenuScreen;
import de.openhpi.capstone1.game.view.Player;
import de.openhpi.capstone1.game.view.Points;
import de.openhpi.capstone1.game.view.Stage;
import de.openhpi.capstone1.game.view.ViewLives;
import de.openhpi.capstone1.game.view.ViewText;
import processing.core.PApplet;


public class InteractiveCounter extends InteractiveComponent {
	private CounterControllerStrategy counterControllerStrategy;
	private Counter counter;
	private DamageManager damageManager;
	private Player player;
	private Points points;
	
	public InteractiveCounter(PApplet applet) {
		points = new Points(applet);
		this.constructor(applet);
	}
	
	private void constructor(PApplet applet) {
		game = new ArrayList<AbstractView>();
		menu = new ArrayList<AbstractView>();	
		gameOver = new ArrayList<AbstractView>();
		keyboard = new Keyboard(applet);
		damageManager = new DamageManager(applet, points);
		keyboard.addDamageManager(damageManager);		
		view = new String("MenuScreen");	
	}
	
	public void addModel(PApplet applet) {
		counter = new Counter(applet);
		keyboard.addCounter(applet, counter);
	}
	
	public void createViews(PApplet applet) {
		player = new Player(this, applet, counter);
		damageManager.addPlayer(player);
		game.add(player);
		game.add(new Stage(applet));
		game.add(new ViewLives(applet, counter, player));
		game.add(new EnemySpawner(this, applet, damageManager, points));
		game.add(damageManager);
		game.add(new ViewText(applet, points));
		game.add(points);
		menu.add(new MenuScreen(applet));
		gameOver.add(new GameOverScreen(applet, points));
	}
	
	public void addController(PApplet applet) {
		counterControllerStrategy = new CounterControllerStrategy(applet, keyboard, damageManager);
	}
	
	public void handleScreen(PApplet display) {
		if (view.equals("MenuScreen")) {
			setView("GameScreen");
		}
		else if (view.equals("GameOverScreen")) {
			setView("GameScreen");
			setDefaultConfigurations(display);
		}
	}
	
	
	public void setDefaultConfigurations(PApplet display) {
		points.setDefaultConfigurations();
		this.constructor(display);
		this.addModel(display);
		this.createViews(display);
		this.addController(display);
	}
	
	@Override
	public void handleEvent(PApplet display) {
		if (view.equals("GameScreen")) {
			counterControllerStrategy.handleEvent(display);
		}
	}
	
	public void handlePress(PApplet display) {
		if (view.equals("GameScreen")) {
			counterControllerStrategy.handlePress(display);
		}
	}
	
	public void handleRelease(PApplet display) {
		if (view.equals("GameScreen")) {
			counterControllerStrategy.handleRelease(display);
		}
	}
}
