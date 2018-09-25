package de.openhpi.capstone1.game.builder;

import processing.core.PApplet;

public class GUIComponent {
	private GUIComponent() {}
	
	public static void construct(PApplet applet, Builder builder) {
		builder.buildComponent(applet);
		builder.buildModel(applet);
		builder.buildView(applet);
		builder.buildController(applet);
	}
}
