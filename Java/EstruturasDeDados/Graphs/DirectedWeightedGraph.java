import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DirectedWeightedGraph {
    /**
     * Inner class that implements an edge with weights.
     */
    abstract private class Edge implements Comparable<Edge> {
        private String v;
        private String w;
        private double weight;

        public Edge(String v, String w, double weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        public String getV() {
            return v;
        }

        public String getW() {
            return w;
        }

        public double getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Double.compare(this.weight, other.weight);
        }

        @Override
        public String toString() {
            return v + "-" + w + " (" + weight + ") ";
        }
    }

    private Map<String, List<Edge>> graph;

    public DirectedWeightedGraph() {
        this.graph = new HashMap<>();
    }
    /*
    public void addEdge(String v, String w, double weight) {
        Edge e = new Edge(v, w, weight);
        this.add
    }
     */
    
    /*
     private void addToList(String v, Edge e) {
        List<Edge> list = graph.get(v)
    }
    @Override
    public Map<String, Set<String>> getGraph() {
        return null;
    }

    @Override
    public Iterable<String> getAdj(String v) {
        return null;
    }

    @Override
    public Set<String> getVerts() {
        return null;
    }
     */

}