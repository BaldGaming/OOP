public class HashTable {
	protected String[] table;

	public HashTable(int size) {
		table = new String[size];
	}

	protected int indexOf(String s) {
		int i = Math.abs(s.hashCode()) % table.length;
		while (table[i] != null) {
			if (s.equals(table[i]))
				return i;
			i++;
			if (i == table.length)
				i = 0;
		}
		return i;
	}

	public void add(String s) {
		table[indexOf(s)] = s;
	}

	public boolean contains(String s) {
		return table[indexOf(s)] != null;
	}
}
