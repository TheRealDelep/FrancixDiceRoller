package com.diceRoller.domain;

import java.util.Random;

public class Dice {
	
	Random rand = new Random();
	
	private int nbOfFaces = 0;
	
	public Dice(int nbOfFaces) throws Exception {
		if(nbOfFaces <= 0) {
			throw new Exception ("number of faces can't be negative or equal to zero");
		}
		
		this.nbOfFaces = nbOfFaces;
		
	}
	
	public int roll() {
		int result = rand.nextInt(nbOfFaces) + 1;
		return result;
	}
	
}


