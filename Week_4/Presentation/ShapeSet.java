public class ShapeSet {
	private Shape[] shapes = new Shape[10];
	private int count = 0;

	public void add(Shape s) {
		shapes[count++] = s;
		// shapes[count] = s;
		// count++;
	}

	public Dot getCenter() {
		double sumX = 0.0, sumY = 0.0;

		for (int i = 0; i < count; i++) {
			sumX += shapes[i].getCenter().getX();
			sumY += shapes[i].getCenter().getY();
		}
		return new Dot(sumX / count, sumY / count);
	}

	public double avgRadius() {
		double sum = 0.0, count = 0;

		for (int i = 0; i < count; i++)
			if (shapes[i] instanceof Circle) { // This is to make sure it's a circle
				Circle c = (Circle) shapes[i]; // We then cast shape[i] into a circle so we can use the getRadius method
				sum += c.getRadius();
				count++;
			}
		return sum / count;
	}
}
