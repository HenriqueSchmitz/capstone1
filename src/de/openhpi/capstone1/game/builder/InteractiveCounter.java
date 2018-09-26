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
import de.openhpi.capstone1.game.view.ViewPoints;
import de.openhpi.capstone1.game.view.ViewText;
import processing.core.PApplet;


public class InteractiveCounter extends InteractiveComponent {
	private CounterControllerStrategy counterControllerStrategy;
	private DamageManager damageManager;
	private ArrayList<Player> players;
	private ArrayList<Points> points;
	
	public InteractiveCounter(PApplet applet) {
		points = new ArrayList<Points>();
		points.add(new Points(applet));
		this.constructor(applet);
	}
	
//	private void createSecondPlayer(PApplet applet) {
//		players.add(new Player(this, applet));
//		points.add(new Points(applet));
//		keyboards.add(new Keyboard(applet));
//		keyboards.get(1).addDamageManager(damageManager);
//		keyboards.get(1).addCounter(applet, players.get(1).getCounter());
//		damageManager.get(1).addPlayer(players.get(1));
//		counterControllerStrategy.addSecondPlayer(keyboards, damageManager);
//		game.add(players.get(1));
//		game.add(damageManager.get(1));
//		game.add(points.get(1));
//	}
	
	private void createPlayer(PApplet applet) {
		players.add(new Player(this, applet));
		points.add(new Points(applet));
		keyboards.add(new Keyboard(applet));
		keyboards.get(players.size() - 1).addDamageManager(damageManager);
		keyboards.get(players.size() - 1).addCounter(applet, players.get(players.size() - 1).getCounter());
		damageManager.addPlayer(players.get(players.size() - 1));
		counterControllerStrategy.addPlayer(keyboards.get(players.size() - 1), damageManager);
		game.add(players.get(players.size() - 1));
		game.add(points.get(players.size() - 1));
	}
	
	private void constructor(PApplet applet) {
		game = new ArrayList<AbstractView>();
		menu = new ArrayList<AbstractView>();	
		gameOver = new ArrayList<AbstractView>();
		keyboards = new ArrayList<Keyboard>();
		damageManager = new DamageManager(applet, points.get(0));
		counterControllerStrategy = new CounterControllerStrategy();
		view = new String("MenuScreen");	
	}
	
	public void addModel(PApplet applet) {

	}
	
	public void createViews(PApplet applet) {
		players = new ArrayList<Player>();
		this.createPlayer(applet);
		ViewPoints viewPoint = new ViewPoints(applet, points);
		game.add(new Stage(applet));
		game.add(new ViewLives(applet, players));
		game.add(new EnemySpawner(this, applet, damageManager, points));
		game.add(damageManager);
		game.add(new ViewText(applet, points));
		game.add(viewPoint);
		menu.add(new MenuScreen(applet));
		gameOver.add(new GameOverScreen(applet, points, viewPoint));
	}
	
	public void addController(PApplet applet) {
		
	}
	
	public void handleScreen(PApplet display) {
		if (view.equals("MenuScreen")) {
			if ((display.mouseX >= 330) && (display.mouseX <= 330 + 480) && (display.mouseY >= 550) && (display.mouseY <= 550 + 100)) {
				createPlayer(display);
			}
			setView("GameScreen");
		}
		else if (view.equals("GameOverScreen")) {
			setView("GameScreen");
			setDefaultConfigurations(display);
		}
	}
	
	
	public void setDefaultConfigurations(PApplet display) {
		for (Points point: points) {
			point.setDefaultConfigurations();
		}
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
