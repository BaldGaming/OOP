package Week_4.Lab;

public class ParentsRoom extends room{
    private Bathroom bath;

    public Parentsroom(int length, int width, int blength, int bwidth, int bheight, int costPerMeter) {
        super(length, width, costPerMeter);
        this.height = height;
        bath = new Bathroom(blenght, bwidth, bheight, costPerMeter);
    }

    @Override
    
}