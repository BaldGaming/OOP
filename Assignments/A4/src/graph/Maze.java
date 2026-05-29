package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Maze implements GraphInterface<Place> {
    private int size, startx, starty, endx, endy;
    private boolean[][] maze;

    public Maze(int size, int startx, int starty, int endx, int endy) {
        if (size <= 0 || 
            (startx >= size || startx < 0) ||
            (starty >= size || starty < 0) ||
            (endx >= size || endx < 0) ||
            (endy >= size || endy < 0)) {
            throw new IllegalArgumentException("Invalid maze parameters or out-of-range coordinates.");
        }
        this.size = size;
        this.startx = startx;
        this.starty = starty;
        this.endx = endx;
        this.endy = endy;
        this.maze = new boolean[size][size];
    }

    public boolean addWall(int x, int y) {
        if ((x >= size || x < 0) || (y >= size || y < 0)) {
            throw new IllegalArgumentException("Wall is outside of maze");
        }
        if (maze[x][y]) {
            return false;
        }
        if ((x == startx && y == starty) || (x == endx && y == endy)) {
            return false;
        }
        maze[x][y] = true;
        return true;
    }

    @Override
    public Collection<Place> neighbours(Place p) {
        List<Place> validNeighbours = new ArrayList<>();
        int x = p.getX();
        int y = p.getY();
        int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        for (int[] dir : directions) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (nextX >= 0 && nextX < size && nextY >= 0 && nextY < size && !maze[nextX][nextY]) {
                validNeighbours.add(new Place(nextX, nextY, size));
            }
        }
        return validNeighbours;
    }

    public boolean isSolvable() {
        Graph<Place> mazeGraph = new Graph<>();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (!maze[x][y]) {
                    try {
                        mazeGraph.addVertex(new Place(x, y, size));
                    } catch (GraphException e) {
                    }
                }
            }
        }

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (!maze[x][y]) {
                    Place currentPlace = new Place(x, y, size);
                    Collection<Place> adjacentPoints = neighbours(currentPlace);
                    for (Place neighbor : adjacentPoints) {
                        try {
                            if (!mazeGraph.hasEdge(currentPlace, neighbor)) {
                                mazeGraph.addEdge(currentPlace, neighbor);
                            }
                        } catch (GraphException e) {
                        }
                    }
                }
            }
        }

        try {
            Place startNode = new Place(startx, starty, size);
            Place endNode = new Place(endx, endy, size);
            return mazeGraph.connected(startNode, endNode);
        } catch (GraphException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (x == startx && y == starty) {
                    sb.append("S");
                } else if (x == endx && y == endy) {
                    sb.append("E");
                } else if (maze[x][y]) {
                    sb.append("@");
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}