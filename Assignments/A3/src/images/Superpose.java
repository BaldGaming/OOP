package images;

public class Superpose extends BinaryImageDecorator {

    public Superpose(Image base1, Image base2) {
        super(base1, base2);
    }

    @Override
    public RGB get(int x, int y) {
        boolean in1 = isInside(base1, x, y);
        boolean in2 = isInside(base2, x, y);

        if (in1 && in2) {
            return RGB.superpose(base1.get(x, y), base2.get(x, y));
        } else if (in1) {
            return base1.get(x, y);
        } else if (in2) {
            return base2.get(x, y);
        } else {
            return RGB.BLACK;
        }
    }
}