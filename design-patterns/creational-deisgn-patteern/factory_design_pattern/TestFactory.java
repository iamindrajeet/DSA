package factory_design_pattern;

/*
 * 
 * Factory Design Pattern Advantages
	1. Factory design pattern provides approach to code for interface rather than implementation.
	2. Factory pattern removes the instantiation of actual implementation classes from client code. 
		Factory pattern makes our code more robust, less coupled and easy to extend. 
		For example, we can easily change PC class implementation because client program is unaware of this.
	3. Factory pattern provides abstraction between implementation and client classes through inheritance.
 */
public class TestFactory {
	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.4 GHz");
		Computer server = ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz");
		System.out.println("Factory PC Config::" + pc.toString());
		System.out.println("Factory Server Config::" + server.toString());
	}
}
