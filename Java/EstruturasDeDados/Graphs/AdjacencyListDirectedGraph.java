package AlestII.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class implements a Directed Graph using the Adjacency List concept.
 * @author Matheus Maia
 * @version 06-05-2023
 */
public class AdjacencyListDirectedGraph {
    // Parameters
    ArrayList<Vertex> verticesList;
    int numVertices;
    int numEdges;

    // Constructor
    public AdjacencyListDirectedGraph() {
        this.verticesList = new ArrayList<>();
        this.numEdges = 0;
    }

    // Setters
    /**
     * Add a vertex by passing its id and element
     * @param id string that identifies the vertex
     * @param elem element that the vertex contains
     */
    public void addVertex(String id, int elem) {
        verticesList.add(new Vertex(id, elem));
        numVertices++;
    }
    public void addEdge(String vertex1, String vertex2) {
        // Creates an arraylist with the elements of vertices
        ArrayList<String> aux = new ArrayList<>(Arrays.asList(vertices()));

        // Access the vertex that will be connected to another
        int idx = aux.indexOf(vertex1);

        // Add the vertex2 to the list of the vertex1 edges
        verticesList.get(idx).setOutgoing(vertex2);

        numEdges++;
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
        String[] aux = new String[this.verticesList.size()];

        for (int i = 0; i < aux.length; i++) {
            aux[i] = String.valueOf(this.verticesList.get(i));
        }

        return aux;
    }
    /**
     * Returns an array with the id of all vertices that are pointed by the vertex passed
     * @RunningTime
     * @param v the vertex that the edges outgoes
     * @return array of vertices
     */
    public String[] outgoingEdges(String v) {
        // Creates an arraylist with the elements of vertices
        ArrayList<String> aux = new ArrayList<>(Arrays.asList(vertices()));

        // Access the vertex1 that will be connected to vertex2
        int idx = aux.indexOf(v);

        return verticesList.get(idx).getOutgoing(v);
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

/**
 * Inner class that implements the vertices of the graph
 */
class Vertex {
    // Parameters
    public String id;
    public int elem;
    public ArrayList<String> outgoing;
    public ArrayList<String> incoming;

    // Constructor
    public Vertex(String id, int elem) {
        this.id = id;
        this.elem = elem;
        this.outgoing = new ArrayList<>();
    }

    // Setters
    public void setOutgoing(String vertex) {
        this.outgoing.add(vertex);
    }

    // Getters
    public String getId() {
        return this.id;
    }

    ////////////////////// Arrumar a descrição
    /**
     * Returns an array of all incoming edges to vertex v
     * @RunningTime O(indeg(v))
     * @param v vertex that the edges outgoes
     * @return array of strings
     */
    public String[] getOutgoing(String v) {
        return this.outgoing.toArray(String[]::new);
    }

    ////////////////////// Arrumar a descrição
    /**
     * Returns an array of all incoming edges to vertex v
     * @RunningTime O(indeg(v))
     * @param v vertex that the edges outgoes
     * @return array of strings
     */
    public String[] getIncoming(String v) {
        return this.incoming.toArray(String[]::new);
    }
    @Override
    public String toString() {
        return this.id;
    }
}
