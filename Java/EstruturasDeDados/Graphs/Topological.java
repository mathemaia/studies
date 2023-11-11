import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Collections;

public class Topological {
    private Set<String> visited;
    private List<String> vertices;
    private DirectedGraph digraph;

    public Topological(DirectedGraph digraph) {
        this.visited = new HashSet<>();
        this.vertices = new LinkedList<>();
        this.digraph = digraph;

        for (String v : digraph.getVerts()) {
            if (!visited.contains(v)) {
                this.DFS(v);
            }
        }
    }

    public Iterable<String> getTopological() {
        return this.vertices;
    }

    public Iterable<String> getPostOrder() {
        LinkedList<String> postOrder = new LinkedList<>(this.vertices);
        Collections.reverse(postOrder);
        return postOrder;
    }

    private void DFS(String v) {
        this.visited.add(v);

        if (this.digraph.getAdj(v) != null) {
            for (String w : this.digraph.getAdj(v)) {
                if (!this.visited.contains(w)) {
                    this.DFS(w);
                }
            }
        }

        this.vertices.add(0, v);
    }
}
