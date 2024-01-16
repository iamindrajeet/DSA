package questions.recursion;

/**
 * Convert decimal to binary recursively
 * 
 * Step 1: Divide the number by 2
 * Step 2: Get the integer quotient for the next iteration
 * Step 3: Get the remainder for the binary digit
 * Step 4: Repeat the steps until the quotient is equal to 0
 * 
 * Our recursive case will be - f(n) = n mod 2 + 10 * f(n/2)
 */

public class DecimalToBinary {
	public int decimalToBinary(int number) {
		if(number == 0)
			return 0;
		return number % 2 + 10 * decimalToBinary(number / 2);
	}
}
