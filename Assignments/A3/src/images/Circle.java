package images;

public class Circle extends BaseImage {

    private int width, height, centerX, centerY, radius;
    private RGB center, outside;

    public Circle(int width, int height, int centerX, int centerY, int radius, RGB center, RGB outside) {
        this.width = width;
        this.height = height;
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.center = center;
        this.outside = outside;
    }

    public Circle(int size, int radius, RGB center, RGB outside) {
        this.width = size;
        this.height = size;
        this.centerX = size / 2;
        this.centerY = size / 2;
        this.radius = radius;
        this.center = center;
        this.outside = outside;
    }

    public RGB get(int x, int y) {
        double distance = Math.sqrt(Math.pow(x - this.centerX, 2) + Math.pow(y - this.centerY, 2));

        if (distance > this.radius)
            return outside;

        double distanceRatio = distance / this.radius;

        double alpha = 1.0 - distanceRatio;

        return RGB.mix(this.center, this.outside, alpha);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}