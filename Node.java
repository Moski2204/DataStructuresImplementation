public class Node {

    public int data; //will store the value of the node
    public Node next; //will store the address of the next node

    /**
     * Node method
     * @param data
     */
    //constructor for the node class that will initialize the data and the next node
    public Node(int data) {
        this.data = data; //the data for the node
        this.next = null; //sets the next address to null
    }
}
