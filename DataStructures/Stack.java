package DataStructures;

/*
    Simple Stack
*/

public class Stack {
    private int[] stackArray;
    private int topIndex;
    private int maxSize;

    public Stack(int maxElements) {
        maxSize = maxElements;
        stackArray = new int[maxSize];
        topIndex = -1; // No data is pushed to the stack yet
    }

    public void push(int dataInput){
        topIndex++;
        stackArray[topIndex] = dataInput;
    }

    public int pop(){
        int toReturn = stackArray[topIndex];
        topIndex--;
        return toReturn;
    }

    public int peek(){
        return stackArray[topIndex];
    }

    public boolean isEmpty(){
        return topIndex == -1;
    }

    public boolean isFull(){
        return topIndex == (maxSize - 1);
    }
}