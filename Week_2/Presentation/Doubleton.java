package Week_2.Presentation;

public class Doubleton {
	private static Doubleton first = null, second = null;
	private static boolean even = true;
	
	private Doubleton() {}
	
	public static Doubleton GetInstance() {
		even = !even;
		if (even) {
			if (first == null)
				first = new Doubleton();
			return first;
		} else {
			if (second == null)
				second = new Doubleton();
			return second;
		}
	}
}
