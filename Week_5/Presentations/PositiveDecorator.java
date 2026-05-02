public class PositiveDecorator implements Function {
	private Function base;

	public PositiveDecorator(Function base) {
		this.base = base;
	}
	@Override
	public int f(int n) {
		return base.f(n) > 0 ? base.f(n) : 0;
	}
}
