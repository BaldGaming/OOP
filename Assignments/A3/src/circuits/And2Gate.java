package circuits;

public class And2Gate extends AndGate {

    private Gate g1, g2;
    
    public And2Gate(Gate g1, Gate g2) {
        super(new Gate[] {g1, g2});
    }
}