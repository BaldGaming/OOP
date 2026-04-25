package game;

import java.util.Scanner;

public class Game extends Board {

    protected Player[] players;
    protected Scanner s;

    public Game(int n, int m, Player p1, Player p2) {
        super(n, m);

        this.players = new Player[] { p1, p2 };

        this.s = new Scanner(System.in);
    }

    protected boolean doesWin(int i, int j) {
        return i == 0 && j == 0;
    }

    protected boolean onePlay(Player p) {
        int x, y;
        boolean success = false;

        while (!success) {
            // Prompt the player
            System.out.println(p.getName() + " (" + p.getMark() + "), please enter x and y: ");
            x = s.nextInt();
            y = s.nextInt();

            // Try to place the piece
            if (set(x, y, p)) {
                success = true;
                // Print the board after a successful move
                System.out.print(this.toString());

                // Check if this move won the game
                if (doesWin(x, y)) {
                    return true;
                }
            } else {
                // Handle occupied spots
                System.out.println("There is a piece there already...");
            }
        }
        return false;
    }

    public Player play() {
        int turn = 0; // Starts with the first player (index 0)

        while (!isFull()) {
            Player currentPlayer = players[turn];

            // Perform one turn
            if (onePlay(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " (" + currentPlayer.getMark() + ") Won!");
                return currentPlayer;
            }

            // Switch to the next player: 0 becomes 1, 1 becomes 0
            turn = 1 - turn;
        }

        // If the board is full and no one won, it's a draw
        return null;
    }
}
