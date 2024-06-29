package chain_of_responsibilities;

/*
 * 
 * 
 * Chain of Responsibility Design Pattern - Base Classes and Interface
We can create a class Currency that will store the amount to dispense and used by the chain implementations. Currency.java
 */
public class Currency {
	private int amount;

	public Currency(int amt) {
		this.amount = amt;
	}

	public int getAmount() {
		return this.amount;
	}
}
