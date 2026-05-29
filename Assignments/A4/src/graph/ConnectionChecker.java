package graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ConnectionChecker<V> {
    private GraphInterface<V> graph;

    public ConnectionChecker(GraphInterface<V> g) {
        this.graph = g;
    }

    public boolean check(V v1, V v2) {
        if (v1.equals(v2)) {
            return true;
        }
        Set<V> visited = new HashSet<>();
        return dfs(v1, v2, visited);
    }

    private boolean dfs(V current, V target, Set<V> visited) {
        if (current.equals(target)) {
            return true;
        }
        visited.add(current);
        
        Collection<V> neighbours = graph.neighbours(current);
        if (neighbours != null) {
            for (V neighbor : neighbours) {
                if (!visited.contains(neighbor)) {
                    if (dfs(neighbor, target, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}