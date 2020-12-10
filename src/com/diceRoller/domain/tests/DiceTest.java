package com.diceRoller.domain.tests;


import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import com.diceRoller.domain.Dice;

class DiceTest {

	@Test
	void testRoll6() throws Exception {
		Dice dice = new Dice(6);
		assertTrue("Too big", dice.roll() < 7);
		assertTrue("Too small", dice.roll() > 0);
	}
	
	
	@Test
	void testRoll0() {
		assertThrows(Exception.class, () -> {
			Dice dice = new Dice(0);
		});
	}
	
	
	@Test
	void testRollNegative()  {
		
		assertThrows(Exception.class, () -> {
			Dice dice = new Dice(-1);
		});
	}
	
	
	@Test
	void testRepartitionRollingXtimesOneDice() throws Exception {
		int faces = 10;
		ArrayList<Integer> results = new ArrayList<Integer>();
		int nbRolls = 100000; 
		Dice dice = new Dice(faces);
		
		for (int i = 0; i <= nbRolls; i++) {
			results.add(dice.roll());
		}
		
		int occurencesAverage = nbRolls/faces;
		int tolerance = 5;
		int maxOccurences = (occurencesAverage) + (occurencesAverage/100*tolerance);
		int minOccurences = (occurencesAverage) - (occurencesAverage/100*tolerance);
		
		for (int i=1; i<=faces; i++ ) {
			assertTrue("Too much occurence for " + i, Collections.frequency(results, i) < maxOccurences );
			assertTrue("Not enough occurence for " + i, Collections.frequency(results, i) > minOccurences );
		}
	}
	
	
	@Test
	void testRepartitionRollingXDices() throws Exception {
		int faces = 10;
		ArrayList<Integer> results = new ArrayList<Integer>();
		int nbRolls = 100000; 
		
		for (int i = 0; i <= nbRolls; i++) {
			Dice dice = new Dice(faces);
			results.add(dice.roll());
		}
		
		int occurencesAverage = nbRolls/faces;
		int tolerance = 5;
		int maxOccurences = (occurencesAverage) + (occurencesAverage/100*tolerance);
		int minOccurences = (occurencesAverage) - (occurencesAverage/100*tolerance);
		
		for (int i=1; i<=faces; i++ ) {
			assertTrue("Too much occurences for " + i, Collections.frequency(results, i) < maxOccurences );
			assertTrue("Not enough occurences for " + i, Collections.frequency(results, i) > minOccurences );
		}	
	}
	
}
