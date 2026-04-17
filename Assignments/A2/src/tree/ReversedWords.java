package tree;

import java.util.Scanner;

public class ReversedWords {

    public static int checkReversed() {
        // Initialize a tree, a scanner and a counter for the instances of reversed words
        int count = 0;
        Node tree = new Node();
        Scanner scanner = new Scanner(System.in);

        // Get user input
        while (scanner.hasNext()) {
            // We get the next word
            String input = scanner.next();

            if (input.equals("X")) break; // Exit condition

            // Reverse the string using StringBuilder
            String reversed = new StringBuilder(input).reverse().toString();

            if (tree.num(reversed) > 0)
                count++;

            tree.add(input);
        }
        return count;
    }
}
