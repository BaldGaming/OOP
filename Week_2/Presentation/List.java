package Week_2.Presentation;

public class List {
	private Node head;
	
	public void add(int val) {
		head = new Node(val, head);
	}	
	
	public boolean contains(int val) {
		if (head == null)
			return false;
		return head.contains(val);
	}

	public String toString() {
		String res = "";
		for (Node c = head; c != null; c = c.getNext()) 
			res += " " + c.getVal();
		return res;
	}
}
