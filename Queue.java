public class Queue {
    private Node front;
    private Node back;

    //creating an inner Node class for Queue
    private static class Node {
        Object item; //the item stored in the node
        Node next; //reference to the next node

        //constructor for Node class
        Node(Object item) {
            this.item = item; //initialize the item
            this.next = null; //next is initially null
        }
    }

    //creating consutructor for Queue, setting the back and front to null (empty)
    public Queue(){
        this.front = null;
        this.back = null;
    }

    /**
     * enqueues an item to an item to the back of the queue
     * @param item
     */
    public void enqueue(Object item) {
        Node newNode = new Node(item); //creating a new node item
        if (front == null) { //if the front is null, set the front to the new node
            front = newNode;
        }
        if (back != null) { //if the back is not null, set the back node to the new node
            back.next = newNode;
        }
        back = newNode;
    }

    /**
     * dequeues the first item in the queue (FIFO)
     * @return
     */
    public Object dequeue() {
        Object toReturn = null; //the dequeued item to be returned
        if (front != null) { //if the front is not null then dequeue
            toReturn = front.item; //store the item that is in the front, in the toReturn variable
            front = front.next; //set the front to the next node
        }
        if (front == null) { //if the front is null then set the back to null
            back = null;
        }
        return toReturn;
    }

    public void display(){
        Node current = front;  //using a pointer to point to the front of the queue
        while(current != null){
            System.out.print(current.item + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}


