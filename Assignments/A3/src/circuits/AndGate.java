package circuits;

import java.util.ArrayList;
import java.util.List;

public class AndGate extends Gate {

    public AndGate(Gate[] inGates) {
        super(inGates);
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {

        int i;
        boolean res = true;

        for (i = 0; i < inValues.length; i++)
            res = res & inValues[i];

        return res;
    }

    @Override
    public String getName() {
        return "AND";
    }

    @Override
    public Gate simplify() {
        List<Gate> simplifiedChildren = new ArrayList<>();

        for (Gate g : inGates) {
            Gate sg = g.simplify();

            if (sg instanceof FalseGate)
                return FalseGate.instance();

            if (!(sg instanceof TrueGate))
                simplifiedChildren.add(sg);
        }

        if (simplifiedChildren.isEmpty())
            return TrueGate.instance();

        if (simplifiedChildren.size() == 1)
            return simplifiedChildren.get(0);

        return new AndGate(simplifiedChildren.toArray(new Gate[0]));
    }

}
