package Week_2.Presentation;

public class Student {
	private static long lastNum = 0;
	private String name;
	private long num;
	
	public Student(String name) {
		this.name = name;
		num = lastNum++;
	}
	public String toString() {
		return String.format("%s(%d)", name, num);
	}
	
	public static void main(String[] args) {
		Student s1 = new Student("Sun");
		Student s2 = new Student("Jupiter");
		Student s3 = new Student("Mars");
		System.out.format("%s %s %s%n",s1, s2, s3);
		// Sun(0) Jupiter(1) Mars(2)
	}
}
