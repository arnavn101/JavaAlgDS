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

        thisG.addEdgeD(0, 1, 50);
        thisG.addEdgeD(0, 3, 80);
        thisG.addEdgeD(1, 2, 60);
        thisG.addEdgeD(1, 3, 90);
        thisG.addEdgeD(2, 4, 40);
        thisG.addEdgeD(3, 2, 20);
        thisG.addEdgeD(3, 4, 70);
        thisG.addEdgeD(4, 1, 50);

        System.out.print("Minimum Path: ");
        thisG.DijkstraShortestPath(0);
        System.out.println();
    }
}
