package Week_2.Presentation;

public class MainForPoint {
	public static void main(String[] args) {
		Point x = new Point(2.0, 1.1);
		Point y = new Point(7, 1.2);
		
		System.out.format("%s ---- %s = %f%n",
				x, y, Point.dist(x, y));
		// <2.00,1.10> ---- <7.00,1.20> = 7.657676
		
		System.out.println(x.distFrom(y));
	}
}
