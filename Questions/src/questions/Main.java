package questions;

import questions.recursion.DecimalToBinary;
import questions.recursion.GCD;
import questions.recursion.PowerOfNumber;
import questions.recursion.SumOfDigits;

public class Main {
	public static void main(String[] args) {
		QueueViaStack queueViaStack = new QueueViaStack();
		queueViaStack.enQueue(1);
		queueViaStack.enQueue(2);
		queueViaStack.enQueue(3);
		//System.out.println(queueViaStack.peek());
//		System.out.println(queueViaStack.deQueue());
//		System.out.println(queueViaStack.deQueue());
		queueViaStack.enQueue(4);
		//System.out.println(queueViaStack.peek());
		
		SumOfDigits sumOfDigits = new SumOfDigits();
		System.out.println(sumOfDigits.sumOfDigits(-10));
		
		PowerOfNumber powerOfNumber = new PowerOfNumber();
		System.out.println(powerOfNumber.powerOfNumber(3, -2));
		
		GCD gcd = new GCD();
		System.out.println(gcd.gcd(8, 4));
		
		DecimalToBinary decimalToBinary = new DecimalToBinary();
		System.out.println(decimalToBinary.decimalToBinary(13));
	}
}
