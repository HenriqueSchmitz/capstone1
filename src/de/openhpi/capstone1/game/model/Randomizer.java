package de.openhpi.capstone1.game.model;

import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;

public class Randomizer {

	private ArrayList<String> results;
	private ArrayList<Integer> weights;
	private Random random;
	
	public Randomizer(PApplet display) {
		this.random = new Random(display.millis());
		this.results = new ArrayList<String>();
		this.weights = new ArrayList<Integer>();
	}
	
	public void add(String result,Integer weight) {
		results.add(result);
		weights.add(weight);
	}
	
	public void clear() {
		this.results.clear();
		this.weights.clear();
	}
	
	public String get() {
		int sum = 0;
		for(Integer weight: weights) {
			sum += weight;
		}
		
		int randomNumber = random.nextInt(sum);
		
		sum = 0;
		for(int index = 0; index < results.size(); index++) {
			sum += weights.get(index);
			if(randomNumber < sum) {
				return results.get(index);
			}
		}
		
		return results.get(0);
	}
	
}
