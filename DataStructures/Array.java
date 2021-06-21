package DataStructures;

/*
    Simple Array to store data
*/

class Array {
    private long[] arrayObject;
    private int numberFilledE;

    public Array(int maxElements) {
        arrayObject = new long[maxElements];
        numberFilledE = 0;
    }

    public boolean findElement(long elementToSearch){
        for(int i = 0; i < numberFilledE; i++){
            if (arrayObject[i] == elementToSearch){
                return true;
            }
        }
        return false;
    }

    public void insertElement(long toBeInserted) {
        arrayObject[numberFilledE] = toBeInserted;
        numberFilledE++;
    }

    public boolean deleteElement(long delElement) {
        int i;
        for(i = 0; i < numberFilledE; i++){
            if (arrayObject[i] == delElement){
                break;
            }
        }

        if (i < numberFilledE){
            for(int j = i; j < numberFilledE; j++){
                arrayObject[j] = arrayObject[j+1];
            }
            numberFilledE--;
            return true;
        }
        
        return false;
    }

    public void displayArray() {
        for(int i = 0; i < numberFilledE; i++){
            System.out.print(arrayObject[i] + ", ");
        }
        System.out.println();
    }
}