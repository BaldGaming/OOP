public class MainForPositiveDecorator {
	public static void main(String[] args) {
		Function func = new PositiveDecorator(
				new DoubleFunction());
		System.out.println(func.f(-4)); // 0
		System.out.println(func.f(4)); // 8
	}
}
