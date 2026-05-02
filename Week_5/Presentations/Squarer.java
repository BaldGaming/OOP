public class Squarer implements Function {
	@Override
	public int f(int x) {
		return x * x;
	}
	
	public static void main(String[] args) {
		System.out.println(Sumer.sum(100, new Squarer()));
	}
}
