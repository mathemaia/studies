package AlestII.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class implements a Directed Graph using the Adjacency List concept.
 * @author Matheus Maia
 * @version 06-05-2023
 */

public class AdjacencyListDirectedGraph {
    /**
     * Inner class that implements the vertices of the graph
     */
    private class Vertex {
        // Parameters
        private String element;
        private ArrayList<String> edges;

        // Constructor
        private Vertex(String element) {
            this.element = element;
            this.edges = new ArrayList<>();
        }

        // Setters
        private void setEdges(String vertex) {
            this.edges.add(vertex);
        }

        // Getters
        private String getElement() {
            return this.element;
        }
        private String[] getEdges(String vertex) {
            return this.edges.toArray(String[]::new);
        }
    }

    // Parameters
    ArrayList<Vertex> verticesList;
    int numEdges;

    // Constructor
    public AdjacencyListDirectedGraph() {
        this.verticesList = new ArrayList<>();
        this.numEdges = 0;
    }

    // Setters
    public void addVertex(String vertex) {
        verticesList.add(new Vertex(vertex));
    }
    public void addEdge(String vertex1, String vertex2) {
        // Creates an arraylist with the elements of vertices
        ArrayList<String> aux = new ArrayList<>(Arrays.asList(vertices()));

        // Access the vertex that will be connected to another
        int idx = aux.indexOf(vertex1);

        // Add the vertex2 to the list of the vertex1 edges
        verticesList.get(idx).setEdges(vertex2);
    }
    public void removeEdge() {

    }
    public void removeVertex() {

    }

    // Getters
    /**
     * Return the number of vertices of the graph
     * @RunningTime O(1)
     * @return number of vertices
     */
    public int numVertices() {
        return verticesList.size();
    }
    /**
     * Return the number of edges of the graph
     * @RunningTime O(1)
     * @return number of edges
     */
    public int numEdges() {
        return numEdges;
    }
    /**
     * Return an array of the elements of all vertices
     * @RunningTime O(n)
     * @return array of vertices
     */
    public String[] vertices() {
        return verticesList.stream().map(vertex -> vertex.getElement()).toArray(String[]::new);
    }

    /**
     * Return an array of all edges of the graph
     * @return
     */
    public int edges() {
        return 0;
    }


    public String[] edges(String vertex) {
        // Creates an arraylist with the elements of vertices
        ArrayList<String> aux = new ArrayList<>(Arrays.asList(vertices()));

        // Access the vertex1 that will be connected to vertex2
        int idx = aux.indexOf(vertex);

        return verticesList.get(idx).getEdges(vertex);
    }


    public int getEdge() {
        return 0;
    }
    public int outDegree() {
        return 0;
    }
    public int inDegree() {
        return 0;
    }
    public int outgoingEdges() {
        return 0;
    }

}
