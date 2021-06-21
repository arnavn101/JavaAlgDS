package Algorithms;

/*
    Bubble Sort Algorithm
*/

public class BubbleSort {

    public static long[] sortLongArrayB(long[] inpArray){
        long toBeStored;

        for(int i = inpArray.length; i > 0; i--){
            for(int j = 0; j < i - 1; j++){
                if(inpArray[j+1] < inpArray[j]){
                    toBeStored = inpArray[j];
                    inpArray[j] = inpArray[j+1];
                    inpArray[j+1] = toBeStored;
                }

                // Technically not a part of bubble sort, but slightly optimizes the algorithm
                if((j-1) >= 0 && inpArray[j] < inpArray[j-1]){
                    toBeStored = inpArray[j];
                    inpArray[j] = inpArray[j-1];
                    inpArray[j-1] = toBeStored;
                }

            }
        }
        return inpArray;
    }


}
