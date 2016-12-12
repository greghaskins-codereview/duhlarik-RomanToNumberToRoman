package roman;

public class RomanToNumberToRoman {

	char[] romans = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
	int[] numbers = { 1, 5, 10, 50, 100, 500, 1000 };

	public int toNumber(String roman) {

		int intValueOfRoman = 0;
		char currentRoman;
		int valueOfCurrentRoman = 0;
		int valueOfRomanToTheLeft = 0;
		int i = roman.length() - 1;
		while (i >= 0) {
			currentRoman = roman.charAt(i);
			valueOfCurrentRoman = getIntValueOfCurrentRoman(currentRoman);
			valueOfRomanToTheLeft = getIntValueOfRomanToTheLeft(roman, valueOfRomanToTheLeft, i);
				if (valueOfRomanToTheLeft > 0 && valueOfRomanToTheLeft < valueOfCurrentRoman) {
					valueOfRomanToTheLeft *= -1;
					valueOfCurrentRoman += valueOfRomanToTheLeft;
					i--;
				}
			intValueOfRoman += valueOfCurrentRoman;
			i--;
		}
		return intValueOfRoman;
	}

	private int getIntValueOfRomanToTheLeft(String roman, int valueOfRomanToTheLeft, int i) {
		char romanToTheLeft;
		if(i > 0) {
			romanToTheLeft = roman.charAt(i-1);
			valueOfRomanToTheLeft = getIntValueOfCurrentRoman(romanToTheLeft);
		}
		return valueOfRomanToTheLeft;
	}

	private int getIntValueOfCurrentRoman(char currentRoman) {
		int currentNumber= -1;
		for (int j = 0; j < romans.length; j++) {
			if (currentRoman == romans[j]) {
				currentNumber = numbers[j];
				break;
			}
		}
		return currentNumber;
	}
}
