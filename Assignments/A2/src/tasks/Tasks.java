package tasks;

public class Tasks {

    private int num;

    public Tasks(int num) {
        this.num = num;
    }

    public boolean dependsOn(int task1, int task2) {
        // Check if the task number exceeds "num"
        if (task1 > num || task2 > num)
            return false;

        
    }

    public int[] order() {
        
    }
}
