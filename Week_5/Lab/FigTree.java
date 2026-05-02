package Week_5.Lab;

public class FigTree extends Tree {

    public FigTree() {
        super(100);
    }

    @Override
    protected int costAtYear(int year) {
        return 10;
    }

    @Override
    public String getName() {
        return "Fig";
    }

}
