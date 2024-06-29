package abstract_factory_design_pattern;

/*
 * Abstract Factory Design Pattern Benefits
	1.Abstract Factory design pattern provides approach to code for interface rather than implementation.
	2.Abstract Factory pattern is “factory of factories” and can be easily extended to accommodate more products, 
	for example we can add another sub-class Laptop and a factory LaptopFactory.
	3.Abstract Factory pattern is robust and avoid conditional logic of Factory pattern.
 */
public class TestFactory {
	public static void main(String[] args) {
		testAbstractFactory();
	}

	private static void testAbstractFactory() {
		Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB", "500 GB", "2.4 GHz"));
		Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB", "1 TB", "2.9 GHz"));
		System.out.println("AbstractFactory PC Config::" + pc);
		System.out.println("AbstractFactory Server Config::" + server);
	}
}
