package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import roman.RomanToNumberToRoman;

public class TestRomanToNumberToRoman {
	RomanToNumberToRoman input;

	@Before
	public void setUp() {
		input = new RomanToNumberToRoman();
	}

	@Test
	public void aSingleRomanItoANumber() {
		assertEquals(1, input.toNumber("I"));
		assertEquals(5, input.toNumber("V"));
		assertEquals(10, input.toNumber("X"));
	}

	@Test
	public void twoOfTheSameRomanNumeralsToANumber() {
		assertEquals(2, input.toNumber("II"));
		assertEquals(20, input.toNumber("XX"));
	}

	@Test
	public void twoDifferentRomanNumeralsAddedTogether() {
		assertEquals(6, input.toNumber("VI"));
		assertEquals(11, input.toNumber("XI"));
	}

	@Test
	public void twoDifferentRomanNumeralsSubtractedToGetANumber() {
		assertEquals(4, input.toNumber("IV"));
		assertEquals(9, input.toNumber("IX"));
	}

	@Test
	public void threeOfTheSameRomanNumeraltoaNumber() {
		assertEquals(3, input.toNumber("III"));
		assertEquals(30, input.toNumber("XXX"));
	}

	@Test
	public void aLargeRomanNumeraltoaNumberWithoutSubtraction() {
		assertEquals(77, input.toNumber("LXXVII"));
		assertEquals(3671, input.toNumber("MMMDCLXVVI"));
	}

	@Test
	public void aLargeRomanNumeraltoaNumberWithSubtraction() {
		assertEquals(74, input.toNumber("LXXIV"));
		assertEquals(439, input.toNumber("CDXXXIX"));
		assertEquals(3934, input.toNumber("MMMCMXXXIV"));
	}
	
	@Test
	public void aNumberToASingleRoman() {
		assertEquals("I", input.toRoman(1));
		assertEquals("V", input.toRoman(5));
		assertEquals("X", input.toRoman(10));
	}

	@Test
	public void aNumberToMultipleRomansNoAdditionOrSubtraction() {
		assertEquals("II", input.toRoman(2));
		assertEquals("III", input.toRoman(3));
		assertEquals("MMMCCCXXXIII", input.toRoman(3333));
	}
	
	@Test
	public void aNumberToARomanNumeralWithAddition() {
		assertEquals("VI", input.toRoman(6));
		assertEquals("VII", input.toRoman(7));
		assertEquals("VIII", input.toRoman(8));
	}

	@Test
	public void aNumberToARomanNumeralWithSubtraction() {
		assertEquals("IV", input.toRoman(4));
		assertEquals("IX", input.toRoman(9));
		assertEquals("XIV", input.toRoman(14));
	}
	
	@Test
	public void aNumberToARomanWithMultipleSubtractions() {
		assertEquals("XLIX", input.toRoman(49));
		assertEquals("CCXLIX", input.toRoman(249));
		assertEquals("CCCXCIV", input.toRoman(394));
		assertEquals("MMMCMXLIX", input.toRoman(3949));
	}
}
