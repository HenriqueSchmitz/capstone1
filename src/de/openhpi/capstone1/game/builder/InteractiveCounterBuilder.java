package de.openhpi.capstone1.game.builder;

import processing.core.PApplet;

public class InteractiveCounterBuilder implements Builder {

	InteractiveCounter iCounter;
	
	@Override
	public void buildComponent(PApplet applet) {
		iCounter = new InteractiveCounter(applet);
	}

	@Override
	public void buildModel() {
		iCounter.addModel();
	}

	@Override
	public void buildView(PApplet applet) {
		iCounter.createViews(applet);
	}

	@Override
	public void buildController() {
		iCounter.addController();
	}

	@Override
	public InteractiveComponent getComponent() {
		return iCounter;
	}

}
