package DataStructures;


public class RedBlackTree {
    private BinaryNode rootN; 

    // Same find() as BinaryTree
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

    public boolean delete(int iD){
        // TODO
        return false; 
    }

    /*
    0) All rules met
    1) Every node is either black or red colored
    2) The root is always black
    3) If a node is red, its children must be black
    4) Every path from root to a leaf (or null child) should contain same no. of black nodes
        - (Not necessary to check rule 4)
    */
    public int checkRules(){
        // Empty Tree
        if(rootN == null){
            return 0;
        }

        // Rule 2
        else if(rootN.isRedNode){
            return 2;
        }
        
        int rCheck = traverseCheck(rootN.rightChild, rootN, true);
        int lCheck = traverseCheck(rootN.leftChild, rootN, false);
        
        return (rCheck > lCheck) ? rCheck : lCheck;
    }

    public int traverseCheck(BinaryNode thisNode, BinaryNode preNode, boolean rightCheck){
        // Traversed through entire path
        if(thisNode == null){
            return 0;
        }

        // Rule 1
        else if(thisNode.isRedNode == null || preNode.isRedNode == null){
            return 1;
        }

        // Rule 3: red nodes must have black children
        else if(thisNode.isRedNode && preNode.isRedNode){
            return 3;
        }
        
        // If no rules are broken, follow the path on both the sides
        else{
            if(rightCheck)
                return traverseCheck(thisNode.rightChild, thisNode, rightCheck);
            else
                return traverseCheck(thisNode.leftChild, thisNode, rightCheck);
        }
    }

    public BinaryNode getInnerGrandchild(BinaryNode primNode, Boolean toRight){
        if(toRight){
            if(primNode.rightChild == null || primNode.rightChild.leftChild == null){
                return null;
            }
            else{
                return primNode.rightChild.leftChild;
            }
        }
        else{
            if(primNode.leftChild == null || primNode.leftChild.rightChild == null){
                return null;
            }
            else{
                return primNode.leftChild.rightChild;
            }
        }
    }

    public boolean rotateLeft(BinaryNode rotationPoint){
        if (rotationPoint.rightChild == null){
            return false;
        }

        BinaryNode iGrandChild = getInnerGrandchild(rotationPoint, true);
        rotationPoint.rightChild.leftChild = rotationPoint; 
        rotationPoint.rightChild = iGrandChild;

        if(rotationPoint == rootN){
            rootN = rotationPoint.rightChild.leftChild;
            rootN.isRedNode = false; 
        }
        return true;
    }

    public boolean rotateRight(BinaryNode rotationPoint){
        if (rotationPoint.leftChild == null){
            return false;
        }

        BinaryNode iGrandChild = getInnerGrandchild(rotationPoint, false);
        rotationPoint.leftChild.rightChild = rotationPoint; 
        rotationPoint.leftChild = iGrandChild;

        if(rotationPoint == rootN){
            rootN = rotationPoint.leftChild.rightChild;
            rootN.isRedNode = false; 
        }
        return true;
    }

    // Flip colors of node (unless it's root) and its children
    public void colorFlip(BinaryNode primaryNode){
        if(primaryNode.rightChild != null){
            primaryNode.rightChild.isRedNode = !primaryNode.rightChild.isRedNode;
        }

        if(primaryNode.leftChild != null){
            primaryNode.leftChild.isRedNode = !primaryNode.leftChild.isRedNode;
        }

        if(primaryNode != rootN){
            primaryNode.isRedNode = !primaryNode.isRedNode;
        }
        else{
            primaryNode.isRedNode = false;
        }

    }

