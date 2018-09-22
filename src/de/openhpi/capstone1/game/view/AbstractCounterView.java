package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.logic.Enemy;
import de.openhpi.capstone1.game.logic.Lives;
import de.openhpi.capstone1.game.logic.Score;
import de.openhpi.capstone1.game.logic.Shot;
import de.openhpi.capstone1.game.model.Counter;
import processing.core.PApplet;

public abstract class AbstractCounterView extends AbstractView {

	protected Counter counter;
	protected Enemy enemy;
	protected Lives lives;
	protected Score score;
	protected Shot shot;

	public AbstractCounterView(PApplet display, Counter counter) {
		super(display);
		this.counter = counter;
	}

}