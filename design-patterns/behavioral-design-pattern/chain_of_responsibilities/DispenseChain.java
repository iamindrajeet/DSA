package chain_of_responsibilities;
/*
 * 
 * 
 * The base interface should have a method to define the next processor in the chain and the method that will process the request.
 *  Our ATM Dispense interface will look like below. DispenseChain.java
 */
public interface DispenseChain {

	void setNextChain(DispenseChain nextChain);
	
	void dispense(Currency cur);
}