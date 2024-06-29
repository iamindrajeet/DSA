package questions;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

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
		
		LocalDateTime myObj = LocalDateTime.now();
	    System.out.println(myObj); 
	    
	    // Get the current LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now();

        // Specify the source time zone (current system time zone)
        ZoneId sourceZoneId = ZoneId.systemDefault();
        
        System.out.println(sourceZoneId);

        // Specify the target time zone (Eastern Time)
        ZoneId targetZoneId = ZoneId.of("America/New_York");

        // Convert LocalDateTime to ZonedDateTime in source time zone
        ZonedDateTime sourceZonedDateTime = localDateTime.atZone(sourceZoneId);

        // Convert ZonedDateTime to Eastern Time
        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(targetZoneId);

        // Get the LocalDateTime in Eastern Time
        LocalDateTime easternLocalDateTime = targetZonedDateTime.toLocalDateTime();

        // Output the converted LocalDateTime
        System.out.println("LocalDateTime in Eastern Time: " + easternLocalDateTime);

	}
}
