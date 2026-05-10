package images;

public class Circle extends BaseImage{
    
    private int width, height, centerX, centerY, radius, size;
    private RGB center, outside;

    public Circle(int width, int height, int centerX, int centerY, int radius, RGB center, RGB outside) {
        this.width = width;
        this.height = height;
        this.centerX = centerX;
        this.centerY = centerY;
        this.center = center;
        this.outside = outside;
    }

    public Circle(int size, int radius, RGB center, RGB outside) {
        this.radius = radius;
        this.center = center;
        this.outside = outside;
        height = width = size;
    }

    public RGB get(int x, int y) {
        
    }
}
