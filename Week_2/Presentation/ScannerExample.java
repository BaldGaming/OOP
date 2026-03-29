package Week_2.Presentation;
import java.util.Scanner;

public class ScannerExample {
	public static void main(String[] args) {
		
		Scanner scanner1 = new Scanner(
				" one two   three  four\n five   6 ");
		while (scanner1.hasNext())
			System.out.print(scanner1.next() + ",");
		System.out.println();
		// one,two,three,four,five,6,
		
		Scanner scanner2 = new Scanner(
				"1  20   300  abc efg 400");
		int sum = 0;
		while (scanner2.hasNextInt())
			sum += scanner2.nextInt();
		System.out.println(sum);
		// 321
		
		Scanner scanner3 = new Scanner(System.in);
		double sum2 = 0;
		while (scanner3.hasNextDouble())
			sum2 += scanner3.nextDouble();
		System.out.println(sum2);
	}
}
