package questions.recursion;

public class PowerOfNumber {
	public int powerOfNumber(int base, int exponent) {
		if(exponent < 0)
			return -1;
		if (exponent == 0)
			return 1;
		return base * powerOfNumber(base, exponent - 1);
	}
}
