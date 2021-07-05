package DataStructures;

public class Vertex {
    public char labelV;
    public boolean isVisited; // Useful for searching
    public boolean isInTree; // Used for min spanning treee

    public Vertex(char label){
        labelV = label;
        isVisited = false;
        isInTree = false;
    }
}
