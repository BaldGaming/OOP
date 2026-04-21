package Week_4.Lab;

public class Bathroom extends Room{

    private int height;

    public Bathroom(int length, int width, int costPerMeter, int height) {
        super(length, width, costPerMeter);
        this.height = height;
    }

    @Override
    public int area() {
        return super.area() + perimeter() * height;
    }
}