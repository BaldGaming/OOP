package Week_2.Presentation;
public class Node {
	private int val;
	private Node next;	
	
	public Node(int val, Node next) {
		this.val = val;
		this.next = next;
	}
	public int getVal() { return val; }
	public Node getNext() { return next; }
	
	public boolean contains(int val) {
		if (this.val == val) 
			return true;
		if (next == null)
			return false;
		return next.contains(val);
	}
}
