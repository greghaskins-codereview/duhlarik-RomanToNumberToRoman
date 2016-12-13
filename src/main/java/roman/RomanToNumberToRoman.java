package roman;

public class RomanToNumberToRoman {

	char[] romans = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
	int[] numbers = { 1, 5, 10, 50, 100, 500, 1000 };

	public int toNumber(String roman) {

		int intValueOfRoman = 0;
		char currentRoman;
		int valueOfCurrentRoman = 0;
		int valueOfPreviousRoman = 0;
		int i = roman.length() - 1;
		while (i >= 0) {
			currentRoman = roman.charAt(i);
			valueOfCurrentRoman = getIntValueOfCurrentRoman(currentRoman);
			if (valueOfCurrentRoman > 0 && valueOfCurrentRoman < valueOfPreviousRoman) {

				valueOfCurrentRoman *= -1;
			}
			intValueOfRoman += valueOfCurrentRoman;
			valueOfPreviousRoman = valueOfCurrentRoman;
			i--;
		}
		return intValueOfRoman;
	}

	private int getIntValueOfCurrentRoman(char currentRoman) {
		int currentNumber = -1;
		for (int j = 0; j < romans.length; j++) {
			if (currentRoman == romans[j]) {
				currentNumber = numbers[j];
				break;
			}
		}
		return currentNumber;
	}

	public String toRoman(int number) {
		StringBuilder sb = new StringBuilder();
		char currentNumeral = ' ';
		if (number < 4) {
			while (number > 0) {
				currentNumeral = romans[0];
				sb.append(currentNumeral);
				number--;
			}
		} else if (number == 4) {
			sb.append('I');
			sb.append('V');
		} else if (number > 5 && number < 9) {
			sb.append('V');
			number -= 5;
			while (number > 0) {
				currentNumeral = romans[0];
				sb.append(currentNumeral);
				number--;
			}
		} else if (number == 9) {
			sb.append('I');
			sb.append('X');
		} else {
			for (int k = 0; k < numbers.length; k++) {
				if (number == numbers[k]) {
					currentNumeral = romans[k];
					sb.append(currentNumeral);
					break;
				}
			}
		}

		return sb.toString();
	}
}