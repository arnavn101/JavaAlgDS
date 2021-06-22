package DataStructures;

/*
    Simple Queue
*/

public class PriorityQueue {

    // Ascending Priority Queue (smaller numbers are put before larger)
    private long[] queueArray;
    private int maxSize;
    private int nElements;

    public PriorityQueue(int maxElements) {
        maxSize = maxElements;
        queueArray = new long[maxSize];
        nElements = 0;
    }

    public void insertElement(long toInsert){
        int iterator;

        if(nElements == 0){
            queueArray[nElements] = toInsert;
            nElements++;
        }
        else{
            for(iterator=nElements-1; iterator>=0; iterator--){
                if (toInsert > queueArray[iterator]){
                    queueArray[iterator+1] = queueArray[iterator];
                }
                else{
                    break;
                }
            }
            queueArray[iterator+1] = toInsert;
            nElements++;
        }
    }

    public long removeElement(){
        long toReturn = queueArray[nElements-1];
        nElements--;
        return toReturn;
    }

    public long peekMin(){
        return queueArray[nElements-1];
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