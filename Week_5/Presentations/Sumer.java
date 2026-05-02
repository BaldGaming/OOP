public class Sumer {
	public static int sum(int n, Function funcObj) {
		int s = 0;
		for (int i = 0; i <= n; i++) {
			s += funcObj.f(i);
		}
		return s;
	}
}
