/*
 * Date:	2019-04-24
 * Author:	Tenzin Khando
 * Description: Perform division without multiplication, division, or mod operator.
 */

package dividetwointegers;

public class DivideTwoIntegers {

	final int MAX_INT = 2147483647;
	final int MIN_INT = -2147483648;

	/*
	 * Main Function
	 * 
	 * @param dividend This is the top number when dividing
	 * 
	 * @param divisor This is the bottom number when dividing
	 */
	public int divide(int dividend, int divisor) {

		// if (divisor == 0) throw new
		// IllegalArgumentException("Can't Divide by zero!");
		switch (divisor) {
		case 0:
			// can't divide by 0
			return -1;
		case 1:
			// dividing by 1 will return dividend
			return dividend;
		case -1:
			return -dividend;
		}

		// fraction numbers, dividend < divisor
		if (dividend == 0
				|| (divisor > 0 && dividend > 0 && dividend < divisor)
				|| (divisor > 0 && dividend < 0 && Math.abs(dividend) < divisor))
			return 0;

		if (divisor == dividend)
			return 1;

		boolean negativeDivisor = false;
		boolean isMinInt = false;

		// only change sign if one of the input is negative
		if (divisor < 0 && dividend > 0) {
			negativeDivisor = true;
			divisor = Math.abs(divisor);
		} else if (divisor > 0 && dividend < 0) {
			negativeDivisor = true;
			// min int is off by 1 for the max int
			if (dividend == MIN_INT) {
				isMinInt = true;
				++dividend;
			}
			dividend = Math.abs(dividend);
		} else if (divisor < 0 && dividend < 0) {
			divisor = Math.abs(divisor);
			// min int is off by 1 for the max int
			if (dividend == MIN_INT) {
				isMinInt = true;
				++dividend;
			}
			dividend = Math.abs(dividend);
		}

		String temp = partialDivider(Integer.toString(dividend), divisor);

		int counter = Integer.parseInt(temp);

		if (negativeDivisor) {
			counter = isMinInt ? -counter - 1 : -counter;
		}

		return counter;
	}

	/*
	 * Helper Function:
	 * 
	 * Take each char of the dividend and get the number divisble by the divisor
	 */
	private String partialDivider(String dividend, int divisor) {
		String divisibleNumber = "";
		StringBuilder singleDividendDigit = new StringBuilder();

		// for each digit
		for (char digit : dividend.toCharArray()) {
			singleDividendDigit.append(digit);

			String divisible = "";
			int partialDividendNumber = Integer.parseInt(singleDividendDigit
					.toString());
			int sum = divisor;

			if (divisor > partialDividendNumber) {
				divisible = "0";
			} else if (divisor == partialDividendNumber) {
				divisible = "1";
			} else {
				// get the number of times divisor goes into
				// partialdividendNumber
				// TODO: Create a map to store already visited numbers
				// TODO: not working when divisor is 1
				int counter = 1;
				while (sum <= partialDividendNumber) {
					// System.out.println("Dividend: " + dividend + "| Sum: " +
					// sum + "| Counter: " + counter);
					counter++;
					try {
						sum = Math.addExact(sum, divisor);
					} catch (ArithmeticException e) {
						// catch overflow
						// only Java 8+
						break;
					}
				}

				// ONLY: decrease by 1 if divisor is greater than dividend
				if (sum != partialDividendNumber) {
					counter--;
					sum -= divisor;
				}

				divisible = Integer.toString(counter);
			}

			// reset the dividend number if its not 0
			if (divisible != "0") {
				// System.out.println("PartialDividend: " +
				// partialDividend.toString() + "| Sum: " + sum);
				int newPartialDividend = Integer.parseInt(singleDividendDigit
						.toString()) - sum;
				singleDividendDigit.setLength(0);
				singleDividendDigit.append(newPartialDividend);
			}

			divisibleNumber += divisible;
			// System.out.println("Digit: " + digit + "| divisor: " + divisor +
			// "| divisible: " + divisible + "| PartialDividend: " +
			// partialDividend.toString() + "| Counter: " + divisibleNumber);
		}

		return divisibleNumber;
	}
}
