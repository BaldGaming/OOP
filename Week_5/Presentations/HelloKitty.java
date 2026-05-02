public class HelloKitty implements HelloInterface {
	private String name;

	public HelloKitty(String name) {
		this.name = name;
	}
	@Override
	public void hello() {
		System.out.println("Hello Kitty " + name + "!");
	}
	@Override
	public void goodbye() {
		System.out.println("Miao " + name);
	}
}
