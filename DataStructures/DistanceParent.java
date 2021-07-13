package DataStructures;

// Class for storing distances and parents for shortest path algos
public class DistanceParent {
    public int distance; 
    public int parentVertex;

    public DistanceParent(int pV, int dD){
        parentVertex = pV;
        distance = dD;
    }
}
