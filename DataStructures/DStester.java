package DataStructures;

/*
    Tester file for DS
*/

public class DStester {
    public static void main(String args[]){
        BinaryTree sampleT = new BinaryTree();

        sampleT.insert(50, 1.99);
        sampleT.insert(25, 0.87);
        sampleT.insert(11, 3.14);

        BinaryNode foundN = sampleT.find(50);
        if(foundN != null){
            System.out.println("Found this node");
        }
        else{
            System.out.println("Did not find this node");
        }

        sampleT.traverseInOrder(sampleT.find(50));
        System.out.println();

        boolean delN = sampleT.delete(25);
        if(delN){
            System.out.println("Deleted this node");
        }
        else{
            System.out.println("Did not find this node");
        }

        sampleT.traverseInOrder(sampleT.getRootNode());
        System.out.println();
    }
}
