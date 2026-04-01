package Week_2.Lab.TimerUpgrade;

public class Timer {
    // Variables
    private int s;

    // Constructors
    public Timer(int m, int s) {
        this.s = m*60 + s;
    }

    public Timer(int s) {
        this.s = s;
    }

    public boolean tickDown() {
        if (s == 0)
            return false;
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
        return String.format("(%02d:%02d)", s/60, s%60);
    }

    // Method
    public int totalSeconds() {
        return s;
    }
}
