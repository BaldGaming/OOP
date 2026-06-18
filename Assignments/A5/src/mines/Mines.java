package mines;

import java.util.Random;

public class Mines {

    private int height, width, numMines;
    private Cell[][] board;
    private boolean showAll = false;

    private class Cell {
        boolean isMine = false;
        boolean isOpen = false;
        boolean hasFlag = false;
    }

    public Mines(int height, int width, int numMines) {
        this.height = height;
        this.width = width;
        this.numMines = 0;
        this.board = new Cell[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = new Cell();
            }
        }

        Random rand = new Random();
        while (this.numMines < numMines) {
            int randomRow = rand.nextInt(height);
            int randomCol = rand.nextInt(width);
            addMine(randomRow, randomCol);
        }
    }

    public boolean addMine(int i, int j) {
        if (!board[i][j].isMine) {

            board[i][j].isMine = true;

            this.numMines += 1;
            return true;
        } else {
            return false;
        }
    }

    // Helper method for the 3x3 check
    private int countMines(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                // Check if the neighbor is inside the board bounds
                if (i >= 0 && i < height && j >= 0 && j < width) {
                    if (board[i][j].isMine) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean open(int i, int j) {
        // Out of bounds check
        if (i < 0 || i >= height || j < 0 || j >= width)
            return false;

        // If it's already open, do nothing and return true
        if (board[i][j].isOpen)
            return true;

        // If it's a mine, don't open it, just return false
        if (board[i][j].isMine)
            return false;

        // It's safe => Open it.
        board[i][j].isOpen = true;

        // If there are 0 mines nearby, open all 8 neighbors
        if (countMines(i, j) == 0)
            for (int r = i - 1; r <= i + 1; r++)
                for (int c = j - 1; c <= j + 1; c++)
                    open(r, c);

        return true;
    }

    public void toggleFlag(int x, int y) {
        if (!board[x][y].isOpen)
            board[x][y].hasFlag = !board[x][y].hasFlag;
    }

    public boolean isDone() {
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                if (!board[i][j].isMine && !board[i][j].isOpen)
                    return false;

        return true;
    }

    public String get(int i, int j) {
        // If the cell is closed
        if (!board[i][j].isOpen && !showAll)
            return board[i][j].hasFlag ? "F" : ".";

        // If the cell is open
        if (board[i][j].isMine)
            return "X";

        // If it's open and safe, check neighbor count
        int neighbors = countMines(i, j);
        return neighbors == 0 ? " " : String.valueOf(neighbors);
    }

    public void setShowAll(boolean showAll) {
        this.showAll = showAll;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                sb.append(get(i, j));

            sb.append("\n");
        }
        
        return sb.toString();
    }
}