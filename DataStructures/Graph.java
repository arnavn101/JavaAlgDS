package DataStructures;

/*
    Simple Graph
*/

public class Graph {
    private final int MAX_VERTS = 20; // Maximum amount of vertices
    private Vertex[] listVertices;
    private int[][] adjMatrix;
    private int nVertices;
    private Stack thisStack; // for DFS
    private Queue thisQueue; // for BFS

    public Graph(){
        listVertices = new Vertex[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        nVertices = 0;
        thisStack = new Stack(MAX_VERTS);
        thisQueue = new Queue(MAX_VERTS);
    }

    public void insertVertex(char vLabel){
        listVertices[nVertices++] = new Vertex(vLabel);
    }

    public void addEdge(int startE, int endE){
        adjMatrix[startE][endE] = 1;
        adjMatrix[endE][startE] = 1;
    }

    public void displayVertex(int vIndex){
        System.out.print(listVertices[vIndex].labelV);
    }

    // Stack-Based Approach
    public void depthFirstSearch(int vStart){
        listVertices[vStart].isVisited = true;
        displayVertex(vStart);
        thisStack.push(vStart);

        while(!thisStack.isEmpty()){
            int nextV = getAdjacentUnvisited(thisStack.peek());

            if(nextV == -1){
                thisStack.pop();
            }
            else{
                listVertices[nextV].isVisited = true;
                displayVertex(nextV);
                thisStack.push(nextV);
            }
        }

        resetVisitedFlags();
    }

    // Recursive Approach
    public void dfsRecursive(int vThis){
        listVertices[vThis].isVisited = true;
        displayVertex(vThis);
        
        int nextV = getAdjacentUnvisited(vThis);
        if(nextV != -1){
            dfsRecursive(nextV);
        }
    }
    
    public void breadthFirstSearch(int vStart){
        listVertices[vStart].isVisited = true;
        displayVertex(vStart);
        thisQueue.insertElement(vStart);
        int vNext;

        while(!thisQueue.isEmpty()){
            int vThis = thisQueue.removeElement();

            while((vNext=getAdjacentUnvisited(vThis)) != -1){
                listVertices[vNext].isVisited = true;
                displayVertex(vNext);
                thisQueue.insertElement(vNext);
            }
        }

        resetVisitedFlags();
    }

    // Set all isVisited to 'false'
    public void resetVisitedFlags(){
        for(int i=0; i < nVertices; i++){
            listVertices[i].isVisited = false;
        }
    }

    public int getAdjacentUnvisited(int vSearch){
        for(int i=0; i < nVertices; i++){
            if(adjMatrix[vSearch][i] == 1 && !listVertices[i].isVisited){
                return i;
            }
        }
        return -1;
    }
}
