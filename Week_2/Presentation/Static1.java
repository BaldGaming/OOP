package Week_2.Presentation;

public class Static1 {
	private static int x = 0;
	
	public void inc() { x++; }
	public int getx() { return x; }
	
	public static void main(String[] args) {
		Static1 s1 = new Static1();
		Static1 s2 = new Static1();
		s1.inc();
		s2.inc();
		System.out.println(s1.getx());
		System.out.println(s2.getx());
	}
}
