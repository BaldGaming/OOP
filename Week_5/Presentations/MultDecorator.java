public class MultDecorator implements Function {
	private Function base;
	private int factor;

	public MultDecorator(Function base, int factor) {
		this.base = base;
		this.factor = factor;
	}
	public void setFactor(int factor) {
		this.factor = factor;
	}
	
	@Override
	public int f(int n) {
		return factor * base.f(n);
	}
}
