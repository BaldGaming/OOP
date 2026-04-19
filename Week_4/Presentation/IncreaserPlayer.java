public class IncreaserPlayer extends Player {
	public IncreaserPlayer(String name) {
		super(name);
	}

	@Override
	protected int nextMove(int hisLastMove) {
		return hisLastMove + 1;
	}
}
