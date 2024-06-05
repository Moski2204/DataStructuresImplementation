public class LinkedList {

    private Node head;

    //constructor to initialize the LinkedList head to null
    public LinkedList(){
        head = null;
    }

    /**
     * Insertion Method
     * @param newNode
     */
    public void insertAfter(Node newNode){
        if (head == null){
            head = newNode; //if the list is empty, the new node will be the head
        }
        else {
            Node current = head;
            while (current.next != null){
                current = current.next; //traverse to the end of the list
            }
            current.next = newNode; //insert the new node at the end of the list
        }
    }

    /**
     * method for removing a specific key
     * @param key
     */
    public void deletion(int key) {
        if (head == null) {
            return; //list is empty
        }
        else if(head.data == key) {
            head = head.next;
            return; //remove the head node
        }
        Node current = head; //to be able to traverse the list
        while (current.next != null && current.next.data != key) {
            current = current.next; //traverse the list
        }
        if (current.next != null && current.next.data == key) {
            current.next = current.next.next; //removes the node to be deleted from the list
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(" -> null");
    }
}
