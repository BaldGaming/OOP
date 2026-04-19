public abstract class Player {
	private int totalCost = 0;
	private String name;

	public Player(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public final int getCost() {
		return totalCost;
	}

	public final int play(int hisLastMove) {
		int p = nextMove(hisLastMove);
		totalCost += p;
		return p;
	}

	protected abstract int nextMove(int hisLastMove);
}
