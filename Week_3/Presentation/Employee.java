public class Employee {
	private String name;
	protected int monthlySalary;

	public Employee(String name, int monthlySalary) {
		this.name = name;
		this.monthlySalary = monthlySalary;
	}
	
	public double earnsInYear() {
		return monthlySalary * 12;
	}
	
	public String toString() {
		return String.format("%s earns %.0f", name,
				earnsInYear());
	}
}
