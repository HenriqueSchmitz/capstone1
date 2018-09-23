package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.model.Counter;
import de.openhpi.capstone1.game.view.ShotManager;

public class CounterController implements Controller {

	Counter counter;
	ShotManager shotManager;	

	public CounterController(Counter counter, ShotManager shotManager) { 
		this.counter = counter;
		this.counter.updateCount(100);
		this.shotManager = shotManager;
	}
	
	public void checkMove(int count) {
		if ((counter.getCount() + count) > 900) {	// MAX displacement
			counter.updateCount(900 - counter.getCount());
		}
		else if ((counter.getCount() + count) < 100) {	// MIN displacement
			counter.updateCount(counter.getCount() - 100);
		}
		else counter.updateCount(count);
	}
	
	public void handleEvent(int count) {
		if ((count == -5) || (count == 5)) {	// is moving
			checkMove(count);
		}
		else if (count == 0) {	// is shooting
			shotManager.friendlyShot(counter.getCount() + 15, 460);
		}
	}

}
