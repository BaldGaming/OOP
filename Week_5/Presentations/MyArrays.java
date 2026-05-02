public class MyArrays {
	public static void sort(Comparable[] a) {
		for (int i=0; i<a.length - 1; i++)
			for (int j=i+1; j<a.length; j++)
				if (a[i].compareTo(a[j]) > 0) {
					Comparable temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
	}
}
