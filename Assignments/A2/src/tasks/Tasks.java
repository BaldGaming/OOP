package tasks;

import java.util.Arrays;

public class Tasks {

    private int num;
    private boolean[][] adj; // adj[i][j] means task j depends on task i
    private int[] inDegree; // inDegree[j] = number of tasks task j is waiting for

    public Tasks(int num) {
        this.num = num;
        this.adj = new boolean[num][num];
        this.inDegree = new int[num];
    }

    public boolean dependsOn(int task1, int task2) {
        // Check for valid task indices
        if (task1 < 0 || task1 >= num || task2 < 0 || task2 >= num || task1 == task2) {
            return false;
        }

        // task1 cannot be performed before task2 (task2 -> task1)
        if (!adj[task2][task1]) {
            adj[task2][task1] = true;
            inDegree[task1]++;
        }
        return true;
    }

    public int[] order() {
        int[] result = new int[num];
        int count = 0;

        // We make a copy of inDegree so we can "delete" dependencies during the process
        int[] tempInDegree = Arrays.copyOf(inDegree, num);
        boolean[] processed = new boolean[num];

        while (count < num) {
            int currentTask = -1;

            // Find a task that isn't waiting on anything [cite: 903]
            for (int i = 0; i < num; i++) {
                if (!processed[i] && tempInDegree[i] == 0) {
                    currentTask = i;
                    break;
                }
            }

            // If no "free" task is found but we aren't done, there's a cycle
            if (currentTask == -1)
                return null;

            // Add to result and "remove" its dependencies
            result[count++] = currentTask;
            processed[currentTask] = true;

            for (int neighbor = 0; neighbor < num; neighbor++) {
                if (adj[currentTask][neighbor]) {
                    tempInDegree[neighbor]--;
                }
            }
        }
        return result;
    }
}