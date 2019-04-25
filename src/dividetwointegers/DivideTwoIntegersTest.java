/*
 * Date:	2019-04-24
 * Author:	Tenzin Khando
 * Description: Perform division without multiplication, division, or mod operator.
 */

package dividetwointegers;

import junit.framework.Assert;
import org.junit.Test;

public class DivideTwoIntegersTest {
	
	//TODO: Test REALLY BIG DATA Difference
	@Test
	public void divideByOne(){
		
		final int expected = 2147483647;
		
		int solution = new DivideTwoIntegers().divide( 2147483647, 1);
		System.out.println("divideByOne"); 
		System.out.println("Expected: " + expected + " | Solution: " + solution);  
		
		Assert.assertEquals(expected, solution);
	}
	
	//TODO: Test simpleDivision
	@Test
	public void simpleDivision(){
		
		final int expected = 3;
		
		int solution = new DivideTwoIntegers().divide( 10, 3);
		System.out.println("simpleDivision"); 
		System.out.println("Expected: " + expected + " | Solution: " + solution);  
		
		Assert.assertEquals(expected, solution);
	}
}
