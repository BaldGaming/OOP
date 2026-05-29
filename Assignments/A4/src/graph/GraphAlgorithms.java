package graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class GraphAlgorithms {

    public static <V> boolean connected(GraphInterface<V> g, V v1, V v2) {
        if (v1.equals(v2)) {
            return true;
        }

        Set<V> visited = new HashSet<>();
        
        return dfs(g, v1, v2, visited);
    }

    private static <V> boolean dfs(GraphInterface<V> g, V current, V target, Set<V> visited) {
        if (current.equals(target)) {
            return true;
        }

        visited.add(current);

        Collection<V> neighbours = g.neighbours(current);
        
        if (neighbours != null) {
            for (V neighbor : neighbours) {
                if (!visited.contains(neighbor)) {
                    if (dfs(g, neighbor, target, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}