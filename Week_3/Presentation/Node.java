public class Node {
	private Node next;
	private int val;

	public Node(int val, Node next) {
		this.val = val;
		this.next = next;
	}
	public double getCost() {
		return val * 1.17;
	}
	
	public double getTotalCost() {
		return getCost() + (next == null ? 0 : 
					next.getTotalCost());
	}
}
