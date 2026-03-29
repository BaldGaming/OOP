package Week_2.Presentation;

public class Formater {
	public static void main(String[] args) {
		double r2 = Math.sqrt(2);
		System.out.format(
				"The root of %d is %f.%n", 2, r2);
		// The square root of 2 is 1.414214.

		System.out.format("Pi = %10.2f; %n", Math.PI);
		// Pi =       3.14; 

		String s = String.format("<%d, %d>", 3, 2);
		System.out.println(s);
		// <3, 2>
	}
}
