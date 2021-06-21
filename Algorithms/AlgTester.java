package Algorithms;

/*
    Tester file for DS
*/

public class AlgTester {
    public static void main(String args[]){
        long[] testArray = new long[]{8, 5, 1, 100, 10, 29, 2, 19, 0};
        long[] sortedArray = BubbleSort.sortLongArrayB(testArray);
        displayLongArray(sortedArray); 
    }

    public static void displayLongArray(long[] inpArray) {
        for(int i = 0; i < inpArray.length; i++){
            System.out.print(inpArray[i] + ", ");
        }
        System.out.println();
    }

}
