public class MainForCounter {
	public static void main(String[] args) {
		String[] a = { "The", "times", "they", "are",
				"changing" };
		System.out.println(
				Counter.count(a, new ShortPredicate()));
	}
}
