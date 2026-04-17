package bank;

public class ProAccount extends Account {

    private int[] history = new int[100];
    private int historySize = 0;

    public ProAccount(String name) {
        super(name);
    }
    
    @Override
    public void add(int amount) {
        super.add(amount);

        if (historySize < 100) {
            history[historySize] = getShekels();
            historySize++;
        }
    }

    @Override
    public String toString() {
        String result = super.toString() + " [";
        
        for (int i = 0; i < historySize; i++) {
            result += history[i];
            if (i < historySize - 1) {
                result += ",";
            }
        }
        
        return result += "]";
    }

    public static void transfer(ProAccount from, ProAccount to, int amount) {
        from.add(-amount);
        to.add(amount);
    }
}
