package factory_design_pattern;

public abstract class Computer {
	public abstract String getRAM();

	public abstract String getCPU();

	public abstract String getHDD();

	@Override
	public String toString() {
		return "RAM= " + this.getRAM() + ", HDD=" + this.getHDD() + ", CPU=" + this.getCPU();
	}
}
