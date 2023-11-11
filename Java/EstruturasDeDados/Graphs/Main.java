public class Main {
    public static void main(String[] args) {
        DirectedGraph digraph = new DirectedGraph();

        digraph.addEdge("0", "3");
        digraph.addEdge("0", "2");
        digraph.addEdge("2", "3");
        digraph.addEdge("3", "4");
        digraph.addEdge("4", "5");
        digraph.addEdge("5", "3");

        Topological topological = new Topological(digraph);
        DigraphCycle hasCycle = new DigraphCycle(digraph);

        System.out.println(digraph.getGraph());

        //System.out.println("\nTopological:\n" + topological.getTopological());
        //System.out.println("Post-Order:\n" + topological.getPostOrder());
    }
}