import java.util.ArrayList;
import java.util.List;

public class Shop {

    private ArrayList<Instrument> list = new ArrayList<Instrument>();

    public void add(Instrument i) {
        list.add(i);
    }

    public Instrument get(int serial) {
        for (Instrument i : list)
            if (i.getSerial() == serial)
                return i;

        return null;
    }

    public List<Integer> allSerials() {
        ArrayList<Integer> serialNumbers = new ArrayList<Integer>();

        for (Instrument i : list)
            serialNumbers.add(i.getSerial());

        return serialNumbers;
    }

    public List<Integer> guitarsOfType(Guitar.Type t) {
        ArrayList<Integer> serialGuitars = new ArrayList<Integer>();

        for (Instrument i : list) {
            if (i instanceof Guitar) {

                Guitar g = (Guitar) i;

                if (g.getType() == t)
                    serialGuitars.add(g.getSerial());
            }
        }

        return serialGuitars;
    }
}
