package Algorithms;

/*
    Shell Sort Algorithm
*/

public class ShellSort {
    public static long[] sortLongArrayS(long[] inpArray){
        // h = 3*h+1, where h is initially 1 (Knuth)
        int initialWidthSize = 1;
        int lengthArray = inpArray.length;
        while(true){
            if ((initialWidthSize*3) + 1 > lengthArray){
                break;
            }
            initialWidthSize = (initialWidthSize*3) + 1;
        }

        while(initialWidthSize > 0){
            for(int i = initialWidthSize; i < lengthArray; i++){
                int j = i;
                long tempThis = inpArray[j];
                
                // Similar to Insertion sort (but has widthSize)
                while(j >= initialWidthSize && inpArray[j-initialWidthSize] >= tempThis){
                    inpArray[j] = inpArray[j-initialWidthSize];
                    j -= initialWidthSize;
                }
                
                inpArray[j] = tempThis;
            }

            // h = (h-1)/3
            initialWidthSize = (initialWidthSize-1)/3;
        }
        return inpArray;
    }
}
