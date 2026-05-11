package circuits;

public class NotGate extends Gate{

    private Gate[] in;

    public NotGate(Gate in) {
        super(new Gate[]{in});
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        return !inValues[0];
    }

    @Override
    public String getName() {
        return "NOT";
    }

    @Override
    public Gate simplify() {

        Gate simplifiedIn = inGates[0].simplify();

        if (simplifiedIn instanceof TrueGate)
            return FalseGate.instance();

        if (simplifiedIn instanceof FalseGate)
            return TrueGate.instance();

        if (simplifiedIn instanceof NotGate)
            return ((NotGate) simplifiedIn).inGates[0];

        return new NotGate(simplifiedIn);
    }
}
