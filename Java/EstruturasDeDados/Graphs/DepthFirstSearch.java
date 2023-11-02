import java.util.*;

class DepthFirstSearch {
    private Set<String> visited;
    private Map<String, String> edgeTo;
    private Graph graph;
    private String firstVisited;

    /**
     * Constructor.
     * @param graph graph that the search will be done.
     */
    public DepthFirstSearch(Graph graph) {
        this.graph = graph;
    }

    /**
     * The search is done with recursion, visiting the first node that is neighbor of the
     * actual node.
     * @param v node that is being visited.
     */
    private void DFS(String v) {
        this.visited.add(v);

        for (String neighbor : graph.getAdj(v)) {
            if (!visited.contains(neighbor)) {
                this.edgeTo.put(neighbor, v);
                this.DFS(neighbor);
            }
        }
    }

    /**
     * Every time this method is called, it initializes all parameters of the class, so a
     * new list of "visited" nodes is created, for example.
     * @param v the node that will start the search.
     */
    public void startFrom(String v) {
        this.firstVisited = v;

        this.visited = new HashSet<>();
        this.edgeTo = new HashMap<>();

        this.DFS(v);
    }

    /**
     * Check if the target node has been already visited.
     * @param v target node.
     * @return true or false.
     */
    public boolean hasPathTo(String v) {
        return this.visited.contains(v);
    }

    /**
     * Get a list with the path from de first node visited to the node
     * passed as parameter.
     * @param v target node.
     * @return a path to the target node.
     */
    public Iterable<String> pathTo(String v) {
        List<String> path = new LinkedList<>();

        if (this.hasPathTo(v)) {
            while (!v.equals(this.firstVisited)) {
                path.add(0, v);
                v = this.edgeTo.get(v);
            }
            path.add(0, this.firstVisited);
        }

        return path;
    }
}