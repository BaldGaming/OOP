package circuits;

import java.util.ArrayList;
import java.util.List;

public class OrGate extends Gate {

    public OrGate(Gate[] inGates) {
        super(inGates);
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        
        int i;
        boolean res = false;

        for (i = 0; i < inValues.length; i++)
                res = res || inValues[i];

        return res;
    }

    @Override
    public String getName() {
        return "OR";
    }

    @Override
    public Gate simplify() {
        
        List<Gate> simplifiedChildren = new ArrayList<>();

        for (Gate g : inGates) {
            Gate sg = g.simplify();

            if (sg instanceof TrueGate)
                return TrueGate.instance();

            if (!(sg instanceof FalseGate))
                    simplifiedChildren.add(sg);
        }

        if (simplifiedChildren.isEmpty())
            return FalseGate.instance();

        if (simplifiedChildren.size() == 1) 
            return simplifiedChildren.get(0);

        return new OrGate(simplifiedChildren.toArray(new Gate[0]));
    }
}
