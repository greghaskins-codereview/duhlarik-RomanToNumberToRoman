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
			if (valueOfCurrentRoman < valueOfPreviousRoman) {
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
		StringBuilder finalRoman = new StringBuilder();
		int powerOf = 0;
		int baseNumber = 0;
		int remainder = number;
		int specialCaseTest;
		final int specialCaseFor4 = 4;
		final int specialCaseFor9 = 9;
		while (remainder > 0) {
			powerOf = (int) (Math.log10(remainder));
			baseNumber = (int) (Math.pow(10, powerOf));
			specialCaseTest = remainder / baseNumber;
			if (specialCaseTest == specialCaseFor9) {
				remainder = specialCaseFor9(finalRoman, baseNumber, remainder, specialCaseFor9);
			} else if (specialCaseTest == specialCaseFor4) {
				remainder = specialCaseFor4(finalRoman, baseNumber, remainder, specialCaseFor4);
			} else
				remainder = findARegularRomanNumeral(finalRoman, remainder);
		}
		return finalRoman.toString();
	}

	private int findARegularRomanNumeral(StringBuilder finalRoman, int remainder) {
		for (int k = numbers.length - 1; k >= 0; k--) {
			if (remainder >= numbers[k]) {
				finalRoman.append(romans[k]);
				remainder -= numbers[k];
				break;
			}
		}
		return remainder;
	}

	private int specialCaseFor4(StringBuilder finalRoman, int baseNumber, int remainder, final int specialCaseFor4) {
		for (int m = numbers.length - 1; m >= 0; m--) {
			if (baseNumber == numbers[m]) {
				finalRoman.append(romans[m]);
				finalRoman.append(romans[m + 1]);
				remainder -= (specialCaseFor4 * baseNumber);
				break;
			}
		}
		return remainder;
	}

	private int specialCaseFor9(StringBuilder finalRoman, int baseNumber, int remainder, final int specialCaseFor9) {
		for (int m = numbers.length - 1; m >= 0; m--) {
			if (baseNumber == numbers[m]) {
				finalRoman.append(romans[m]);
				finalRoman.append(romans[m + 2]);
				remainder -= (specialCaseFor9 * baseNumber);
				break;
			}
		}
		return remainder;
	}
}