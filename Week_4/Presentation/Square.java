public class Square extends Shape {
	private Dot upperLeft;
	private double edgeLength;

	public Square(String color, Dot upperLeft, double edgeLength) {
		super(color);
		this.upperLeft = upperLeft;
		this.edgeLength = edgeLength;
	}

	public Dot getUpperLeft() {
		return upperLeft;
	}

	public double getEdgeLength() {
		return edgeLength;
	}

	@Override
	public double getArea() {
		return Math.pow(edgeLength, 2);
	}

	@Override
	public Dot getCenter() {
		return new Dot(upperLeft.getX() + edgeLength / 2, upperLeft.getY() + edgeLength / 2);
	}

	@Override
	public String toString() {
		return String.format("%s edge: %.1f center: %s", super.toString(), edgeLength, getCenter());
	}
}
