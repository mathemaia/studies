import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class UndirectedGraph {
    private Map<String, Set<String>> graph;

    public UndirectedGraph() {
        this.graph = new HashMap<>();
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

    public void addEdge(String v, String w) {
        this.addToList(v, w);
        this.addToList(w, v);
    }

    public Map<String, Set<String>> getGraph() {
        return this.graph;
    }

    public Iterable<String> getAdj(String v) {
        return this.graph.get(v);
    }

    public Set<String> getVerts() {
        return this.graph.keySet();
    }
}