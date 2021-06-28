package Algorithms;

/*
    Quick Sort Algorithm
*/

public class QuickSort {
    private long[] inputArray;

    public QuickSort(long[] inpArray){
        inputArray = inpArray;
        doQuickSort(0, inputArray.length - 1);
    }

    public long[] returnSorted(){
        return inputArray;
    }

    public void doQuickSort(int leftBound, int rightBound){
        int sizeSegment = rightBound - leftBound + 1;

        // Insertion sort performs better in small arrays
        if(sizeSegment < 4){
            sortByInsertion(leftBound, rightBound);
        }
        else{
            long medianPivot = medianOf3(leftBound, rightBound);

            // Set pivot point as the rightmost element in the array
            int partitionPoint = partitionArray(leftBound, rightBound, medianPivot);

            // Perform quick sort on each segment of array
            doQuickSort(leftBound, partitionPoint-1);
            doQuickSort(partitionPoint+1, rightBound);
        }
    }

    public long medianOf3(int lBound, int rBound){
        int centerPoint = (lBound + rBound) / 2;

        // Ensure that arr[lBound] > arr[centerP] > arr[rBound]
        if(inputArray[lBound] > inputArray[centerPoint]){
            swapElements(lBound, centerPoint);
        }

        if(inputArray[centerPoint] > inputArray[rBound]){
            swapElements(rBound, centerPoint);
        }

        if(inputArray[lBound] > inputArray[rBound]){
            swapElements(lBound, centerPoint);
        }

        // Swap pivot to the left of the rightmost element
        swapElements(centerPoint, rBound - 1);
        return inputArray[rBound-1];
    }

    public int partitionArray(int lBound, int rBound, long pPoint){ 
        // already ensured correct place of endmost elements with median approach
        int leftCount = lBound; 
        int rightCount = rBound - 1; // Pivot point is situated on rBound - 1

        while(true){
            while(inputArray[++leftCount] < pPoint)
                ; // Placeholder
            
            while(inputArray[--rightCount] > pPoint)
                ; // Placeholder
            
            if(leftCount >= rightCount){
                break;
            }
            else{
                swapElements(leftCount, rightCount);
            }
        }
        // Put the Pivot in the middle of array
        swapElements(leftCount, rBound - 1);

        // return the position of the Pivot
        return leftCount; 
    }

    public void sortByInsertion(int leftB, int rightB){
        for(int i = leftB+1; i <= rightB; i++){
            int j = i;
            long tempThis = inputArray[j];

            while(j > leftB && inputArray[j-1] >= tempThis){
                inputArray[j] = inputArray[j-1];
                j--;
            }
            
            inputArray[j] = tempThis;
        }
    }

    public void swapElements(int ind1, int ind2){
        long tempThis = inputArray[ind1];
        inputArray[ind1] = inputArray[ind2];
        inputArray[ind2] = tempThis;
    }

}
