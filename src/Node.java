public class Node {

    private int data;
    private Node link;
    private static int counter;

    /**
     * Simple constructor for a node.
     * @param initialData the value or data inside the node
     * @param initialLink the link to the next node
     */

    public Node(int initialData, Node initialLink){
        data = initialData;
        link = initialLink;
    }

    /**
     * A getter for a node's data.
     * @return the data of that node
     */

    public int getData(){
        return data;
    }

    /**
     * A getter for a node's link.
     * @return the link of that node
     */

    public Node getLink(){
        return link;
    }

    /**
     * A setter for a node's link.
     * @param newLink the new link to another node
     */

    public void setLink(Node newLink){
        link = newLink;
    }

    /**
     * Simple method that adds a node after a given node.
     * @param data the data or value to be put in that node.
     */

    public void addNodeAfter(int data){
        link = new Node(data, link);
    }

    /**
     * A recursive toString method for linked lists that returns the node number and its contents.
     * @return returns a String that will contain no more than 20 entries.
     */

    public String toStringRecurse() {
        String field1;
        String field2;
        String field3;
        if(counter > 20) {
            return "Over 20 recursive calls, ending the loop.";
        }else{
            field1 = "Node" + Integer.toString(counter) + ": ";
            field2 = Integer.toString(data);
        }
        ++counter;
        if(link == null) {
            field3 = "null in tail";
        }else {
            field3 = link.toStringRecurse();
        }
        counter = 0;
        return field1 + "    " + field2 + "\n" + field3;
    }

}
