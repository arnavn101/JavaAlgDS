package Algorithms;

/*
    Merge Sort Algorithm
*/

public class MergeSort {
    private long[] inputArray;

    public MergeSort(long[] inpArray){
        inputArray = inpArray;
        int initialL = inputArray.length;
        doMergeSort(0, initialL-1);
    }

    public long[] returnSorted(){
        return inputArray;
    }

    public void doMergeSort(int lBound, int uBound){
        if(!(uBound > lBound)){
            return;
        }

        // Get the middle bound
        int mBound = (uBound + lBound)/2;

        // Execute merge sort for both the halves
        doMergeSort(lBound, mBound);
        doMergeSort(mBound+1, uBound);

        // Merge the two sorted halves
        mergeArrays(lBound, mBound, uBound);
    }

    public void mergeArrays(int lBound, int mBound, int uBound){
        int lengthArr1 = mBound - lBound + 1;
        int lengthArr2 = uBound - mBound;

        long[] arr1 = new long[lengthArr1];
        long[] arr2 = new long[lengthArr2];

        for(int i = 0; i < lengthArr1; i++){
            arr1[i] = inputArray[lBound+i];
        }
        for(int j = 0; j < lengthArr2; j++){
            arr2[j] = inputArray[mBound+j+1];
        }

        int it1 = 0, it2 = 0;
        int startIt = lBound;
        while(it1 < lengthArr1 && it2 < lengthArr2){
            if(arr1[it1] >= arr2[it2]){
                inputArray[startIt] = arr2[it2];
                it2++;
            }
            else{
                inputArray[startIt] = arr1[it1];
                it1++;
            }
            startIt++;
        }
        
        // Insert remaining numbers into array
        while(it1 < lengthArr1){
            inputArray[startIt] = arr1[it1];
            it1++;
            startIt++;
        }

        while(it2 < lengthArr2){
            inputArray[startIt] = arr2[it2];
            it2++;
            startIt++;
        }
    }
}
