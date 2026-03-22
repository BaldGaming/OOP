package Week_1.Presentation;
public class Class2 {
	public int x, y;
	
	/* automatically creates a constructor for me

		public Class2() {
		x=0;
		y=0;

		}

	*/

	public int sum() {
		return x + y;
	}

	public void add(int d) {
		x += d; 
		y += d;
	}
}