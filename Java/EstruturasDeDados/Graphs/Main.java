import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Graph graph = new UndirectedGraph();
        DepthFirstSearch dfs = new DepthFirstSearch(graph);

        graph.addEdge("B", "A");
        graph.addEdge("C", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");
        graph.addEdge("D", "B");
        graph.addEdge("D", "C");
        graph.addEdge("D", "E");
        graph.addEdge("F", "G");

        System.out.println(graph.getGraph());
        dfs.startFrom("B");
        System.out.println(dfs.pathTo("C"));
    }
}