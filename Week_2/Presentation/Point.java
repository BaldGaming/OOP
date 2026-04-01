package Week_2.Presentation;

public class Point {
	private double x, y;
	
	public Point(double x, double y) {
		this.x = x; 
		this.y = y;
	}
	public String toString() {
		return String.format("<%.2f,%.2f>", x, y);
	}
	
	public static double dist(Point a, Point b) {
		return Math.sqrt(Math.pow(a.x - b.x, 2) 
				+ Math.pow(a.y - b.y, 2));
	}
	
	public double distFrom(Point other) {
		return Math.sqrt(Math.pow(x - other.x, 2) 
				+ Math.pow(y - other.y, 2));
	}
	
	public double distFrom2(Point other) {
		return dist(this, other);
	}
}
