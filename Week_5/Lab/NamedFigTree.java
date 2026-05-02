package Week_5.Lab;

public class NamedFigTree extends FigTree{
    private String name;

    public NamedFigTree(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return String.format("%s-%s", name, super.getName());
    }
}
