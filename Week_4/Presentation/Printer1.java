public class Printer1 {
	private int[][] a;

	public Printer1(int[][] a) {
		this.a = a;
	}

	public void doAll() {
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < a.length; j++)
				System.out.println(a[i][j] * 2);
	}
}