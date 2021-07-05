package DataStructures;

public class Edge {
    public int sourceVertex; // Vertex starting edge
    public int destinationV; // Vertex ending edge
    public int distance; // Distance from source to destination

    public Edge(int sV, int dV, int dD){
        sourceVertex = sV;
        destinationV = dV;
        distance = dD;
    }
}
