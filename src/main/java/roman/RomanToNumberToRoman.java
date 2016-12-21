package roman;

public class RomanToNumberToRoman {

	char[] romans = { 'I', 'V', 'X', 'L', 'C', 'D', 'M', 'ↁ', 'ↂ'};
	int[] numbers = { 1, 5, 10, 50, 100, 500, 1000, 5000, 10000 };

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
		boolean isIt4or9 = false;
		int checkFor4or9 = 0;
		int indexFor4or9 = 0;
		while (remainder > 0) {
			powerOf = (int) (Math.log10(remainder));
			baseNumber = (int) (Math.pow(10, powerOf));
			checkFor4or9 = remainder / baseNumber;
			if (checkFor4or9 == 9 || checkFor4or9 == 4) {
				isIt4or9 = true;
			}
			if (isIt4or9 == true) {
				if (checkFor4or9 == 9) {
					indexFor4or9 = 2;
				} else  indexFor4or9 = 1;
				remainder = findTheRomanFor4or9(finalRoman, baseNumber, indexFor4or9, remainder, checkFor4or9);
			} else remainder = findTheRomanNumeral(finalRoman, remainder);
		}
		return finalRoman.toString();
	}

	private int findTheRomanNumeral(StringBuilder finalRoman, int remainder) {
		for (int m = numbers.length - 1; m >= 0; m--) {
			if (remainder >= numbers[m]) {
				finalRoman.append(romans[m]);
				remainder -= numbers[m];
				break;
			}
		}
		return remainder;
	}

	private int findTheRomanFor4or9(StringBuilder finalRoman, int baseNumber, int indexFor4or9, int remainder,
			int checkFor4or9) {
		for (int m = numbers.length - 1; m >= 0; m--) {
			if (baseNumber == numbers[m]) {
				finalRoman.append(romans[m]);
				finalRoman.append(romans[m + indexFor4or9]);
				remainder -= (checkFor4or9 * baseNumber);
				break;
			}
		}
		return remainder;
	}
}