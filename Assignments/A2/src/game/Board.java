package game;

public class Board {

    protected Player[][] board;
    protected int n, m;

    public Board(int n, int m) {
        this.n = n;
        this.m = m;
        board = new Player[n][m]; // Initialize a matrix with n rows and m columns
    }

    protected boolean set(int i, int j, Player p) {
        // If the spot is empty, take it and return true
        if (isEmpty(i, j)) {
            board[i][j] = p;
            return true;
        }

        // If someone is already there, return false
        return false;
    }

    public boolean isEmpty(int i, int j) {
        return board[i][j] == null;
    }

    public Player get(int i, int j) {
        return board[i][j];
    }

    public boolean isFull() {
        int i, j;

        // Check every slot. If even one is null, the board isn't full
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (board[i][j] == null)
                    return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        int i, j;
        String result = "";

        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (board[i][j] == null)
                    result += ".";
                else
                    result += board[i][j].getMark();
            }
            result += "\n";
        }
        return result;
    }

    private int rayLength(int r, int c, int dr, int dc) {
        Player p = board[r][c]; // We assume the spot (r,c) is not null
        int count = 0;
        int currR = r + dr;
        int currC = c + dc;

        // Keep walking in the direction (dr, dc) as long as we are on the board and the
        // spot belongs to the same player
        while (currR >= 0 && currR < n && currC >= 0 && currC < m && board[currR][currC] == p) {
            count++;
            currR += dr;
            currC += dc;
        }
        return count;
    }

    protected int maxLineContaining(int i, int j) {
        // 1. Define the four axes we need to check
        // {dr, dc} -> Horizontal, Vertical, Diagonal 1, Diagonal 2
        int[][] axes = { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, -1 } };

        int max = 0;

        for (int[] axis : axes) {
            int dr = axis[0];
            int dc = axis[1];

            // Line length = 1 (the current piece) + ray one way + ray the opposite way
            int currentLine = 1 + rayLength(i, j, dr, dc) + rayLength(i, j, -dr, -dc);

            if (currentLine > max)
                max = currentLine;
        }

        return max;
    }
}
