package Algorithms;


/*
    Selection Sort Algorithm
*/

public class SelectionSort {

    public static long[] sortLongArrayS(long[] inpArray){
        long thisMinimum;
        int thisMinimumIndex = 0;

        for(int i = 0; i < inpArray.length; i++){
            thisMinimum = -1;
            
            for(int j = i; j < inpArray.length; j++){
                if (thisMinimum == -1 || thisMinimum > inpArray[j]){
                    thisMinimumIndex = j;
                    thisMinimum = inpArray[thisMinimumIndex];
                }
            }
            
            long tempThis = inpArray[i];
            inpArray[i] = thisMinimum;
            inpArray[thisMinimumIndex] = tempThis;
        }
        return inpArray;
    }

}
