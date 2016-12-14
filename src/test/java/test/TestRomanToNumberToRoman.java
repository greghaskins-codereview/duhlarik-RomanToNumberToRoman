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
	public void twoDifferentRomanNumeralsSubtractedToGetNumber() {
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
	public void theNumber1ToASingleRomanI() {
		assertEquals("I", input.toRoman(1));
	}

	@Test
	public void theNumber2ToTwoOfTheSameRomanNumeral_II() {
		assertEquals("II", input.toRoman(2));
	}

	@Test
	public void theNumber3ToThreeOfTheSameRomanNumeral_III() {
		assertEquals("III", input.toRoman(3));
	}
	@Test
	public void theNumber4ToARomanNumeralWithSubtraction_IV() {
		assertEquals("IV", input.toRoman(4));
	}
	
	@Test
	public void theNumber5ToASingleRomanV() {
		assertEquals("V", input.toRoman(5));
	}

	@Test
	public void theNumber6ToARomanWithAddition_VI() {
		assertEquals("VI", input.toRoman(6));
	}

	@Test
	public void theNumber7ToARomanWithAddition_VII() {
		assertEquals("VII", input.toRoman(7));
	}

	@Test
	public void theNumber8ToARomanWithAddition_VIII() {
		assertEquals("VIII", input.toRoman(8));
	}

	@Test
	public void theNumber9ToARomanWithSubtraction_IX() {
		assertEquals("IX", input.toRoman(9));
	}

	@Test
	public void theNumber10ToASingleRoman_X() {
		assertEquals("X", input.toRoman(10));
	}

	@Test
	public void theNumber11ToARomanWithAddition_XI() {
		assertEquals("XI", input.toRoman(11));
	}
	
	@Test
	public void theNumber12ToARomanWithAddition_XII() {
		assertEquals("XII", input.toRoman(12));
	}

	@Test
	public void theNumber13ToARomanWithAddition_XIII() {
		assertEquals("XIII", input.toRoman(13));
	}
}
