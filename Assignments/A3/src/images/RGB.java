package images;

public class RGB {

    private double red, green, blue;
    
    public static final RGB BLACK = new RGB(0);
    public static final RGB WHITE = new RGB(1);
    public static final RGB RED = new RGB(1, 0, 0);
    public static final RGB GREEN = new RGB(0, 1, 0);
    public static final RGB BLUE = new RGB(0, 0, 1);

    public RGB(double red, double green, double blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public RGB(double grey) {
        red = green = blue = grey;
    }

    public double getRed() {
        return red;
    }

    public double getGreen() {
        return green;
    }

    public double getBlue() {
        return blue;
    }

    public RGB invert() {
        // double newRed = red;
        // double newGreen = green;
        // double newBlue = blue;

        // RGB color = new RGB(newRed, newGreen, newBlue);

        // color.red = 1 - this.red;
        // color.green = 1 - this.green;
        // color.blue = 1 - this.blue;

        // return color;

        return new RGB(1 - red, 1 - green, 1 - blue);
    }

    public RGB filter(RGB filter) {
        return new RGB(red * filter.red, green * filter.green, blue * filter.blue);
    }

    public static RGB superpose(RGB rgb1, RGB rgb2) {
        return new RGB(Math.min(rgb1.red + rgb2.red, 1), Math.min(rgb1.green + rgb2.green, 1),
                Math.min(rgb1.blue + rgb2.blue, 1));
    }

    public static RGB mix(RGB rgb1, RGB rgb2, double alpha) {
        return new RGB(alpha * rgb1.red + (1 - alpha) * rgb2.red,
                alpha * rgb1.green + (1 - alpha) * rgb2.green,
                alpha * rgb1.blue + (1 - alpha) * rgb2.blue);
    }

    @Override
    public String toString() {
        return String.format("<%.4f, %.4f, %.4f>", red, green, blue);
    }
}
