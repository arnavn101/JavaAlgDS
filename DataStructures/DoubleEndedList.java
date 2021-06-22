package DataStructures;

public class DoubleEndedList {
    private Link firstLink;
    private Link lastLink;

    public DoubleEndedList(){
        firstLink = null;
        lastLink = null;
    }

    public boolean isEmpty(){
        return firstLink == null;
    }

    public void insertFirst(int iD, double dD){
        Link newLink = new Link(iD, dD);

        if (isEmpty()){
            lastLink = newLink;
        }

        newLink.nextLink = firstLink; // Connect newLink to previous links
        firstLink = newLink; // Define first link as the inserted newLink
    }
    
    public void insertLast(int iD, double dD){
        Link newLink = new Link(iD, dD);

        if (isEmpty()){
            firstLink = newLink;
        }
        else{
            lastLink.nextLink = newLink; // Connect lastLink to newLink
        }
        
        lastLink = newLink; // Define last link as the inserted newLink
    }

    public Link deleteFirst(){
        if(firstLink.nextLink == null){
            lastLink = null;
        }
        firstLink = firstLink.nextLink;
        return firstLink;
    }

    public void displayList(){
        System.out.println("List (first to last):");
        Link currentLink = firstLink;

        while(currentLink != null){
            currentLink.displayLink();
            currentLink = currentLink.nextLink;
        }
    }

}
