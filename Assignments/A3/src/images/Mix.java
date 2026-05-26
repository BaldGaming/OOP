package images;

public class Mix extends BinaryImageDecorator {
    private double alpha;

    public Mix(Image base1, Image base2, double alpha) {
        super(base1, base2);
        this.alpha = alpha;
    }

    @Override
    public RGB get(int x, int y) {
        boolean in1 = isInside(base1, x, y);
        boolean in2 = isInside(base2, x, y);

        if (in1 && in2) {
            return RGB.mix(base1.get(x, y), base2.get(x, y), alpha);
        } else if (in1) {
            return base1.get(x, y);
        } else if (in2) {
            return base2.get(x, y);
        } else {
            return RGB.BLACK;
        }
    }
}