package tasks;

public class NamedTasks extends Tasks {
    private String[] names;

    public NamedTasks(String[] names) {
        super(names.length); // Use the super constructor
        this.names = names;
    }

    // Helper method to find the index of a task name
    private int getIndex(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name))
                return i;
        }
        return -1;
    }

    public boolean dependsOn(String task1, String task2) {
        int idx1 = getIndex(task1);
        int idx2 = getIndex(task2);

        // If names are invalid, return false
        if (idx1 == -1 || idx2 == -1)
            return false;

        // Use the inherited method from Tasks
        return super.dependsOn(idx1, idx2);
    }

    public String[] nameOrder() {
        int[] intOrder = super.order(); // Reuse the algorithm from the superclass

        if (intOrder == null)
            return null; // Return null if a cycle exists

        // Convert the integer IDs back into their String names
        String[] result = new String[names.length];
        for (int i = 0; i < intOrder.length; i++) {
            result[i] = names[intOrder[i]];
        }
        return result;
    }
}