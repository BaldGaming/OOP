public class Invoice implements Payable {
	private String company;
	private int quantity;
	private int price;

	public Invoice(String company, int quantity,
			int price) {
		this.company = company;
		this.quantity = quantity;
		this.price = price;
	}

	@Override
	public int amount() { 
		return quantity * price; 
	}

	@Override
	public String toString() {
		return String.format("%s %d at %d each", 
				company, quantity, price);
	}
}
