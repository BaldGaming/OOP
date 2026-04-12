import java.util.Arrays;

public class SortedArray1 {
	private int[] a;

	public SortedArray1(int b[]) {
		a = new int[b.length];
		for (int i = 0; i < b.length; i++)
			a[i] = b[i];
	}

	public void sort() {
		for (int i = 1; i < a.length; i++)
			for (int j = i; j>0 && a[j]<a[j-1]; j--) {
				int temp = a[j];
				a[j] = a[j-1];
				a[j-1] = temp;
			}
	}

	@Override
	public String toString() {
		return Arrays.toString(a);
	}
}
