import java.util.*;


public abstract interface Graph {
    public void addEdge(String v, String w);
    public Map<String, Set<String>> getGraph();
    public Iterable<String> getAdj(String v);
}


class UndirectedGraph implements Graph {
    private Map<String, Set<String>> graph;

    public UndirectedGraph() {
        this.graph = new HashMap<>();
    }

    // SETTERS
    @Override
    public void addEdge(String v, String w) {
        this.addToList(v, w);
        this.addToList(w, v);
    }
    private void addToList(String v, String w) {
        // check if the vertex (key) exists on dictionary
        if (!this.graph.containsKey(v)) {
            this.graph.put(v, new HashSet<>());
        }

        // add W to the list of V
        Set<String> set = this.graph.get(v);
        set.add(w);
        this.graph.put(v, set);
    }

    // GETTERS
    @Override
    public Map<String, Set<String>> getGraph() {
        return this.graph;
    }
    @Override
    public Iterable<String> getAdj(String v) {
        return this.graph.get(v);
    }
}


class DirectedGraph implements Graph {
    private Map<String, Set<String>> graph;

    public DirectedGraph() {
        this.graph = new HashMap<>();
    }

    // SETTERS
    private void addToList(String v, String w) {
        if (!this.graph.containsKey(v)) {
            this.graph.put(v, new HashSet<>());
        }

        Set<String> set = this.graph.get(v);
        set.add(w);
        this.graph.put(v, set);
    }
    @Override
    public void addEdge(String v, String w) {
        this.addToList(v, w);
    }

    // GETTERS
    @Override
    public Map<String, Set<String>> getGraph() {
        return this.graph;
    }
    @Override
    public Iterable<String> getAdj(String v) {
        return this.graph.get(v);
    }
}