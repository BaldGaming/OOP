public abstract class Shape {
	private String color;

	public Shape(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public double getArea() {
		return 0.0;
	}

	public Dot getCenter() {
		return null;
	}

	@Override
	public String toString() {
		return String.format("%s color: %s", getClass().getSimpleName(), color);
	}
}
