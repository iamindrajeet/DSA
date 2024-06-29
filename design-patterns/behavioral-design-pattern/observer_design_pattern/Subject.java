package observer_design_pattern;

/*
 * 
 * 
 * For our observer pattern java program example, we would implement a simple topic and observers can register to this topic. 
 * Whenever any new message will be posted to the topic, all the registers observers will be notified and they can consume the message. 
 * Based on the requirements of Subject, here is the base Subject interface that defines the contract methods to be implemented by any 
 * concrete subject.
 */

public interface Subject {

	//methods to register and unregister observers
	public void register(Observer obj);
	public void unregister(Observer obj);
	
	//method to notify observers of change
	public void notifyObservers();
	
	//method to get updates from subject
	public Object getUpdate(Observer obj);
	
}
