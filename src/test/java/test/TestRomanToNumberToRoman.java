package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import roman.RomanToNumberToRoman;

public class TestRomanToNumberToRoman {
	RomanToNumberToRoman roman;

	@Before
	public void setUp() {
	roman = new RomanToNumberToRoman();
	}

	@Test
	public void romanItoNumber1() {
		assertEquals(1, roman.toNumber("I"));
	}

	@Test
	public void romanVtoNumber5() {
		assertEquals(5, roman.toNumber("V"));
	}

	@Test
	public void romanXtoNumber10() {
		assertEquals(10, roman.toNumber("X"));
	}

	@Test
	public void twoOfTheSameRomanNumeralsToANumber() {
		assertEquals(2, roman.toNumber("II"));
	}

	@Test
	public void twoDifferentRomanNumeralsAddedTogether() {
		assertEquals(6, roman.toNumber("VI"));
	}

	@Test
	public void twoDifferentRomanNumeralsSubtractedToGetNumber() {
		assertEquals(4, roman.toNumber("IV"));
	}

	@Test
	public void threeOfTheSameRomanNumeraltoaNumber_IIIto3() {
		assertEquals(3, roman.toNumber("III"));
	}

	@Test
	public void threeOfTheSameRomanNumeraltoaNumber_XXXto30() {
		assertEquals(30, roman.toNumber("XXX"));
	}
	
	@Test
	public void aLargeRomanNumeraltoaNumberWithoutSubtraction() {
		assertEquals(77, roman.toNumber("LXXVII"));
	}
	
	@Test
	public void aLargeRomanNumeraltoaNumberWithSubtraction() {
		assertEquals(74, roman.toNumber("LXXIV"));
	}
	
	@Test
	public void aLargeRomanNumeralWithThreeOfTheSameNumeralWithSubtraction() {
		assertEquals(39, roman.toNumber("XXXIX"));
	}
	
	@Test
	public void aVeryLargeRomanNumeralWithManyOfTheSameNumeralWithSubtraction() {
		assertEquals(3934, roman.toNumber("MMMCMXXXIV"));
	}
	
	@Test
	public void aVeryLargeRomanNumeralWithThreeOfTheSameNumeralWithoutSubtraction() {
		assertEquals(3000, roman.toNumber("MMM"));
	}
}
