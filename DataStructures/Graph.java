package DataStructures;

/*
    Simple Graph
*/

public class Graph {
    private final int MAX_VERTS = 20; // Maximum amount of vertices
    private Vertex[] listVertices;
    private final int INFINITY = 1000000;
    private int[][] adjMatrix;
    private int nVertices;
    private Stack thisStack; // for DFS
    private Queue thisQueue; // for BFS
    private PriorityQueueV thisPriorityQ; // for min spanning tree
    private int numberTree; // Number of vertices in tree
    private char topoSortedArray[]; // for topological sorting
    private int currentVertex;
    
    // For shortest path 
    private DistanceParent shortestPaths[];
    private int distStartToCurr; // distance to currentVertex

    public Graph(){
        listVertices = new Vertex[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        nVertices = 0;
        numberTree = 0;
        thisStack = new Stack(MAX_VERTS);
        thisQueue = new Queue(MAX_VERTS);
        topoSortedArray = new char[MAX_VERTS];
        thisPriorityQ = new PriorityQueueV(MAX_VERTS);

        for(int i=0; i < MAX_VERTS; i++){
            for(int j=0; j < MAX_VERTS; j++){
                adjMatrix[i][j] = INFINITY;
            }
        }

        shortestPaths = new DistanceParent[MAX_VERTS];
    }

    public void insertVertex(char vLabel){
        listVertices[nVertices++] = new Vertex(vLabel);
    }

    public void addEdge(int startE, int endE, int weightE){
        adjMatrix[startE][endE] = weightE;
        adjMatrix[endE][startE] = weightE;
    }

    public void addEdgeD(int startE, int endE, int weightE){
        adjMatrix[startE][endE] = weightE;
    }


    public void addEdgeDirected(int startE, int endE){
        adjMatrix[startE][endE] = 1;
    }

    public void displayVertex(int vIndex){
        System.out.print(listVertices[vIndex].labelV);
    }

    // Warshall Algorithm (Return a Table specifying if path exists between vertices)
    public int[][] warshallAlgorithm(){
        int[][] copyAdjMatrix = new int[nVertices][nVertices];
        for(int i = 0; i < nVertices; i++){
            for(int j = 0; j < nVertices; j++){
                copyAdjMatrix[i][j] = adjMatrix[i][j];
            }
        }

        // 3 Nested Loops implementation (Transitive Closure)
        for(int row=0; row<nVertices; row++){
            for(int col=0; col<nVertices; col++){

                // Examine cells in 'row' (there is path from col to row)
                if(copyAdjMatrix[row][col] != INFINITY){

                    // Examine cells in 'col' (there is path from rT to col)
                    for(int rT=0; rT<nVertices; rT++){
                        if(copyAdjMatrix[col][rT] != INFINITY){
                            copyAdjMatrix[row][rT] = 1; // there must be a path from rT to row
                        }
                    }
                }
            }
        }

        return copyAdjMatrix;
    }

        // Floyd's Algorithm (Return a Table specifying distance between eahc possbile paths)
        public int[][] floydAlgorithm(){
            int[][] copyAdjMatrix = new int[nVertices][nVertices];
            for(int i = 0; i < nVertices; i++){
                for(int j = 0; j < nVertices; j++){
                    copyAdjMatrix[i][j] = adjMatrix[i][j];
                }
            }
    
            // 3 Nested Loops implementation (Transitive Closure)
            for(int row=0; row<nVertices; row++){
                for(int col=0; col<nVertices; col++){
    
                    // Examine cells in 'row' (there is path from col to row)
                    if(copyAdjMatrix[row][col] != INFINITY){
    
                        // Examine cells in 'col' (there is path from rT to col)
                        for(int rT=0; rT<nVertices; rT++){
                            if(copyAdjMatrix[col][rT] != INFINITY){
                                int foundDistance = copyAdjMatrix[row][col] + copyAdjMatrix[col][rT];

                                if(foundDistance < copyAdjMatrix[row][rT]){
                                    // there must be a path from rT to row (replace distance if smaller)
                                    copyAdjMatrix[row][rT] = foundDistance; 
                                }
                            }
                        }
                    }
                }
            }
    
            return copyAdjMatrix;
        }
    

    public void printMatrix(int matrixP[][]){
        System.out.println("Following matrix is transitive closure"+
                           " of the graph");
        for (int i = 0; i < nVertices; i++){
            for (int j = 0; j < nVertices; j++) {
                if (i == j)
                    System.out.print("1 ");
                else
                    System.out.print(matrixP[i][j]+" ");
            }
            System.out.println();
        }
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


    // Minimum Spanning Tree Algorithm (DFS)
    public void minimumSpanningTree(int sNode){
        listVertices[sNode].isVisited = true;
        thisStack.push(sNode);

        while(!thisStack.isEmpty()){
            int currentVertex = thisStack.peek();
            
            // Find unvisited adjacent node
            int nextN = getAdjacentUnvisited(currentVertex);

            // No neighbor nodes
            if(nextN == -1){
                thisStack.pop();
            }
            else{
                listVertices[nextN].isVisited = true;
                thisStack.push(nextN);

                displayVertex(currentVertex);
                displayVertex(nextN);
                System.out.print(" ");
            }
        }
        resetVisitedFlags();
    }

    // Minimum Spanning Tree Algorithm for Weighted Graphs (DFS)
    public void minimumSpanningTreeW(int sNode){
        currentVertex = sNode;

        while(numberTree < nVertices - 1){
            listVertices[currentVertex].isInTree = true;
            numberTree++;

            // Insert Edges Adjacent to currentVertex into PriorityQ
            for(int i=0; i < nVertices; i++){
                if(i == currentVertex){
                    continue;
                }
                if(listVertices[i].isInTree){
                    continue;
                }
                int thisDistance = adjMatrix[currentVertex][i];
                if(thisDistance == INFINITY){
                    continue;
                }
                insertIntoPriorityQ(i, thisDistance);
            }

            if(thisPriorityQ.size() == 0){
                System.out.println("Graph is not connected!");
                return;
            }

            // Remove min element
            Edge toIns = thisPriorityQ.removeElement();
            int sourceVertex = toIns.sourceVertex;
            currentVertex = toIns.destinationV;

            // Display Edge
            System.out.print(listVertices[sourceVertex].labelV);
            System.out.print(listVertices[currentVertex].labelV);
            System.out.print(" ");
        }

        // Reset flags
        resetVisitedFlags();
    }

    public void insertIntoPriorityQ(int nVertex, int nDistance){
        // Find if another edge has same destination
        int queueInd = thisPriorityQ.findElement(nVertex);

        if(queueInd != -1){
            Edge oldEdge = thisPriorityQ.peekN(queueInd);
            int oldDist = oldEdge.distance;
            // Only insert if it has a smaller distance than oldEdge
            if(oldDist > nDistance){
                thisPriorityQ.removeN(queueInd);
                Edge toInsert = new Edge(currentVertex, nVertex, nDistance);
                thisPriorityQ.insertElement(toInsert);
            }
        }
        else{
            Edge toInsert = new Edge(currentVertex, nVertex, nDistance);
            thisPriorityQ.insertElement(toInsert);
        }
    }

    // Topological sort (requires directed graph with no cycles)
    public void topologicalSort(){
        int originalnVertices = nVertices;

        while(nVertices > 0){
            int currentV = getNoSuccessors();

            // Cyclical Graph so cannot sort
            if(currentV == -1){
                System.out.println("Cannot sort: Graph is cyclical");
                return;
            }

            topoSortedArray[nVertices - 1] = listVertices[currentV].labelV;
            deleteVertex(currentV);
        }

        System.out.print("Topologically Sorted Order: ");
        for(int i=0; i < originalnVertices; i++){
            System.out.print(topoSortedArray[i]);
        }
        System.out.println();
    }

    public void DijkstraShortestPath(int startVertex){
        int startTree = startVertex;
        listVertices[startVertex].isInTree = true;
        numberTree = 1;

        // Transfer row of distance from matrix to a new array
        for(int i=0; i < nVertices; i++){
            int firstDist = adjMatrix[startTree][i];
            shortestPaths[i] = new DistanceParent(startTree, firstDist);
        }

        // Until all vertices are in the tree
        while(numberTree < nVertices){
            int minIndex = getMinVertex(); // find vertex closest to currentVertex 
            int minDistance = shortestPaths[minIndex].distance;

            if(minDistance == INFINITY){
                System.out.println("Unreachable vertex");
                break;
            }
            else{
                currentVertex = minIndex;
                distStartToCurr = shortestPaths[currentVertex].distance;
            }

            listVertices[currentVertex].isInTree = true;
            numberTree++;
            adjustPathArray();
        }

        displayPaths();
        resetVisitedFlags();
    }

    public void displayPaths(){
        for(int i=0; i < nVertices; i++){
            System.out.print(listVertices[i].labelV + "=");
            if(shortestPaths[i].distance == INFINITY){
                System.out.print("inf");
            }
            else{
                System.out.print(shortestPaths[i].distance);
            }
            char parent = listVertices[shortestPaths[i].parentVertex].labelV;
            System.out.print("(" + parent + ") ");
        }
        System.out.println("");
    }

    public void adjustPathArray(){
        int currentCol = 1;
        while(currentCol < nVertices){
            if(listVertices[currentCol].isInTree){
                currentCol++;
                continue;
            }
            // Edge from current Vertex to currentCol
            int currentToCol = adjMatrix[currentVertex][currentCol]; // INF if no edge
            int startToCol = distStartToCurr + currentToCol;
            int thisPathDistance = shortestPaths[currentCol].distance;

            if(startToCol < thisPathDistance){
                shortestPaths[currentCol].parentVertex = currentVertex;
                shortestPaths[currentCol].distance = startToCol;
            }
            currentCol++;
        }
    }


    // Return vertex closest to currentVertex
    public int getMinVertex(){
        int minDistance = INFINITY;
        int minIndex = 0;

        for(int i=0; i < nVertices; i++){
            if(!listVertices[i].isInTree && shortestPaths[i].distance < minDistance){
                minDistance = shortestPaths[i].distance;
                minIndex = i;
            }
        }

        return minIndex;
    }

    // Return Vertex with no Successors (Directed Graph)
    public int getNoSuccessors(){
        boolean hasEdge;
        for(int i=0; i < nVertices; i++){
            hasEdge = false;
            
            for(int j=0; j < nVertices; j++){
                if(adjMatrix[i][j] != INFINITY){
                    hasEdge = true;
                    break;
                }
            }

            if(!hasEdge){
                return i;
            }
        }
        return -1; // No vertex found (cyclical graph)
    }

    public void deleteVertex(int vIndex){
        // If vertex to delete is not the last vertex
        if(vIndex != nVertices - 1){
            for(int i = vIndex; i < nVertices - 1; i++){
                listVertices[i] = listVertices[i+1];
            }

            for(int r=vIndex; r < nVertices-1; r++){
                moveRowUp(r, nVertices);
            }

            for(int c=vIndex; c < nVertices-1; c++){
                moveColLeft(c, nVertices-1);
            }
        }
        nVertices--;
    }

    public void moveRowUp(int rIndex, int lCol){
        for(int c=0; c < lCol; c++){
            adjMatrix[rIndex][c] = adjMatrix[rIndex+1][c];
        }
    }

    public void moveColLeft(int cIndex, int lRow){
        for(int r=0; r < lRow; r++){
            adjMatrix[r][cIndex] = adjMatrix[r][cIndex+1];
        }
    }

    // Set all isVisited to 'false'
    public void resetVisitedFlags(){
        for(int i=0; i < nVertices; i++){
            listVertices[i].isVisited = false;
            listVertices[i].isInTree = false;
        }
        numberTree = 0;
    }

    public int getAdjacentUnvisited(int vSearch){
        for(int i=0; i < nVertices; i++){
            if(adjMatrix[vSearch][i] != INFINITY && !listVertices[i].isVisited){
                return i;
            }
        }
        return -1;
    }
}
