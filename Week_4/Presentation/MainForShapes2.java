public class MainForShapes2 {
	public static void main(String[] args) {
		Shape[] shapes = new Shape[3];
		shapes[0] = new Circle("red", new Dot(3, 3), 4);
		shapes[1] = new Square("blue", new Dot(1, 1), 5);
		// shapes[2] = new Shape("green"); 

		for (Shape s : shapes)
			System.out.format("%s, area = %.2f%n", s, s.getArea());
		// red Circle(<3.0, 3.0>, 4.0), area = 50.27
		// blue Square(<1.0, 1.0>, 5.0), area = 25.00
		// green shape, area = 0.00
	}
}
