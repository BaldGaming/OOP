package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoArrays implements Iterable<Integer> { 

    private final int[] a1;
    private final int[] a2;

    public TwoArrays(int[] a1, int[] a2) {
        this.a1 = a1 != null ? a1 : new int[0];
        this.a2 = a2 != null ? a2 : new int[0];
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            
            private int index1 = 0;
            private int index2 = 0;
            private boolean turn; // False - index1's turn, True - index2's turn.
            
            @Override
            public boolean hasNext() {
                return (index1 < a1.length || index2 < a2.length);
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                // index1's turn
                if (!turn) {
                    // check if we haven't reached the end of a1
                    if (index1 < a1.length) {
                        turn = !turn;
                        return a1[index1++];
                    }
                    else
                        return a2[index2++];
                }

                // index2's turn
                else {
                    // check if we haven't reached the end of a2
                    if (index2 < a2.length) {
                        turn = !turn;
                        return a2[index2++];
                    }
                    else
                        return a1[index1++];
                }
            }
        };
    }
}