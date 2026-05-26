package images;

public class Filter extends ImageDecorator {

    private RGB filter;

    public Filter(Image base, RGB filter) {
        super(base);
        this.filter = filter;
    }

    @Override
    public RGB get(int x, int y) {
        RGB originalColor = base.get(x, y);
        return originalColor.filter(this.filter);
    }
}