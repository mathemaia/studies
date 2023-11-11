import java.util.HashMap;
import java.util.Map;

public class DigraphCycle {
    public enum Mark {
        WHITE,  // not visited
        GRAY,   // being visited
        BLACK   // visited
    };
    private DirectedGraph digraph;
    private Map<String, Mark> marked;
    private boolean hasCycle;

    public DigraphCycle(DirectedGraph digraph) {
        this.digraph = digraph;
        this.marked = new HashMap<>();
        this.hasCycle = false;

        // marks all vertices as not visited (WHITE)
        for (String v : digraph.getVerts()) {
            this.marked.put(v, Mark.WHITE);
        }

        // visit each not visited vertex (WHITE) and search for cycle
        for (String v : digraph.getVerts()) {
            if (this.marked.get(v) == Mark.WHITE) {
                this.hasCycle = this.containsCycle(v);

                if (this.hasCycle) {
                    break;
                }
            }
        }
    }

    public boolean containsCycle() {
        return this.hasCycle;
    }

    public boolean containsCycle(String v) {
        // marks vertex as being visited
        this.marked.put(v, Mark.GRAY);

        System.out.println(this.marked);

        for (String w : this.digraph.getAdj(v)) {
            if (this.marked.get(w) == Mark.GRAY) {
                return true;
            } else if (this.marked.get(w) == Mark.WHITE) {
                boolean contains = this.containsCycle(w);

                if (contains) {
                    return true;
                }
            }
        }

        System.out.println(v + " BLACK");
        this.marked.put(v, Mark.BLACK);
        return false;
    }
}
