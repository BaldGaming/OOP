package Week_3.Lab;

public class List {
    private Node head, tail;

    public void addAtHead(int val) {
        head = new Node(null, val, head);

        if (tail == null)
            tail = head;
    }

    public void addAtTail(int val) {
        tail = new Node(tail, val, null);

        if (head == null)
            head = tail;
    }

    private int del(Node node) {
        if (node == null) {
            System.err.println("Node does not exist");
            return -1;
        }

        if (node == head)
            head = head.getNext();

        if (node == tail)
            tail = tail.getPrev();

        return node.discard();
    }

    public int delHead() {
        return del(head);
    }

    public int delTail() {
        return del(tail);
    }

    public int delAt(int i) {
        return del(head.get(i));
    }
}
