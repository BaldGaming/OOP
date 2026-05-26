package circuits;

public class FalseGate extends Gate {
    private static FalseGate instance = new FalseGate();

    private FalseGate() {
        super(null);
    }


    public static Gate instance() {
        return instance;
    }


    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        return false;
    }


    @Override
    public String getName() {
        return "F";   
    }


    @Override
    public Gate simplify() {
        return this;
    }
}
