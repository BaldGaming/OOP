import java.util.Arrays;

public class MainForSorting {
	public static void main(String[] args) {
		Complex c1 = new Complex(1, 1);
		Complex c2 = new Complex(2, 0);
		Complex c3 = new Complex(0, 0);
		Complex[] a = {c1, c2, c3};
		MyArrays.sort(a);
		System.out.println(Arrays.toString(a));
		// [0.0 + 0.0i, 1.0 + 1.0i, 2.0 + 0.0i]
	}
}
