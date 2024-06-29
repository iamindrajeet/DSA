package abstract_factory_design_pattern;

/*
 * ----Factory Class for Each subclass----
 * First of all we need to create a Abstract Factory interface or abstract class.
 */

public interface ComputerAbstractFactory {
	public Computer createComputer();
}
