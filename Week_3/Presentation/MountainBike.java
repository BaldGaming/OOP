public class MountainBike extends Bicycle {
	private double seatHeight;

	public void setSeatHeight(double seatHeight) {
		this.seatHeight = seatHeight;
	}
	public String toString() {
		return String.format("Speed = %d, seat = %.2f",
				getSpeed(), seatHeight);
	}
}
