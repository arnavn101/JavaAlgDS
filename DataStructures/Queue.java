package DataStructures;

/*
    Simple Queue
*/

public class Queue {
    private int[] queueArray;
    private int frontIndex;
    private int backIndex;
    private int maxSize;
    private int nElements;

    public Queue(int maxElements) {
        maxSize = maxElements;
        queueArray = new int[maxSize];
        frontIndex = 0;
        backIndex = -1; // Behind the front index initially
        nElements = 0;
    }

    public void insertElement(int toInsert){
        // Allow for "circling" queue
        if (backIndex == (maxSize-1))
            backIndex = -1;

        backIndex++;
        queueArray[backIndex] = toInsert;
        nElements++;
    }

    public int removeElement(){
        int toReturn = queueArray[frontIndex];
        frontIndex++;

        if(frontIndex == maxSize)
            frontIndex = 0;

        nElements--;
        return toReturn;
    }

    public int peekFront(){
        return queueArray[frontIndex];
    }

    public boolean isEmpty(){
        return nElements == 0;
    }

    public boolean isFull(){
        return nElements == maxSize;
    }

    public int size(){
        return nElements;
    }
}