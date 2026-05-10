package Week_6.Lab;

public class StringSet {
    private String[] arr;
    private int num;

    public StringSet(int size) {
        arr = new String[size];
    }

    public void add(String s) throws StringSetFullException {
        if (s == null)
            throw new NullPointerException();
        if (arr.length == num)
            throw new StringSetFullException();
        arr[num++] = s;
    }

    public boolean contains(String s) {
        if (s == null)
            throw new NullPointerException();
        for (int i = 0; i < num; i++)
            if (arr[i].equals(s))
                return true;
        return false;
    }
}