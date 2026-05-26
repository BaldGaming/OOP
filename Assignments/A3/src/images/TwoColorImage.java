package images;

public class TwoColorImage extends BaseImage {
    private int width;
    private int height;
    private RGB zero;
    private RGB one;
    private TwoDFunc func;

    public TwoColorImage(int width, int height, RGB zero, RGB one, TwoDFunc func) {
        this.width = width;
        this.height = height;
        this.zero = zero;
        this.one = one;
        this.func = func;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public RGB get(int x, int y) {
        double normalizedX = (double) x / width;
        double normalizedY = (double) y / height;

        double alpha = func.f(normalizedX, normalizedY);

        if (alpha <= 0) {
            return zero;
        } else if (alpha >= 1) {
            return one;
        } else {
            return RGB.mix(one, zero, alpha);
        }
    }
}