public class Building {
    Building() { System.out.print("b "); }
    Building(String name) {
		this(); 
		System.out.print("bn " + name);
    }
    public static void main(String[] args) {
    	new House("x ");
    }
}
