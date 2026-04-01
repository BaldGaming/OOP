package cards;

public class Card {
    private int num;
    private int suit;
    private char suitLetter = ' ';

    public Card(int num, int suit) {
        this.num = num;
        this.suit = suit;
    }

    public int getNum() {
        return num;
    }

    public int getSuit() {
        return suit;
    }

    public String toString() {
        switch (this.suit) {
            case 0: // Clubs
                suitLetter = 'C';
                break;
            case 1: // Diamonds
                suitLetter = 'D';
                break;
            case 2: // Hearts
                suitLetter = 'H';
                break;
            case 3: // Spades
                suitLetter = 'S';
                break;
        }
        return num + "" + suitLetter;
    }

    public int compareTo(Card other) {
        if (num != other.num) // Moves to the suit check if false
            return num - other.num; // Returns a positive / negative number

        return suit - other.suit;
    }
}
