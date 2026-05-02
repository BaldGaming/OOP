public class MainForExpenses {
	public static void main(String[] args) {
		Expenses e = new Expenses();
		e.addExpense(new Employee("Peter Pan",1000));
		e.addExpense(new Employee("Tinkerbell",2000));
		e.addExpense(new Invoice("Pirates.com",1000,3));

		System.out.println("Total is " + e.getTotal());
		// Total is 6000
		System.out.println(
				"Most Expensive: " + e.mostExpensive());
		// Most Expensive: Pirates.com 1000 at 3 each
	}
}
