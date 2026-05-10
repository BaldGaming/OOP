package images;

public class Gradient extends BaseImage {

    private int width, height;
    private RGB start, end;

    public Gradient(int width, int height, RGB start, RGB end) {
        this.width = width;
        this.height = height;
        this.start = start;
        this.end = end;
    }

    public RGB get(int x, int y) {
        double progress = (double) x / width;
        double alpha = 1.0 - progress;

        return RGB.mix(x, y, alpha);
    }
}
