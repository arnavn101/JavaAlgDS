package DataStructures;

/*
    Node class for Tree234 class
*/

public class Node234 {
    private static final int MAXChild = 4;
    private int numberE;
    private Node234 parentNode;

    // Child Links = Data Items + 1
    private Node234 childLinks[] = new Node234[MAXChild];
    private long dataItems[] = new long[MAXChild-1];

    public void connectChild(int childNum, Node234 childToCon){
        childLinks[childNum] = childToCon;
        if(childToCon != null){
            childToCon.parentNode = this;
        }
    }

    public Node234 disconnectChild(int childNum){
        Node234 tempThis = childLinks[childNum];
        childLinks[childNum] = null;
        return tempThis;
    }

    public Node234 getChild(int childNum){
        return childLinks[childNum];
    }

    public Node234 getParent(){
        return parentNode;
    }

    public boolean isLeafNode(){
        return childLinks[0] == null;
    }

    public int getNumberE(){
        return numberE;
    }

    public long getDataItem(int indexE){
        return dataItems[indexE];
    }

    public boolean isFull(){
        return (numberE == MAXChild - 1) ? true : false;
    }

    public int findDataItem(long itemN){
        for(int i = 0; i < numberE; i++){
            if(dataItems[i] == 0L){
                break;
            }
            else if (dataItems[i] == itemN){
                return i;
            }
        }
        return -1;
    }

    public int insertItem(long itemIns){
        if(isFull()){
            return -1;
        }
        numberE++;

        // Look through 1 to End
        for(int i = MAXChild-2; i >= 0; i--){
            if(dataItems[i] == 0L){
                continue;
            }
            else{
                long thisE = dataItems[i];
                if(thisE > itemIns){
                    dataItems[i+1] = dataItems[i];
                }
                else{
                    dataItems[i+1] = itemIns;
                    return i+1;
                }
            }
        }

        // Insert into 0
        dataItems[0] = itemIns;
        return 0;
    }

    public long removeLargestItem(){
        long largestI = dataItems[numberE - 1];
        dataItems[numberE-1] = 0L;
        numberE--;
        return largestI;
    }

    public void displayThisNode(){
        for(int i = 0; i < numberE; i++){
            System.out.print("/" + dataItems[i]);
        }
        System.out.println("/");
    }
}   
