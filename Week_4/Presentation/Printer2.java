public class Printer2 {
	private int[][] a;

	public Printer2(int[][] a) {
		this.a = a;
	}

	public void doAll() {
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < a.length; j++)
				System.out.println(Math.sqrt(a[i][j]));
	}
}