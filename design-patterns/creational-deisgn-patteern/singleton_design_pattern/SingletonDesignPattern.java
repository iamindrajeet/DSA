package singleton_design_pattern;

public class SingletonDesignPattern {
	public static SingletonDesignPattern instance = null;
	
	private SingletonDesignPattern() {
	}
	
	public static SingletonDesignPattern getInstance() {
		if(instance == null) {
			synchronized(SingletonDesignPattern.class) {
				if(instance == null)
					instance = new SingletonDesignPattern();
			}
		}
		return instance;
	}
	
	public static void main(String[] args) {
		SingletonDesignPattern instance1 = SingletonDesignPattern.getInstance();
		SingletonDesignPattern instance2 = SingletonDesignPattern.getInstance();
		
		System.out.println(instance1.hashCode() + " " + instance2.hashCode());
	}
}