package roman;

public class RomanToNumberToRoman {

	char[] romans = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
	int[] numbers = { 1, 5, 10, 50, 100, 500, 1000 };

	public int toNumber(String roman) {

		int intValueOfRoman = 0;
		char currentRoman;
		int currentNumber = 0;
		int leftNumber = 0;
		int i = roman.length() - 1;
		while (i >= 0) {
			currentRoman = roman.charAt(i);
			currentNumber = getIntValueOfCurrentRoman(currentRoman);
			leftNumber = getIntValueOfRomanToTheLeft(roman, leftNumber, i);
				if (leftNumber > 0 && leftNumber < currentNumber) {
					leftNumber *= -1;
					currentNumber += leftNumber;
					i--;
				}
			intValueOfRoman += currentNumber;
			i--;
		}
		return intValueOfRoman;
	}

	private int getIntValueOfRomanToTheLeft(String roman, int leftNumber, int i) {
		char leftRoman;
		if(i > 0) {
			leftRoman = roman.charAt(i-1);
			leftNumber = getIntValueOfCurrentRoman(leftRoman);
		}
		return leftNumber;
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
