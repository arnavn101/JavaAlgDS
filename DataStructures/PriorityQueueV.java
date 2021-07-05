package DataStructures;

/*
    Simple Queue for Vertices and Edges
*/

public class PriorityQueueV {

    // Descending Priority Queue (larger numbers are put before larger)
    private Edge[] queueArray;
    private int maxSize;
    private int nElements;

    public PriorityQueueV(int maxElements) {
        maxSize = maxElements;
        queueArray = new Edge[maxSize];
        nElements = 0;
    }

    public void insertElement(Edge toInsert){
        int iterator;

        for(iterator=0; iterator<nElements; iterator++){
            if(toInsert.distance >= queueArray[iterator].distance){
                break;
            }
        }

        for(int j=nElements-1; j >= iterator; j--){
            queueArray[j+1] = queueArray[j];
        }

        queueArray[iterator] = toInsert;
        nElements++;
    }

    public Edge removeElement(){
        Edge toReturn = queueArray[nElements-1];
        nElements--;
        return toReturn;
    }

    public int findElement(int findInd){
        for(int i=0; i < nElements; i++){
            if(queueArray[i].destinationV == findInd){
                return i;
            }
        }
        return -1;
    }

    public void removeN(int removeInd){
        for(int i=removeInd; i < nElements-1; i++){
            queueArray[i] = queueArray[i+1];
        }
        nElements--;
    }

    public Edge peekMin(){
        return queueArray[nElements-1];
    }

    public Edge peekN(int nI){
        return queueArray[nI];
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