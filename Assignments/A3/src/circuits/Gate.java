package circuits;

public abstract class Gate {

    protected Gate[] inGates;
    
    public Gate(Gate[] inGates) {
        this.inGates = inGates;
    }

    public boolean calc() throws CircuitException {
        if (inGates == null)
            return func(new boolean[0]);

        boolean[] inValues = new boolean[inGates.length];
        int i;

        for (i = 0; i < inGates.length; i++)
            inValues[i] = inGates[i].calc();

        return func(inValues);
    }

    protected abstract boolean func(boolean[] inValues) throws CircuitException;

    public abstract String getName();

    public abstract Gate simplify();

    public String toString() {
        if (inGates == null || inGates.length == 0) {
            return getName();
        }

        int i;

        StringBuilder sb = new StringBuilder(getName());
        sb.append("[");

        for (i = 0; i < inGates.length; i++) {
            sb.append(inGates[i].toString());

            if (i < inGates.length - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
