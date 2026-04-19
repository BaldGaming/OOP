public abstract class AbsPrinter {
	private int[][] a; // This makes it so we don't need to declare a private matrix for every file

	public AbsPrinter(int[][] a) { // This makes it so we don't need to declare a this.a for every file, we do super.
		this.a = a;
	}

	public void doAll() {
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < a.length; j++)
				System.out.println(f(a[i][j]));
	}

	protected abstract String f(int x); // The type is protected because the classes that have this function inherent this
}