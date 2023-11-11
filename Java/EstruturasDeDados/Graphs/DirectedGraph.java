import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DirectedGraph {
    private Map<String, Set<String>> graph;

    public DirectedGraph() {
        this.graph = new HashMap<>();
    }

    private void addToList(String v, String w) {
        if (!this.graph.containsKey(v)) {
            this.graph.put(v, new HashSet<>());
            this.graph.put(w, new HashSet<>());
        }

        Set<String> set = this.graph.get(v);
        set.add(w);
        this.graph.put(v, set);
    }

    public void addEdge(String v, String w) {
        this.addToList(v, w);
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
