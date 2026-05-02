public class SumDecorator implements Function {
	
	private Function base;
	
	public SumDecorator(Function base) {
		this.base = base;
	}
	
	@Override
	public int f(int n) {
		int sum = 0;
		if (n>0)
			for (int i = 0; i <= n; i++)
				sum += base.f(i);
		else
			for (int i = 0; i >= n; i--)
				sum += base.f(i);
		return sum;
	}
}
