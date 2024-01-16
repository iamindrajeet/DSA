package questions.recursion;

/**
 * GCD can be calculated using Euclidean algorithm
 * gcd(48, 18) can be calculated as below
 * step 1: 48/18 = 2 remainder 12
 * step 2: 18/12 = 1 remainder 6
 * step 3: 12/6 = 2 remainder 0
 *
 * gcd(a, 0) = a
 * gcd(a,b) = gcd(b, a mod b)
 */
public class GCD {

	public int gcd(int number1, int number2) {
		if (number1 < 0 || number2 < 0)
			return -1;
		if (number2 == 0) {
			return number1;
		}
		return gcd(number2, number1 % number2);
	}
}
