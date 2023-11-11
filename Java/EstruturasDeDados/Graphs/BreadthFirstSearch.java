import java.util.*;

class BreadthFirstSearch {
    private Graph graph;
    private Set<String> visited;
    private Map<String, String> edgeTo;
    private Map<String, Integer> distTo;
    private String firstVisited;

    /**
     * Constructor.
     * @param graph graph that the search will be done.
     */
    public BreadthFirstSearch(Graph graph) {
        this.graph = graph;
        this.visited = new HashSet<>();
        this.edgeTo = new HashMap<>();
        this.distTo = new HashMap<>();
    }

    /**
     * Do the search.
     * @param v node that will start the search.
     */
    private void BFS(String v) {
        Queue<String> queue = new LinkedList<>();

        queue.add(v);
        this.visited.add(v);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int dist = this.distTo.get(current);

            for (String neighbor : this.graph.getAdj(current)) {
                if (!this.visited.contains(neighbor)) {
                    queue.add(neighbor);
                    this.visited.add(neighbor);
                    this.edgeTo.put(neighbor, current);
                    this.distTo.put(neighbor, dist + 1);
                }
            }
        }
    }

    /**
     * Method that starts the search.
     * @param v node that will start the search.
     */
    public void startFrom(String v) {
        this.visited = new HashSet<>();
        this.edgeTo = new HashMap<>();
        this.distTo = new HashMap<>();

        this.firstVisited = v;
        this.BFS(v);
    }

    /**
     * Return the distance between the first node visited to the target node.
     * @param v target node.
     * @return distance or -1 if it doesn't exist.
     */
    public int distTo(String v) {
        if (this.hasPathTo(v)) {
            return this.distTo.get(v);
        }

        return -1;
    }

    /**
     * Check if there is a path from the started node to the target node.
     * @param v target node.
     * @return path, if it exists.
     */
    public boolean hasPathTo(String v) {
        return this.visited.contains(v);
    }

    /**
     * Returns the path from the first node visited to target node.
     * @param v target node.
     * @return path, if it exists.
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