package DataStructures;

/*
    234 Tree DS
*/

public class Tree234 {
    private Node234 rootN = new Node234();

    public int find(long key){
        Node234 currentN = rootN;
        int childNumber;

        while(true){
            if((childNumber=currentN.findDataItem(key)) != -1){
                return childNumber;
            }
            else if(currentN.isLeafNode()){
                return -1;
            }
            else{
                currentN = getNextChild(currentN, key);
            }
        }
    }

    public Node234 getNextChild(Node234 cNode, long keyN){
        /*
        Child 0: Key 0 > keyN
        Child 1: Key 1 > keyN > Key 0
        Child 2: Key 2 > keyN > Key 1
        Child 3: keyN > Key 2
        */

        int i;
        int numberItems = cNode.getNumberE();

        for(i=0; i<numberItems; i++){
            if(keyN < cNode.getDataItem(i)){
                return cNode.getChild(i);
            }
        }
        return cNode.getChild(i);
    }

    public void insert(long toIns){
        Node234 currentN = rootN;

        while(true){
            // If full node encountered, split it
            if(currentN.isFull()){
                splitNode(currentN);
                currentN = currentN.getParent();
                currentN = getNextChild(currentN, toIns);
            }
            else if(currentN.isLeafNode()){
                break;
            }
            else{
                currentN = getNextChild(currentN, toIns);
            }
        }
        currentN.insertItem(toIns);
    }

    public void splitNode(Node234 toSplitN){
        if(!toSplitN.isFull()){
            return;
        }

        long dataB, dataC;
        Node234 child2, child3, parentNode;
        Node234 siblingN = new Node234();

        dataC = toSplitN.removeLargestItem();
        dataB = toSplitN.removeLargestItem();
        child2 = toSplitN.disconnectChild(2);
        child3 = toSplitN.disconnectChild(3);

        // Two Cases --> NonRoot Node or Root Node
        if(toSplitN == rootN){
            rootN = new Node234();
            parentNode = rootN;
            rootN.connectChild(0, toSplitN);
        }
        else{
            parentNode = toSplitN.getParent();
        }

        int eIndex = parentNode.insertItem(dataB);
        int nElements = parentNode.getNumberE();

        // Make Place for Sibling Node
        for(int i = nElements-1; i > eIndex; i--){
            Node234 tempNode = parentNode.disconnectChild(i);
            tempNode.connectChild(i+1, tempNode);
        }

        parentNode.connectChild(eIndex+1, siblingN);

        // Add items to SiblingNode
        siblingN.insertItem(dataC);
        siblingN.connectChild(0, child2);
        siblingN.connectChild(1, child3);
    }

    public void displayTree(){
        displayTL(rootN, 0, 0);
    }

    public void displayTL(Node234 cNode, int levelN, int childN){
        System.out.print("level="+levelN+" child="+childN+" ");
        cNode.displayThisNode();

        // Recursively display all nodes
        int nElements = cNode.getNumberE();
        for(int i = 0; i < nElements + 1; i++){
            Node234 nextNode = cNode.getChild(i);
            if(nextNode != null){
                displayTL(nextNode, levelN+1, i);
            }
            else{
                return;
            }
        }
    }
}
