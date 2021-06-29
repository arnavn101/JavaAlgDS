package DataStructures;

/*
    Binary Tree DS Implementation
*/

public class BinaryTree {
        private BinaryNode rootN; 

        public BinaryNode find(int key){
            BinaryNode currentN = rootN;
            while(currentN.iData != key){
                if(key < currentN.iData){
                    currentN = currentN.leftChild;
                }
                else{
                    currentN = currentN.rightChild;
                }

                // No more children nodes
                if(currentN == null){
                    return null;
                }
            }
            return currentN;
        }

        public BinaryNode getRootNode(){
            return rootN;
        }

        public void insert(int iD, double dD){
            BinaryNode currentN = rootN;
            BinaryNode prevN;
            BinaryNode toIns = new BinaryNode(iD, dD);

            if(rootN == null){
                rootN = toIns;
            }
            else{
                while(true){
                    prevN = currentN;
                    if(iD < currentN.iData){
                        currentN = currentN.leftChild;

                        // No more children nodes so add this one
                        if(currentN == null){
                            prevN.leftChild = toIns;
                            return;
                        }    
                    }
                    else{
                        currentN = currentN.rightChild;

                        // No more children nodes so add this one
                        if(currentN == null){
                            prevN.rightChild = toIns;
                            return;
                        }    
                        
                    }
                }
            }
        }

        public boolean delete(int iD){
            BinaryNode currentN = rootN;
            BinaryNode previousN = rootN;
            boolean isRightChild = false;

            while(currentN.iData != iD){
                previousN = currentN;
                if(iD < currentN.iData){
                    currentN = currentN.leftChild;
                }
                else{
                    currentN = currentN.rightChild;
                    isRightChild = true;
                }

                // Node does not exist
                if(currentN == null){
                    return false;
                }
            }

            // Removing a leaf from tree
            if(currentN.leftChild == null && currentN.rightChild == null){
                if(currentN == rootN){
                    rootN = null;
                }
                else if(isRightChild){
                    previousN.rightChild = null;
                }
                else{
                    previousN.leftChild = null;
                }
            }
            
            // Removing a node with one child (only rightChild)
            else if(currentN.leftChild == null){
                if(currentN == rootN){
                    rootN = currentN.leftChild;
                }
                else if(isRightChild){
                    previousN.rightChild = currentN.rightChild;
                }
                else{
                    previousN.leftChild = currentN.rightChild;
                }
            }

            // Removing a node with one child (only leftChild)
            else if(currentN.rightChild == null){
                if(currentN == rootN){
                    rootN = currentN.rightChild;
                }
                else if(isRightChild){
                    previousN.rightChild = currentN.leftChild;
                }
                else{
                    previousN.leftChild = currentN.leftChild;
                }
            }

            else{
                // Get Successor Node
                BinaryNode successNode = getSuccessorNode(currentN);

                // Connect parent of currentN to successor
                if(currentN == rootN){
                    rootN = successNode;
                }
                else if(isRightChild){
                    previousN.rightChild = successNode;
                }
                else{
                    previousN.leftChild = successNode;
                }

                // Connect successor to currentN's left child
                successNode.leftChild = currentN.leftChild;
            }
            return true;
        }

        // Traverse tree in ascending order
        public void traverseInOrder(BinaryNode thisRootNode){
            if(thisRootNode != null){
                // Left Children -> This Node -> Right Children
                traverseInOrder(thisRootNode.leftChild);
                System.out.print(thisRootNode.iData + " ");
                traverseInOrder(thisRootNode.rightChild);
            }
        }

        public BinaryNode minimumTree(){
            BinaryNode currentN = rootN;
            BinaryNode prevN = rootN;
            while(currentN != null){
                prevN = currentN;
                currentN = currentN.leftChild;
            }
            return prevN;
        }

        public BinaryNode maximumTree(){
            BinaryNode currentN = rootN;
            BinaryNode prevN = rootN;
            while(currentN != null){
                prevN = currentN;
                currentN = currentN.rightChild;
            }
            return prevN;
        }

        // Get the next lowest node to the input
        private BinaryNode getSuccessorNode(BinaryNode toDelete){
            BinaryNode previousNode = toDelete;
            BinaryNode successNode = toDelete;
            BinaryNode currentNode = toDelete.rightChild;

            while(currentNode != null){
                previousNode = successNode;
                successNode = currentNode;
                currentNode = currentNode.leftChild;
            }

            if(successNode != toDelete.rightChild){
                previousNode.leftChild = successNode.rightChild;
                successNode.rightChild = toDelete.rightChild;
            }
            return successNode;
        }
}
