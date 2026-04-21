package game;

public class Board extends Player{

    protected Player[][] board;
    protected int n, m;

    public Board(int n, int m) {
        super(getName(), getMark());
        Board p = new Board(n, m);
        this.n = n;
        this.m = m;
    }  // ?????

    protected boolean set(int i, int j, Player p) {
        if (p[i][j] == 0)
    } // ????

    public boolean isEmpty(int i, int j) {
        return board[i][j] == null;
    }

    public Player get(int i, int j) {
        return board[i][j];
    }

    public boolean isFull() {
        int i = n, j = m;

        for (i; )
    }
}
