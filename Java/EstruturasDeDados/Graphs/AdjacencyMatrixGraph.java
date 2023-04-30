package AlestII.Graphs;

import java.util.ArrayList;
import java.util.Random;

public class AdjacencyMatrixGraph {
    // List of the graph's vertices
    private ArrayList<Vertex> verticesList;
    // Adacency matrix that saves all vertices connections
    private int[][] matrix;
    // Numver of graph's vertices
    int numVertices;
    // This class implements a vertex of the graph
    private static class Vertex {
        public int element;

        /**
         * Constructor
         */
        private Vertex(int element) {
            this.element = element;
        }
    }


    /**
     * Constructor
     * @param numVertices number of graph's vertices
     */
    public AdjacencyMatrixGraph(int numVertices) {
        this.numVertices = numVertices;
        this.matrix = new int[numVertices][numVertices];
        this.verticesList = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < numVertices; i++) {
            assert false;
            verticesList.add(new Vertex(random.nextInt(-100, 100)));
        }
    }


    // Getters
    public ArrayList<Vertex> getVerticesList() {
        return verticesList;
    }
    public int getNumVertices() {
        return numVertices;
    }
    public int getVertexElement(int index) {
        return verticesList.get(index).element;
    }
    public int[][] getMatrix() {
        return matrix;
    }

    // Setters
    public void setVerticesList(ArrayList<Vertex> verticesList) {
        this.verticesList = verticesList;
    }
    public void connectTo(int indexV1, int indexV2) {
        this.matrix[indexV1][indexV2] = 1;
    }

}
