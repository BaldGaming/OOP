public class House extends Building {
	House() { System.out.print("h "); }
	House(String name) {
		this(); 
	 	System.out.print("hn " + name);
	}
}