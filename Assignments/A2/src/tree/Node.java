package tree;

public class Node {
    private int count;
    private Node[] children;

    public Node() {
        count = 0;
        children = new Node[26];
    }


    // This method follows a path to see if a word exists and how many times it was added
    public int num(String s) {
        // Base case: we reach the end of the word
        if (s.isEmpty())
            return count; // We return how many times it was added

        // We find the index through conversion
        int index = s.charAt(0) - 'a';

        // If the path doesn't exist, the word isn't in the tree
        if (children[index] == null)
            return 0;
        
        // We ask the child node to keep looking
        return children[index].num(s.substring(1));
    }


    // This method builds a path for a word
    public void add(String s) {
        // Base case: the word ends here
        if (s.isEmpty()) {
            count++;
            return;
        }

        // We find the index through conversion
        int index = s.charAt(0) - 'a';

        // If there is no node for this letter, create one
        if (children[index] == null)
            children[index] = new Node();

        // Pass the rest of the string into the child
        children[index].add(s.substring(1));
    }
}