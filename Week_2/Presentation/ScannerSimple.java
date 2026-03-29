package Week_2.Presentation;
import java.util.Scanner;

public class ScannerSimple {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int i = readInt(s, "Enter first number:");
		int j = readInt(s, "Enter Second number:");
		System.out.println("Sum = " + (i+j));
	}

	private static int readInt(Scanner s, String msg) {
		System.out.print(msg);
		while (!s.hasNextInt()) {
			s.next();
			System.out.print("Not an int, try again:");
		}
		return s.nextInt();
	}
}
