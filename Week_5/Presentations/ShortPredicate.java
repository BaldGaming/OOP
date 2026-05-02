public class ShortPredicate implements Predicate {
	@Override
	public boolean f(String x) {
		return x.length() <= 3;
	}
}
