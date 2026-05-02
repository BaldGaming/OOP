public class MainForDecorators {
	private static void showVals(Function func, int n) {
		for (int i = 0; i <= n; i++)
			System.out.print(func.f(i) + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		Function func = new DoubleFunction();
		Function func2 = new SumDecorator(func);
		Function func3 = new SumDecorator(func2);
		showVals(func, 4);
		// 0 2 4 6 8
		showVals(func2, 4);
		// 0 2 6 12 20
		showVals(func3, 4);
		// 0 2 8 20 40
	}
}
