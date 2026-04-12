public class MainForNamedSortedArray {
	public static void main(String[] args) {
		int[] a = { 1, 3, 2, 0, 40 };
		String[] names = { "one", "three", "two", 
				"zero", "forty" };
		NamedSortedArray nsa = 
				new NamedSortedArray(a, names);
		nsa.sort();
		System.out.println(nsa);
		// [0, 1, 2, 3, 40] : [zero, one, two, three, forty]
	}
}
