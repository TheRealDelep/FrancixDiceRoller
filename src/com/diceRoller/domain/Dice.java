package com.diceRoller.domain;

import java.util.Random;

public class Dice {
	
	Random rand = new Random();
	
	private int nbOfFaces = 0;
	
	public Dice(int nbOfFaces) throws Exception {
		if(nbOfFaces <= 0) {
			System.out.println("Negative number");
			throw new Exception ("number of faces can't be negative or equal to zéro");
		}
		
		this.setNbOfFaces(nbOfFaces);
		
	}

	public int getNbOfFaces() {
		return nbOfFaces;
	}

	public void setNbOfFaces(int nbOfFaces) {
		this.nbOfFaces = nbOfFaces;
	}
	
	public int roll() {
		int result = rand.nextInt(nbOfFaces) + 1;
		System.out.println(result);
		return result;
	}
	
	
}


