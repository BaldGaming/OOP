package graph;

import java.util.*;

public class Graph<V> {
    private Set<V> vertices;
    private Map<V, Set<V>> edges;

    public Graph() {
        this.vertices = new HashSet<>();
        this.edges = new HashMap<>();
    }

    public void addVertex(V v) throws GraphException {
        if (vertices.contains(v)) {
            throw new GraphException("Vertex already exists!");
        }
        vertices.add(v);
        edges.putIfAbsent(v, new HashSet<>());
    }

    public void addEdge(V v1, V v2) throws GraphException {
        if (!vertices.contains(v1) || !vertices.contains(v2)) {
            throw new GraphException("Cannot add edge: One or both vertices do not exist.");
        }
        
        if (edges.get(v1).contains(v2) || edges.get(v2).contains(v1)) {
            throw new GraphException("Adding an existing edge, should throw exception graph.GraphException.");
        }

        edges.get(v1).add(v2);
        edges.get(v2).add(v1);
    }

    public boolean hasEdge(V v1, V v2) {
        return edges.containsKey(v1) && edges.get(v1).contains(v2);
    }

    public boolean connected(V v1, V v2) throws GraphException {
        if (!vertices.contains(v1) || !vertices.contains(v2)) {
            throw new GraphException("Cannot check connection: One or both vertices do not exist.");
        }
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
        Set<V> neighbors = edges.getOrDefault(current, Collections.emptySet());
        for (V neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, target, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}