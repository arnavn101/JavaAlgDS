package DataStructures;

/*
    Simple Stack
*/

public class Stack {
    private long[] stackArray;
    private int topIndex;
    private int maxSize;

    public Stack(int maxElements) {
        maxSize = maxElements;
        stackArray = new long[maxSize];
        topIndex = -1; // No data is pushed to the stack yet
    }

    public void push(long dataInput){
        topIndex++;
        stackArray[topIndex] = dataInput;
    }

    public long pop(){
        long toReturn = stackArray[topIndex];
        topIndex--;
        return toReturn;
    }

    public long peek(){
        return stackArray[topIndex];
    }

    public boolean isEmpty(){
        return topIndex == -1;
    }

    public boolean isFull(){
        return topIndex == (maxSize - 1);
    }
}