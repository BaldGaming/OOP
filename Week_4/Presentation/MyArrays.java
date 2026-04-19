public class MyArrays {
	public static String toString(Object[] a) {
		String res = "[";
		for (int i = 0; i < a.length; i++) {
			res += a[i].toString();
			if (i == a.length - 1)
				res += "]";
			else
				res += ", ";
		}
		return res;
	}
}
