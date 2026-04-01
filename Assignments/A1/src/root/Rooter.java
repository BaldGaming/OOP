package root;

public class Rooter {
    private double precision;

    // Constructor
    public Rooter(double precision) {
        this.precision = precision;
    }

    // Method like the constructor
    public void setPrecision(double precision) {
        this.precision = precision;
    }

    public double sqrt(double x) {
        double one = x / 2, two;

        while (one > 0) {
            two = x / one;

            if (one == two)
                return one;

            if (Math.abs(one - two) < precision)
                return one;

            one = (one + two) / 2;
        }

        return one;
    }
}
