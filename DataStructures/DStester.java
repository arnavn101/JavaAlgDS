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

        thisG.addEdge(0, 1, 6);
        thisG.addEdge(0, 3, 4);
        thisG.addEdge(1, 2, 10);
        thisG.addEdge(1, 3, 7);
        thisG.addEdge(1, 4, 7);
        thisG.addEdge(2, 3, 8);
        thisG.addEdge(2, 4, 5);
        thisG.addEdge(2, 5, 6);
        thisG.addEdge(3, 4, 12);
        thisG.addEdge(4, 5, 7);

        System.out.print("Minimum spanning tree: ");
        thisG.minimumSpanningTreeW(0);
        System.out.println();
    }
}
