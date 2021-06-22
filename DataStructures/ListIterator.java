package DataStructures;

public class ListIterator {
    private Link currentLink;
    private Link previousLink;
    private LinkedList thisList;

    public ListIterator(LinkedList lList){
        thisList = lList;
        reset();
    }

    public void reset(){
        currentLink = thisList.getFirst();
        previousLink = null;
    }

    public boolean atEnd(){
        return currentLink.nextLink == null;
    }

    public void nextLink(){
        previousLink = currentLink;
        currentLink = currentLink.nextLink;
    }

    public Link getCurrent(){
        return currentLink;
    }

    public void insertAfter(int key, double val){
        Link newLink = new Link(key, val);

        if(thisList.isEmpty()){
            thisList.setFirst(newLink);
            currentLink = newLink;
        }
        else{
            newLink.nextLink = currentLink.nextLink;
            currentLink.nextLink = newLink;
            nextLink();
        }
    }

    public void insertBefore(int key, double val){
        Link newLink = new Link(key, val);

        if(previousLink == null){
            newLink.nextLink = thisList.getFirst();
            thisList.setFirst(newLink);
            reset();
        }
        else{
            newLink.nextLink = previousLink.nextLink;
            previousLink.nextLink = newLink;
            currentLink = newLink;
        }
    }

    public Link deleteCurrent(){
        Link toBeRem = currentLink;
        if(previousLink == null){
            thisList.setFirst(currentLink.nextLink);
            reset();
        }
        else{
            previousLink.nextLink = currentLink.nextLink;
            if(atEnd()){
                reset();
            }
            else{
                currentLink = currentLink.nextLink;
            }
        }
        return toBeRem;
    }

}
