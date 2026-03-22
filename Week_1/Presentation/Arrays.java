package Week_1.Presentation;
public class Arrays {

	public static void main(String[] args) {
		double[] a = new double[4]; // array (double) the size of 4 filled with 0
		int x = 7;
		double[] a2 = new double[x]; // array (double) the size of 7 filled with 0
		char[] a3 = {'a', 'c', 'l', ' '}; // array (char) the size of 4 with "acl "
		
		a[0] = 1.3;
		a[1] = 3.2;
		a[3] = -3.1;
		for (int i=0; i<a.length; i++) // regular for example
			System.out.print(a[i] + " ");
		System.out.println();
		
		for (double y : a) // for each example
			System.out.print(y + " ");
		System.out.println();
				
		System.out.println(a); // Gives something like: [D@15db9742 == [ - array, D - type, numbers - place in memory
		double[] b = a;
		b[1] = 0;
		System.out.println(a[1]); // Will print 0.0 because b's array pointer refers to the same memory location of a's.
		
		int[][] c = new int[3][]; // Matrix the size of 3
		for (int i=0; i<c.length; i++) {
			c[i] = new int[2]; // Refers each cell to an array the size of 2
		}

		boolean[][] d = new boolean[4][3]; // matrix the size of 4x3 filled with false
		int[][] e = {{1,2,3},{4,5,6},{7,8,9}}; // matrix the size of 3x3 filled with 1 to 9
		
		d[0][0] = true; // sets the first cell to true
		d[0][1] = false; // sets the second cell to false
	}
}
