public class MainForAugmentedArray {
	public static void main(String[] args) {
		int[] a = {3, 1, -2, 10, 15, 5};
		AugmentedArray aa = new AugmentedArray(a);
		aa.sort();
		System.out.println(aa);
		// [-2, 1, 3, 5, 10, 15]
		aa.change(2, -1000);
		System.out.println(aa);
		// [-997, -2, 1, 5, 10, 15]
		aa.change(2, 1000);
		System.out.println(aa);		
		// [-997, -2, 5, 10, 15, 1001]
	}
}
