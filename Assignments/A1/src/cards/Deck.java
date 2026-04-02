package cards;

public class Deck {
    private Card[] stack;
    private int size;

    public Deck(int num) {
        this.stack = new Card[num * 4];
        this.size = 0;
        int i, j;

        for (i = 0; i < num; i++) {
            for (j = 0; j < 4; j++) {
                stack[size] = new Card(i, j);
                size++;
            }
        }
    }

    public Deck(Deck from, int num) {
        int cardsToTake = Math.min(num, from.size); // Determine the amount to take based on the minimum

        this.stack = new Card[cardsToTake];
        this.size = 0;
        int i;

        for (i = 0; i < cardsToTake; i++) {
            stack[size] = from.stack[from.size - 1]; // Draw from the end

            // Update the counts
            this.size++;
            from.size--;
        }
    }

    public Deck(Deck first, Deck second) {
        this.stack = new Card[first.size + second.size];
        this.size = 0;

        while (first.size > 0 || second.size > 0) {
            if (first.size > 0) {
                stack[size] = first.stack[first.size - 1];
                size++;
                first.size--;
            }

            if (second.size > 0) {
                stack[size] = second.stack[second.size - 1];
                size++;
                second.size--;
            }
        }
    }

    public int getNumCards() {
        return size;
    }

    public Card takeOne() {
        if (this.size > 0) {
            Card cardToReturn = stack[size - 1];
            this.size--;
            return cardToReturn;
        }
        return null;
    }

    public String toString() {
        String text = "[";
        int i;

        for (i = 0; i < this.size; i++) {
            text += stack[i];

            if (i < size - 1)
                text += ", ";
        }
        return text + "]";
    }

    public void sort() {
        int i, j;
        Card temp;

        for (i = 0; i < size - 1; i++) {
            for (j = i + 1; j < size; j++) {
                if (stack[i].compareTo(stack[j]) > 0) { // positive
                    temp = stack[i];
                    stack[i] = stack[j];
                    stack[j] = temp;
                }
            }
        }
    }
}
