/*
 * Date:	2019-04-24
 * Author:	Tenzin Khando
 * Description: Perform division without multiplication, division, or mod operator.
 */

package dividetwointegers;

import junit.framework.Assert;
import org.junit.Test;

public class DivideTwoIntegersTest {
	
	/*
	 * This function is used throughout the code for testing.
	 * Easier to understand how the test is done by knowing this first.
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */
	private void executeTests(
			int dividend, int divisor, 
			int expectedResult, String funcName) 
	{
		final int expected = expectedResult;
		
		int solution = new DivideTwoIntegers().divide( dividend, divisor);
		System.out.println(funcName); 
		System.out.println("DIVIDEND: " + dividend + 
							"\t DIVISOR: " + divisor);
		System.out.println("Expected: " + expected + " | Solution: " + solution);  
		
		Assert.assertEquals(expected, solution);
	}
	
	/*
	 * Test REALLY BIG DATA Difference
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */
	@Test
	public void divideByOne() { 
		executeTests( 2147483647,  1, 2147483647, "divideByOne" );	
	}
	
	/*
	 * bothPositive
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */
	@Test
	public void bothPositive() { 
		executeTests(10,  3, 3, "bothPositive");	
	}

	/*
	 * negativeDivisor
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void bothNegative() { 
		executeTests(-7, -3, -2, "bothNegative");	
	}

	/*
	 * negativeDivisor
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void negativeDivisor() { 
		executeTests(7, -3, -2, "negativeDivisor");	
	}
	
	/*
	 * negativeDivisor
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void negativeDividend() { 
		executeTests(-7, 3, -2, "negativeDividend");	
	}
	
	/*
	 * divideByZero
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void divideByZero() { 
		executeTests(0, 0, 0, "divideByZero");	
	}
	
	/*
	 * divideByZeroDivisor
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void divideByZeroDivisor() { 
		executeTests(0, 7, 0, "divideByZero");	
	}
	
	/*
	 * divideByZeroDividend
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void divideByZeroDividend() { 
		executeTests(7, 0, 0, "divideByZeroDividend");	
	}	
	
	/*
	 * negativeDivisor
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void bothNegativeOnes() { 
		executeTests(-1, -1, 1, "bothNegativeOnes");	
	}

	/*
	 * negativeDivisor
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void negativeDivisorOnes() { 
		executeTests(1, -1, -1, "negativeDivisorOnes");	
	}
	
	/*
	 * negativeDividendOnes
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void negativeDividendOnes() { 
		executeTests(-1, 1, -1, "negativeDividendOnes");	
	}
	
	/*
	 * randomNumbers
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void randomNumbers() { 
		executeTests(21474, 34928, 0, "randomNumbers");	
	}
	
	/*
	 * randomNumbers2
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void randomNumbers2() { 
		executeTests(981256, 4598, 213, "randomNumbers2");	
	}
	
	/*
	 * randomNumbers3
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void randomNumbers3() { 
		executeTests(5461, 56, 97, "randomNumbers3");	
	}	
	
	/*
	 * maxDividend
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void maxDividend() { 
		executeTests(2147483647, 34509349, 62, "maxDividend");	
	}
	
	/*
	 * maxDividendNegativeDivisor
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void maxDividendNegativeDivisor() { 
		executeTests(2147483647, -34509349, -62, "maxDividendNegativeDivisor");	
	}
	
	/*
	 * maxDividendBothNegative
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void maxDividendBothNegative() { 
		executeTests(-2147483648, -56568898, 37, "maxDividendBothNegative");	
	}
	
	/*
	 * maxDividendBothNegative
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void minDividendPositiveDivisor() { 
		executeTests(-2147483648, 56568898, -37, "maxDividendBothNegative");	
	}
	
	/*
	 * maxDividendBothNegative
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void minDividendBiggestDeltaNegative() { 
		executeTests(-2147483648, -2, 1073741824, "minDividendBiggestDeltaNegative");	
	}
	
	/*
	 * minDividendBiggestDeltaPositive
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void minDividendBiggestDeltaPositive() { 
		executeTests(-2147483648, 2, -1073741824, "minDividendBiggestDeltaPositive");	
	}
	
	/*
	 * maxDividendBiggestDeltaNegative
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void maxDividendBiggestDeltaNegative() { 
		executeTests(2147483647, -2, -1073741823, "maxDividendBiggestDeltaNegative");	
	}
	
	/*
	 * maxDividendBiggestDeltaPositive
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void maxDividendBiggestDeltaPositive() { 
		executeTests(2147483647, 2, 1073741823, "maxDividendBiggestDeltaPositive");	
	}
	
	/*
	 * sameDividendDivisor
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void maxIntsameDividendDivisor() { 
		executeTests(2147483647, 2147483647, 1, "maxIntsameDividendDivisor");	
	}
	
	/*
	 * minIntsameDividendDivisor
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void minIntsameDividendDivisor() { 
		executeTests(-2147483648, -2147483648, 1, "minIntsameDividendDivisor");	
	}
	
	/*
	 * minIntsameDividendDivisor
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void maxDividendminDivisor() { 
		executeTests(2147483647, -2147483648, 0, "minIntsameDividendDivisor");	
	}
	
	/*
	 * minDividendmaxDivisor
	 * 
	 * executeTests( dividend, divisor, expectedResult, funcName) 
	 * 
	 */ 
	@Test
	public void minDividendmaxDivisor() { 
		executeTests(-2147483648,2147483647 , -1, "minDividendmaxDivisor");	
	}

}
