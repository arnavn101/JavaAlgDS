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

        thisG.addEdge(0, 1);
        thisG.addEdge(1, 2);
        thisG.addEdge(0, 3);
        thisG.addEdge(3, 4);

        System.out.print("DFS Visits: ");
        thisG.depthFirstSearch(0);
        System.out.println();

        System.out.print("BFS Visits: ");
        thisG.breadthFirstSearch(0);
        System.out.println();
    }
}
