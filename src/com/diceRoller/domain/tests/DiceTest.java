package com.diceRoller.domain.tests;


import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.Test;

import com.diceRoller.domain.Dice;

class DiceTest {

	@Test
	void testRoll6() throws Exception {
		Dice dice = new Dice(6);
		assertTrue("To big", dice.roll() < 7);
		assertTrue("To small", dice.roll() > 0);
	}
	
	@Test
	void testRoll0() {
		assertThrows(Exception.class, () -> {
			Dice dice = new Dice(0);
		});
	}
	
	@Test
	void testRollNegative()  {
		;
		assertThrows(Exception.class, () -> {
			Dice dice = new Dice(0);
		});
	}
}
