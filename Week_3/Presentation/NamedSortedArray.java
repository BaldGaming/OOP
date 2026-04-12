import java.util.Arrays;

public class NamedSortedArray extends SortedArray {
	private String[] names;

	public NamedSortedArray(int[] a, String[] names) {
		super(a);
		this.names = new String[names.length];
		for (int i = 0; i < names.length; i++)
			this.names[i] = names[i];
	}

	@Override
	protected void swap(int i, int j) {
		super.swap(i, j);
		String temp = names[i];
		names[i] = names[j];
		names[j] = temp;
	}

	@Override
	public String toString() {
		return super.toString() + " : " + 
				Arrays.toString(names);
	}
}
