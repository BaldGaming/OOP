package iterator;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Combined<E> implements Iterable<E> { 

    private final Iterable<E> first;
    private final Iterable<E> second;

    public Combined(Iterable<E> first, Iterable<E> second) {
        // Collections.emptyList() is a good way to get a safe empty Iterable
        this.first = first != null ? first : Collections.emptyList();
        this.second = second != null ? second : Collections.emptyList();
    }

    @Override
    public Iterator<E> iterator() {

        Iterator<E> iter1 = first.iterator();
        Iterator<E> iter2 = second.iterator();

        return new Iterator<E>() {

            private boolean turn;

            @Override
            public boolean hasNext() {
                return (iter1.hasNext() || iter2.hasNext());
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                if (!turn) {
                    if (iter1.hasNext()) {
                        turn = true;
                        return iter1.next();
                    }
                    return iter2.next();
                }

                else {
                    if (iter2.hasNext()) {
                        turn = false;
                        return iter2.next();
                    }
                    return iter1.next();
                }
            }
        };
    }
}