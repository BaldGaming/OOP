public class Node2 extends Node {
	private int quantity;

	public Node2(int val, Node2 next, int quantity) {
		super(val, next);
		this.quantity = quantity;
	}
	@Override
	public double getCost() {
		return super.getCost() * quantity;
	}
}
