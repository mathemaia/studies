import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class BreadthFirstSearch {
    private Graph graph;

    public BreadthFirstSearch(Graph graph) {
        this.graph = graph;
    }

    private void BFS(String v) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(v);

        // do the search
        while (!queue.isEmpty()) {
            String current = queue.poll();

            for (String neighbor : this.graph.getAdj(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public void startFrom(String v) {
        this.BFS(v);
    }
}