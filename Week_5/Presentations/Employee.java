public class Employee implements Payable {
	private String name;
	private int salary;
		
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	@Override
	public int amount() { return salary; }
	@Override
	public String toString() { return name; }
}
