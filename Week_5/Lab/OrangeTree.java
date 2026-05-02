package Week_5.Lab;

public class OrangeTree extends Tree {

    public OrangeTree() {
        super(150);
    }

    @Override
    protected int costAtYear(int year) {
        if (year < 3)
            return 100;

        if (year > 6)
            return -100;

        return 0;
    }

    @Override
    public String getName() {
        return "Orange";
    }

}
