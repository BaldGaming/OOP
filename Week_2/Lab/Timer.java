package Week_2.Lab;

public class Timer {
    // Variables
    private int m, s;

    // Constructors
    public Timer(int m, int s) {
        this.m = m;
        this.s = s;
    }

    public Timer(int s) {
        m = s/60;
        this.s = s%60;
    }

    public boolean tickDown() {
        if (s == 0) {
            if (m == 0) 
                return false;
            m--;
            s = 59;
            }
        else
            s--;
        return true;
    }

    public Timer diff (Timer other) {
        int diff = this.totalSeconds() - other.totalSeconds();
        if (diff < 0)
            return null;
        
        return new Timer(diff);
    }

    // Method
    public String toString() {
        String res = "(";
        if (m < 10)
            res += "0";
        res += m + ":";

        if (s < 10)
            res += "0";

        return res + s + ")";
    }

    // Method
    public int totalSeconds() {
        return 60 * m + s;
    }
}
