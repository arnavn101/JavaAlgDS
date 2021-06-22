package DataStructures;

public class DoublyLinkedList {
    private Link firstLink;
    private Link lastLink;

    public DoublyLinkedList(){
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
        else{
            firstLink.previousLink = newLink;
        }

        newLink.nextLink = firstLink;
        firstLink = newLink;
    }

    public void insertLast(int iD, double dD){
        Link newLink = new Link(iD, dD);

        if (isEmpty()){
            lastLink = newLink;
        }
        else{
            lastLink.nextLink = newLink;
            newLink.previousLink = lastLink;
        }

        lastLink = newLink;
    }

    public Link deleteFirst(){
        if (isEmpty()){
            return null;
        }
        Link tempThis = firstLink;

        if(firstLink.nextLink == null){
            lastLink = null;
        }
        else{
            firstLink.nextLink.previousLink = null;
        }

        firstLink = firstLink.nextLink;
        return tempThis;
    }

    public Link deleteLast(){
        if (isEmpty()){
            return null;
        }
        Link tempThis = lastLink;

        if(lastLink.previousLink== null){
            firstLink = null;
        }
        else{
            lastLink.previousLink.nextLink = null;
        }
        
        lastLink = lastLink.previousLink;
        return tempThis;
    }

    public boolean insertAfter(int key, int iD, double dD){
        Link currentLink = firstLink;
        while(currentLink.iData != key){
            currentLink = currentLink.nextLink;
            if (currentLink == null){
                return false;
            }
        }
        Link newLink = new Link(iD, dD);

        if (currentLink == lastLink){
            newLink.nextLink = null;
            lastLink = newLink;
        }
        else{
            newLink.nextLink = currentLink.nextLink;
            currentLink.nextLink.previousLink = newLink;
        }

        newLink.previousLink = currentLink;
        currentLink.nextLink = newLink;
        return true;
    }

    public Link delete(int key){
        Link currentLink = firstLink;
        while(currentLink.iData != key){
            currentLink = currentLink.nextLink;
            if (currentLink == null){
                return null;
            }
        }

        if(currentLink == firstLink){
            firstLink = currentLink.nextLink;
        }
        else{
            currentLink.previousLink.nextLink = currentLink.nextLink;
        }

        if(currentLink == lastLink){
            lastLink = currentLink.previousLink;
        }
        else{
            currentLink.nextLink.previousLink = currentLink.previousLink;
        }
        return currentLink;
    }

    public void displayForward(){
        System.out.println("List (first to last):");
        Link currentLink = firstLink;

        while(currentLink != null){
            currentLink.displayLink();
            currentLink = currentLink.nextLink;
        }
    }

    public void displayBackward(){
        System.out.println("List (last to first):");
        Link currentLink = lastLink;

        while(currentLink != null){
            currentLink.displayLink();
            currentLink = currentLink.previousLink;
        }
    }

}
