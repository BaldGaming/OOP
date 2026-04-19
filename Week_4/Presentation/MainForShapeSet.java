public class MainForShapeSet {
	public static void main(String[] args) {
		ShapeSet s = new ShapeSet();
		s.add(new Square("red", new Dot(0, 0), 1));
		s.add(new Circle("blue", new Dot(1, 1), 1));
		System.out.println(s.getCenter());
		// <0.8, 0.8>
		// (should be <0.75, 0.75> but it is rounded)
	}
}
