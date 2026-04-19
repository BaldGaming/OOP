public abstract class Shape2 {
	private String color;
	
	public Shape2(String color) { this.color = color; }
	public String getColor() { return color;}
	public abstract double getArea();
	public abstract Dot getCenter();
	@Override
	public String toString() {
		return color + " shape";
	}
}
