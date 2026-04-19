public class MainForGame {
	public static void main(String[] args) {
		Player p1 = new ConstantPlayer("Pinocchio", 10);
		Player p2 = new IncreaserPlayer("Jeppeto");
		Game p = new Game(p1, p2);
		p.playRounds(3);
		
		// Pinocchio won! (10 > 1)
		// Jeppeto won! (10 < 11)
		// Jeppeto won! (10 < 11)
		// total costs are Pinocchio=30, Jeppeto=23
	}
}
