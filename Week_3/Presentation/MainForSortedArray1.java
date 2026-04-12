public class MainForSortedArray1 {
	public static void main(String[] args) {
		int b[] = {4, 1, 15, 2, 9, -4, 5};
		SortedArray1 sa = new SortedArray1(b);
		sa.sort();
		System.out.println(sa);
		// [-4, 1, 2, 4, 5, 9, 15]
	}
}
