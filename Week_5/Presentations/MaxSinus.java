public class MaxSinus implements DoubleComparator {
	@Override
	public int compare(double x, double y) {
		return Double.compare(Math.sin(x), Math.sin(y));
	}
	public static void main(String[] args) {
		DoubleArray da = new DoubleArray(10);
		for (int i = 0; i < 10; i++)
			da.set(i, i);
		
		System.out.println(da.max(new MaxSinus()));
		// 8.0
	}
}
