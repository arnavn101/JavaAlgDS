package DataStructures;

public class Heap {
    private BinaryNode[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int maxS){
        maxSize = maxS;
        currentSize = 0;
        heapArray = new BinaryNode[maxSize];
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public boolean isFull(){
        return currentSize == maxSize;
    }

    public boolean insert(int keyN, double valN){
        if(isFull()){
            return false;
        }
        BinaryNode toIns = new BinaryNode(keyN, valN);
        heapArray[currentSize] = toIns; // Place Node at empty position
        trickleUp(currentSize++);
        return true;
    }

    public void trickleUp(int nodeInd){
        int parentIndex = getParentNode(nodeInd);
        BinaryNode thisNode = heapArray[nodeInd];

        while(nodeInd > 0 && thisNode.iData > heapArray[parentIndex].iData){
            heapArray[nodeInd] = heapArray[parentIndex];
            nodeInd = parentIndex;
            parentIndex = getParentNode(nodeInd);
        }

        heapArray[nodeInd] = thisNode;
    }

    // Remove topmost node
    public BinaryNode remove(){
        BinaryNode rootN = heapArray[0];
        heapArray[0] = heapArray[--currentSize]; // Place last element in root
        trickleDown(0);
        return rootN;
    }

    public void trickleDown(int nodeInd){
        int childLarger;
        BinaryNode topNode = heapArray[nodeInd];

        // While node has at least one child
        while(nodeInd < currentSize/2){
            int leftChild = getChildNode(nodeInd, false);
            int rightChild = getChildNode(nodeInd, true);

            if(rightChild < currentSize && heapArray[rightChild].iData > heapArray[leftChild].iData){
                childLarger = rightChild;
            }
            else{
                childLarger = leftChild;
            }

            if(topNode.iData >= heapArray[childLarger].iData){
                break;
            }

            heapArray[nodeInd] = heapArray[childLarger];
            nodeInd = childLarger;
        }
        heapArray[nodeInd] = topNode;
    }

    public boolean changeNode(int indexNode, int newValue){
        if(indexNode < 0 || indexNode >= currentSize){
            return false;
        }
        
        int oldVal = heapArray[indexNode].iData;
        heapArray[indexNode].iData = newValue;

        if(newValue > oldVal){
            trickleUp(indexNode);
        }
        else{
            trickleDown(indexNode);
        }
        return true;
    }

    public int getParentNode(int thisNode){
        return (thisNode - 1) / 2;
    }

    public int getChildNode(int thisNode, boolean isRightC){
        if(isRightC){
            return 2*thisNode + 2;
        }
        return 2*thisNode + 1;
    }

}
