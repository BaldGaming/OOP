package Week_3.Lab;

class Node {
    int val;
    private Node next, prev;

    public Node(Node next, int val, Node prev) {
        this.prev = prev;
        this.val = val;
        this.next = next;

        if (next != null)
            next.prev = this;

        if (prev != null)
            prev.next = this;
    }

    public int getVal() {
        return val;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public Node get(int i) {
        if (i == 0)
            return this;

        if (next == null)
            return null;

        return next.get(i - 1);
    }

    public int discard() {
        if (prev != null)
            prev.next = next;

        if (next != null)
            next.prev = prev;

        return val;
    }
}
