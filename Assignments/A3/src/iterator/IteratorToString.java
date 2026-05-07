package iterator;

public class IteratorToString {

    public static String toString(MyIterator it) {
        StringBuilder sb = new StringBuilder("[");
        
        while(it.hasNext())
            sb.append(it.next() + " ");

        if (sb.length() > 1)
            sb.delete(sb.length() - 1, sb.length());
        
        sb.append("]");

        return sb.toString();
    }
}
