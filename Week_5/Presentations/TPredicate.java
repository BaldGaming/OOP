public class TPredicate implements Predicate {
	@Override
	public boolean f(String x) {
		return x.charAt(0) == 't' || x.charAt(0) == 'T';
	}
}
