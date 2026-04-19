public class ConstantPlayer extends Player {
	private int myConstant;

	public ConstantPlayer(String name, int myConstant) {
		super(name);
		this.myConstant = myConstant;
	}

	@Override
	protected int nextMove(int hisLastMove) {
		return myConstant;
	}
}
