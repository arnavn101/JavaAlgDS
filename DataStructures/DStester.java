package DataStructures;

/*
    Tester file for DS
*/

public class DStester {
    public static void main(String args[]){
        DoublyLinkedList sampleL = new DoublyLinkedList();
        sampleL.insertFirst(5, 2.55);
        sampleL.insertFirst(17, 1.33);
        sampleL.insertLast(1, 100.1);
        sampleL.insertLast(50, 1.11);
        sampleL.insertFirst(3, 1.11);

        sampleL.displayForward();

        sampleL.deleteFirst();
        sampleL.deleteLast();
        sampleL.displayBackward();
    }
}
