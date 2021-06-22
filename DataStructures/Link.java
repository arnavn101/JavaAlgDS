package DataStructures;

public class Link {
    public int iData; // key
    public double dData; // value
    public Link nextLink; // Reference to the next link in the list
    public Link previousLink; // Reference to the previous link in the list

    public Link(int iD, double dD){
        iData = iD;
        dData = dD;
    }

    public void displayLink(){
        System.out.println("{" + iData + ", " + dData + "} ");
    }
}
