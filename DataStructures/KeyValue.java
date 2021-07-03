package DataStructures;

/*
    Key value pair for HashTables
*/
public class KeyValue {
    private int keyData; 
    private long lValue;

    public KeyValue(int kD, long lV){
        keyData = kD;
        lValue = lV;
    }

    public int getKey(){
        return keyData;
    }

    public long getValue(){
        return lValue;
    }
}
