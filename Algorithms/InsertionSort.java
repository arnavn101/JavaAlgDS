package Algorithms;

/*
    Insertion Sort Algorithm
*/

public class InsertionSort {

    public static long[] sortLongArrayI(long[] inpArray){
        for(int i = 1; i < inpArray.length; i++){
            int j = i;
            long tempThis = inpArray[j];

            while(j > 0 && inpArray[j-1] >= tempThis){
                inpArray[j] = inpArray[j-1];
                j--;
            }
            
            inpArray[j] = tempThis;
        }
        return inpArray;
    }

}
