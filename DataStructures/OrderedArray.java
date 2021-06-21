package DataStructures;

/*
    Simple Ordered Array with binary search
*/

public class OrderedArray {
    private long[] arrayObject;
    private int numberFilledE;

    public OrderedArray(int maxElements) {
        arrayObject = new long[maxElements];
        numberFilledE = 0;
    }
    
    public int size() {
        return numberFilledE;
    }

    public int findE(long toSearch){
        int lowerB = 0;
        int uBound = numberFilledE - 1;
        int finalIndex;

        while(true){
            finalIndex = (uBound + lowerB) / 2;

            if(toSearch == arrayObject[finalIndex]){
                return finalIndex;
            }
            else if(uBound < lowerB){
                return -1;
            }
            else {
                if(toSearch > arrayObject[finalIndex]){
                    lowerB = finalIndex + 1;
                }
                else if(toSearch < arrayObject[finalIndex]){
                    uBound = finalIndex - 1;
                }
            }
        }
    }

    public void insertE(long toBeInserted){
        int index;
        for(index = 0; index < numberFilledE; index++){
            if (arrayObject[index] > toBeInserted){
                break;
            }
        }
        for(int i = numberFilledE; i > index; i--){
            arrayObject[i] = arrayObject[i-1];
        }
        arrayObject[index] = toBeInserted;
        numberFilledE++;
    }

    public boolean deleteE(long toBeDeleted){
        int indexElement = findE(toBeDeleted);

        if (indexElement == -1){
            return false;
        }

        for(int i = indexElement; i < numberFilledE; i++){
            arrayObject[i] = arrayObject[i+1];
        }
        numberFilledE--;
        return true;
    }

    public void displayA() {
        for(int i = 0; i < numberFilledE; i++){
            System.out.print(arrayObject[i] + ", ");
        }
        System.out.println();
    }

}
