public class Game {
	private Player p1, p2;

	public Game(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public void playRounds(int rounds) {
		int last1 = 0, last2 = 0;
		for (int i = 0; i < rounds; i++) {
			int m1 = p1.play(last2);
			int m2 = p2.play(last1);

			if (m1 > m2)
				System.out.format("%s won! (%d > %d)%n",
						p1, m1, m2);
			else if (m2 > m1)
				System.out.format("%s won! (%d < %d)%n",
						p2, m1, m2);
			else
				System.out.format("Tie. (%d = %d)%n",
						m1, m2);
			last1 = m1;
			last2 = m2;
		}
		System.out.format("total costs are %s=%d, %s=%d%n",
				p1, p1.getCost(), p2, p2.getCost());
	}
}
