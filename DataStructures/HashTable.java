package DataStructures;

public class HashTable {
    private KeyValue[] hashArray;
    private int sizeArray;
    private KeyValue nonItemN; // Number for designated deleted items

    public HashTable(int sizeTable){
        // Double hashing requires prime array size
        sizeArray = getNextPrime(sizeTable);
        hashArray = new KeyValue[sizeArray];
        nonItemN = new KeyValue(-1, -1L);
    }

    public int getNextPrime(int inpNum){
        for(int i=inpNum; true; i++){
            if(isPrimeNum(i)){
                return i;
            }
        }
    }

    public boolean isPrimeNum(int numJudge){
        for(int i=2; i*i <= numJudge; i++){
            if(numJudge % i == 0){
                return false;
            }
        }
        return true;
    }

    public void displayTable(){
        System.out.println("Table: ");

        for(int j=0; j<sizeArray; j++){
            if(hashArray[j] != null){
                System.out.print(hashArray[j].getValue() + " ");
            }
            else{
                System.out.print("** ");
            }
        }
        System.out.println();
    }
    
    public int hashFunction1(int key){
        return key % sizeArray; // Restrict the key to range of the array
    }

    public int hashFunction2(int key){
        // Non-Zero, < Array Size, Prime constant
        return  5 - (key % 5); // Restrict the stepSize to range of 1 to 5
    }

    public void insertItem(KeyValue toIns){
        int key = toIns.getKey();
        int hashValue = hashFunction1(key);
        int stepSize = hashFunction2(key);

        while(hashArray[hashValue] != null && hashArray[hashValue].getKey() != -1){
            hashValue += stepSize; // Proceed to next cell
            hashValue %= sizeArray; // Reset hashValue to 0 if == sizeArray
        }
        hashArray[hashValue] = toIns;
    }

    public int deleteItem(int toDelKey){
        int hashValue = hashFunction1(toDelKey);
        int stepSize = hashFunction2(toDelKey);

        while(hashArray[hashValue] != null){
            if(hashArray[hashValue].getKey() == toDelKey){
                KeyValue tempThis = hashArray[hashValue];
                hashArray[hashValue] = nonItemN;
                return tempThis.getKey();
            }
            hashValue += stepSize;
            hashValue %= sizeArray;
        }
        return -1;
    }

    public KeyValue findItem(int toFindKey){
        int hashValue = hashFunction1(toFindKey);
        int stepSize = hashFunction2(toFindKey);

        while(hashArray[hashValue] != null){
            if(hashArray[hashValue].getKey() == toFindKey){
                return hashArray[hashValue];
            }
            hashValue += stepSize;
            hashValue %= sizeArray;
        }
        return null;
    }
}   
