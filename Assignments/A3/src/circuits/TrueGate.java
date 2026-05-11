package circuits;

public class TrueGate extends Gate{
    private static TrueGate instance = new TrueGate();

    private TrueGate() {
        super(null);
    }


    public static Gate instance() {
        return instance;
    }


    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        return true;
    }


    @Override
    public String getName() {
        return "T";   
    }


    @Override
    public Gate simplify() {
        return this;
    }
}
