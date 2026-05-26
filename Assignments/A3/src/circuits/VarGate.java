package circuits;

public class VarGate extends Gate {

    private String name;
    private boolean value, isSet = false;

    public VarGate(String name){
        super(null);
        this.name = name;
    }

    public void setVal(boolean value) {
        this.value = value;
        this.isSet = true;
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        if (!isSet) 
            throw new CircuitException("idk");

        return value;
    }

    @Override
    public String getName() {
        return "V" + name;
    }

    @Override
    public Gate simplify() {
        if (isSet) {
            return value ? TrueGate.instance() : FalseGate.instance();
        }
        return this;
    }

}
