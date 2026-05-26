package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private ArrayList<Instrument> list = new ArrayList<Instrument>();
    private int counter = 0;

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

    public List<Integer> guitarsOfType(Type t) {
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

    public void sell(int serial) throws MusicShopException {
        Instrument toRemove = get(serial);

        if (toRemove == null)
            throw new MusicShopException("Instrument with serial " + serial + " not found.");

        if (toRemove instanceof Guitar) {

            int guitarCount = 0;
            for (Instrument i : list) {
                if (i instanceof Guitar)
                    guitarCount++;
            }

            if (guitarCount <= 1)
                throw new MusicShopException("Cannot sell the last guitar in the shop!");
        }

        list.remove(toRemove);
    }

    public int sellAll(int[] serials) {
        int notSold = 0;

        for (int serial : serials) {
            try {
                sell(serial);
            } catch (MusicShopException e) {
                notSold++;
            }
        }

        return notSold;
    }
}
