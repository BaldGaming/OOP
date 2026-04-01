package Week_2.Lab.TimerUpgrade;

public class MainForTimer {
    public static void main(String[] args) {
        Timer t1 = new Timer(10, 5);
        System.out.print("Timer constructor test: ");
        System.out.println(t1);
        System.out.print("Total seconds method test: ");
        System.out.println(t1.totalSeconds());

        Timer t2 = new Timer(200);
        System.out.println(t2);

        Timer t3 = t1.diff(t2);
        System.out.println(t3);

        Timer t4 = t2.diff(t1);
        System.out.println(t4);

        for (int i = 0; i < 10; i++) {
            System.out.print(t2 + " ");
            t2.tickDown();
        }
        System.out.println();

        Timer t5 = new Timer(10);
        System.out.print(t5 + " ");
        while (t5.tickDown())
            System.out.print(t5 + " ");
    }
}