    public void insert(int iD, double dD){
        BinaryNode toIns = new BinaryNode(iD, dD);

        if(rootN == null){
            toIns.isRedNode = false;
            rootN = toIns;
            return;
        }

        /* 
            * Keep Track of Node, Parent Node, GrandParent Node

            - Peform color flip if black node with 2 red children found
            - Possible conflict with red-red
                (resolve with rotations based on position of node)
        */
        BinaryNode parentN = rootN;
        BinaryNode previousN = null, beforePrevN = null;
        toIns.isRedNode = true;

        // Step 1: Flip Colors if black node with 2 red children found
        while(true){
            if(parentN.rightChild != null && parentN.leftChild != null){
                if(!parentN.isRedNode && parentN.rightChild.isRedNode && parentN.rightChild.isRedNode){
                    colorFlip(parentN);
                    break;
                }
            }

            if(previousN != null){
                beforePrevN = previousN;
            }

            previousN = parentN; // This would be GP node if above break is achieved
            if(iD < parentN.iData){
                parentN = parentN.leftChild;

                // No more children nodes so add this one
                if(parentN == null){
                    previousN.leftChild = toIns;
                    return;
                }     
            }

            else if(iD > parentN.iData){
                parentN = parentN.rightChild;

                // No more children nodes so add this one
                if(parentN == null){
                    previousN.rightChild = toIns;
                    return;
                }     
            }
        }

        // Step 2: Fix case where GP and P are both Red
        int errorMessage = checkRules();
        if(errorMessage != 0){
            // If Flipped Node is an "Inside Grandchild"
            if(getInnerGrandchild(beforePrevN, true) == parentN || 
                                        getInnerGrandchild(beforePrevN, false) == parentN){
                previousN.isRedNode = !previousN.isRedNode;
                parentN.isRedNode = !parentN.isRedNode;

                if(previousN.leftChild == parentN){
                    rotateRight(previousN);
                }
                else{
                    rotateLeft(previousN);
                }

                if(beforePrevN.leftChild == previousN){
                    rotateRight(beforePrevN);
                }
                else{
                    rotateLeft(beforePrevN);
                }
            }
            
            // If Flipped Node is an "Outside Grandchild"
            else{
                previousN.isRedNode = !previousN.isRedNode;
                if(beforePrevN.leftChild == previousN){
                    rotateRight(beforePrevN);
                }
                else{
                    rotateLeft(beforePrevN);
                }
            }
        }
        
        BinaryNode gpNode = parentN;
        BinaryNode currentN = parentN;
        BinaryNode pNode;

        // Insert the Node and Check for errors (max 2 iterations of loop)
        while(true){
            pNode = currentN;

            if(iD > currentN.iData){
                currentN = currentN.rightChild;

                // No more children nodes so add this one
                if(currentN == null){
                    pNode.rightChild = toIns;
                    currentN = pNode.leftChild;
                    break;
                }     
            }
            else{
                currentN = currentN.leftChild;

                // No more children nodes so add this one
                if(currentN == null){
                    pNode.leftChild = toIns;
                    currentN = pNode.leftChild;
                    break;
                }
            }
        }

        // Step 3: Fix case where both parent and current node are red
        int secondMessage = checkRules();
        if(secondMessage == 0){
            return;
        }

        // If Node is inside grandchild of gpNode
        if(getInnerGrandchild(gpNode, true) == currentN || 
                            getInnerGrandchild(gpNode, false) == currentN){
            gpNode.isRedNode = !gpNode.isRedNode;
            currentN.isRedNode = !currentN.isRedNode;

            if(pNode.rightChild == currentN){
                rotateLeft(pNode);
            }
            else{
                rotateRight(pNode);
            }

            if(gpNode.leftChild == pNode){
                rotateRight(gpNode);
            }
            else{
                rotateRight(gpNode);
            }
        }

        // If Node is outside grandchild of gpNode
        else{
            gpNode.isRedNode = !gpNode.isRedNode;
            pNode.isRedNode = !pNode.isRedNode;
            
            if(gpNode.leftChild == pNode){
                rotateRight(gpNode);
            }
            else{
                rotateLeft(gpNode);
            }

        }
    }
}
