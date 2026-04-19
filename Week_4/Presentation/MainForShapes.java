public class MainForShapes {
	public static void main(String[] args) {
		Shape s1 = new Circle("red", new Dot(3, 3), 4); // These are polymorphism
		Shape s2 = new Square("blue", new Dot(1, 1), 5);

		System.out.format("%s, area = %.2f%n", s1,
				s1.getArea());
		// red Circle(<3.0, 3.0>, 4.0), area = 50.27
		System.out.format("%s, area = %.2f%n", s2,
				s2.getArea());
		// blue Square(<1.0, 1.0>, 5.0), area = 25.00
	}
}
