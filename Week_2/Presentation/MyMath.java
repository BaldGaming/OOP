package Week_2.Presentation;

public class MyMath {
	public static int pow(int x, int y) {
		int res = 1;
		for (int i=0; i<y; i++)
			res *= x;
		return res;
	}
}
