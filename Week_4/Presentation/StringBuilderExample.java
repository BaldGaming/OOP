public class StringBuilderExample {
	public static void main(String[] args) {
		StringBuilder b = new StringBuilder();

		b.append("One ");
		b.append(2);
		b.append(" four");
		System.out.println(b.toString()); // One 2 four
		
		b.insert(6, "three "); // Inserts "three " at index 6
		System.out.println(b.toString()); // One 2 three four
	}
}
