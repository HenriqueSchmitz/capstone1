package de.openhpi.capstone1.game.graphics;

import processing.core.PApplet;

public class FileReader {
	
	public static double readConfigurationDouble(PApplet display, String field) {
		double result;
		
		field = field + " = ";
		
		String[] config = display.loadStrings("src\\de\\openhpi\\capstone1\\game\\graphics\\configuration.txt");
		result = 1;
		for (int line = 0; line < config.length; line++) {
			if(config[line].contains(field)) {
				result = Double.parseDouble(config[line].substring(field.length()));
			} 
		}
		
		return result;
	}
	
	public static int readConfiguration(PApplet display, String field) {
		int result;
		
		field = field + " = ";
		
		String[] config = display.loadStrings("src\\de\\openhpi\\capstone1\\game\\graphics\\configuration.txt");
		result = 1;
		for (int line = 0; line < config.length; line++) {
			if(config[line].contains(field)) {
				result = Integer.parseInt(config[line].substring(field.length()));
			} 
		}
		
		return result;
	}
	
	public static int[][] readImage(PApplet display, String imageName){
		String[] imageData = display.loadStrings("src\\de\\openhpi\\capstone1\\game\\graphics\\" + imageName + ".txt");
		int image[][] = new int[imageData.length][PApplet.split(imageData[0], " ").length];
		for (int line = 0; line < image.length; line++) {
			String[] buffer = PApplet.split(imageData[line], ' ');
			for (int column = 0; column < image[line].length; column++) {
				image[line][column] = Integer.parseInt(buffer[column]);
			}
		}
		
		return image;
	}
	
	public static int[][] readFormation(PApplet display, String formationName){
		String[] imageData = display.loadStrings("src\\de\\openhpi\\capstone1\\game\\graphics\\Formation" + formationName + ".txt");
		int image[][] = new int[imageData.length][PApplet.split(imageData[0], " ").length];
		for (int line = 0; line < image.length; line++) {
			String[] buffer = PApplet.split(imageData[line], ' ');
			for (int column = 0; column < image[line].length; column++) {
				image[line][column] = Integer.parseInt(buffer[column]);
			}
		}
		
		return image;
	}
}
