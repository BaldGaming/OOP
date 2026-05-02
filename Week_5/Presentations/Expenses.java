public class Expenses {
	private int total = 0;
	private Payable mostExpensive = null;
	
	public void addExpense(Payable p) {
		total += p.amount();
		if (mostExpensive == null ||
				p.amount() > mostExpensive.amount())
			mostExpensive = p;
	}

	public int getTotal() {
		return total;
	}
	
	public Payable mostExpensive() {
		return mostExpensive;
	}
}
