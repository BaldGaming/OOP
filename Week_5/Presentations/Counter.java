public class Counter {
	public static int count(String[] arr, Predicate p) {
		int c = 0;
		for (String s : arr) 
			if (p.f(s))
				c++;
		return c;
	}
}
