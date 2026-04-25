package game;

public class FourInARow extends Game {

    public FourInARow(String player1, String player2) {
        super(6, 7, new Player(player1, 'W'), new Player(player2, 'B'));
    }

    @Override
    protected boolean doesWin(int i, int j) {
        return maxLineContaining(i, j) >= 4;
    }

    @Override
    protected boolean onePlay(Player p) {
        int col;
        boolean success = false;

        while (!success) {
            System.out.println(p.getName() + " (" + p.getMark() + "), please enter column: ");
            col = s.nextInt(); // We only ask for the column

            // Check if the column is valid
            if (col < 0 || col >= m) {
                System.out.println("Invalid column. Try again.");
                continue;
            }

            // Find the lowest null row in that column
            int targetRow = -1;
            for (int r = n - 1; r >= 0; r--) {
                if (isEmpty(r, col)) {
                    targetRow = r;
                    break;
                }
            }

            if (targetRow != -1) {
                set(targetRow, col, p); // Place the piece at the bottom-most spot
                success = true;
                System.out.print(this.toString());

                if (doesWin(targetRow, col)) {
                    return true;
                }
            } else {
                // If targetRow stayed -1, it means the column is full
                System.out.println("This column is full. Please choose another.");
            }
        }
        return false;
    }
}