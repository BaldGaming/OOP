public class Bicycle {
    private int speed;
        
    public void applyBrake(int decrement) {
        speed -= decrement;
    }   
    public void speedUp(int increment) {
        speed += increment;
    }
    public int getSpeed() {
    	return speed;
    }
}