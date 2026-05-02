package Week_5.Lab;

public class Forest {

    private Tree[] trees;

    public Forest(Tree[] trees) {
        this.trees = trees;
    }

    public int totalCost(int years) {
        int total = 0;

        for (Tree tree : trees)
            total += tree.totalCost(years);

        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Tree tree : trees) {
            sb.append(tree.getName());
            sb.append(" ");
        }

        return sb.toString();
    }
}
