package mines;

import java.util.Random;

public class Mines {

    private int height, width, numMines;
    private Cell[][] board;

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

    public void open(int i, int j) {
        
    }

    public void toggleFlag(int x, int y) {

    }
}