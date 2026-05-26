package equiv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Equiv<E> {

    private List<Set<E>> list = new ArrayList<>();

    public void add(E e1, E e2) {

        Set<E> set1 = null;
        Set<E> set2 = null;

        for (Set<E> set : list) {
            if (set.contains(e1))
                set1 = set;

            if (set.contains(e2))
                set2 = set;
        }

        // Case 1: Both are null
        if (set1 == null && set2 == null) {
            Set<E> newSet = new HashSet<>();

            newSet.add(e1);
            newSet.add(e2);

            list.add(newSet);
        }

        // Case 2: if the match
        else if (set1 == set2) {
            // do nothing lol
        }

        // Case 3: One of them is null
        else if (set1 != null && set2 == null)
            set1.add(e2);
        else if (set1 == null && set2 != null)
            set2.add(e1);

        // Case 4: They are in two different sets
        else {
            set1.addAll(set2);
            list.remove(set2);
        }
    }

    public boolean are(E e1, E e2) {
        if (e1.equals(e2))
            return true;

        for (Set<E> set : list)
            if (set != null && set.contains(e1) && set.contains(e2))
                return true;

        return false;
    }
}
