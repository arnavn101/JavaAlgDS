package DataStructures;

public class LinkedList {
    private Link firstLink; // Reference to the first link in the list
    
    public void LinkList(){
        firstLink = null; // No items in the list
    }

    public boolean isEmpty(){
        return firstLink == null;
    }

    public Link getFirst(){
        return firstLink;
    }

    public void setFirst(Link fSet){
        firstLink = fSet;
    }

    public ListIterator getIterator(){
        return new ListIterator(this);
    }

    public void insertFirst(int iD, double dD){
        Link newLink = new Link(iD, dD);
        newLink.nextLink = firstLink; // Connect newLink to previous links
        firstLink = newLink; // Define first link as the inserted newLink
    }

    // Insert element according to priority of the key (sorted list - ascending)
    public void insertPriority(int iKey, double dValue){
        Link thisLink = new Link(iKey, dValue);
        Link currentLink = firstLink;
        Link previousLink = null;

        while(currentLink != null && iKey > currentLink.iData){
            previousLink = currentLink;
            currentLink = currentLink.nextLink;
        }

        if(previousLink == null){
            firstLink = thisLink;
        }
        else{
            previousLink.nextLink = thisLink;
        }
        thisLink.nextLink = currentLink;
    }

    public Link find(int key){
        Link currentLink = firstLink;
        while(currentLink.iData != key){
            if(currentLink.nextLink == null){
                return null;
            }
            currentLink = currentLink.nextLink;
        }
        return currentLink;
    }

    public Link delete(int key){
        Link currentLink = firstLink;
        Link previousLink = firstLink;

        while(currentLink.iData != key){
            if(currentLink.nextLink == null){
                return null;
            }
            previousLink = currentLink;
            currentLink = currentLink.nextLink;
        }

        if(currentLink == firstLink){
            firstLink = firstLink.nextLink; // Remove firstLink from the chain
        }
        else{
            previousLink.nextLink = currentLink.nextLink; // Remove currentLink from the chain
        }

        return currentLink;
    }


    public Link deleteFirst(){
        Link tempThis = firstLink; // store the first link
        firstLink = firstLink.nextLink; // Change the first link to its subsequent
        return tempThis;
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
