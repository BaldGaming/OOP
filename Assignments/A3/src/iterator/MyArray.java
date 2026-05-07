package iterator;

import java.util.NoSuchElementException;

public class MyArray implements MyIterator {
    private int[] array;
    private int currentIndex;

    public MyArray(int[] array) {
        this.array = array;
        currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < array.length;
    }

    @Override
    public int next() {
        if (!hasNext()) 
            throw new NoSuchElementException();

        return array[currentIndex++];
    }
}