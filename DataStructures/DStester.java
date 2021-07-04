package DataStructures;

/*
    Tester file for DS
*/

public class DStester {
    public static void main(String args[]){
        Graph thisG = new Graph();
        thisG.insertVertex('A');
        thisG.insertVertex('B');
        thisG.insertVertex('C');
        thisG.insertVertex('D');
        thisG.insertVertex('E');
        thisG.insertVertex('F');
        thisG.insertVertex('G');
        thisG.insertVertex('H');
        
        thisG.addEdgeDirected(0, 3);
        thisG.addEdgeDirected(0, 4);
        thisG.addEdgeDirected(1, 4);
        thisG.addEdgeDirected(2, 5);
        thisG.addEdgeDirected(3, 6);
        thisG.addEdgeDirected(4, 6);
        thisG.addEdgeDirected(5, 7);
        thisG.addEdgeDirected(6, 7);

        System.out.print("DFS Visits: ");
        thisG.depthFirstSearch(0);
        System.out.println();

        System.out.print("BFS Visits: ");
        thisG.breadthFirstSearch(0);
        System.out.println();

        System.out.print("Min Spanning Tree: ");
        thisG.minimumSpanningTree(0);
        System.out.println();

        thisG.printMatrix(thisG.warshallAlgorithm());
        thisG.topologicalSort();
    }
}
