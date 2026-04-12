public class CommissionEmployee extends Employee {
	private double commission; // between 0 and 1
	private double sales;
	
	public CommissionEmployee(String name, int salary, 
			double commission) {
		super(name, salary);
		this.commission = commission;
	}
	
	public void setSales(double sales) {
		this.sales = sales;
	}
	
	@Override 
	public double earnsInYear() {
		return commission * sales + 12 * monthlySalary;
	}
}
