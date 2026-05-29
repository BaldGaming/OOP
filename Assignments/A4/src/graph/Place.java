package graph;

import java.util.Objects;

public class Place {

    private int x, y;

    public Place(int x, int y, int bound) {
        if ((x >= bound || x < 0) || (y >= bound || y < 0)) {
            throw new IllegalArgumentException("x or y aren't within the correct range.");
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Place))
            return false;

        Place other = (Place) obj;

        return this.x == other.x && this.y == other.y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }
}
