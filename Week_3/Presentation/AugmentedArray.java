public class AugmentedArray extends SortedArray2 {
	public AugmentedArray(int[] a) {
		super(a);
	}
	public void change(int i, int delta) {
		set(i, get(i) + delta);
		if (delta < 0) 
			for (; i > 0 && get(i-1) > get(i); i--)
				swap(i, i-1);
		else
			for (; i < len()-1 && get(i) > get(i+1); i++)
				swap(i, i+1);
	}
}
