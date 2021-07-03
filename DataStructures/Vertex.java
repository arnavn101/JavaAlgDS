package DataStructures;

public class Vertex {
    public char labelV;
    public boolean isVisited; // Useful for searching

    public Vertex(char label){
        labelV = label;
        isVisited = false;
    }
}
