package Week_5.Lab;

public abstract class Tree {

    private int buyingCost;

    public Tree(int buyingCost) {
        this.buyingCost = buyingCost;
    }

    public abstract String getName();

    protected abstract int costAtYear(int year);

    public int totalCost(int years) {
        int total = buyingCost;
        
        for (int year = 0; year < years; years++)
            total += costAtYear(year);

        return total;
    }
}
