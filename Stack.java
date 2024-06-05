public class Stack {

    private Node top; //a pointer to the top of the stack

    /**
     * method to push an element onto the stack
     * @param x
     */
    public void push(int x) {
        Node temp = new Node(x); //create a new node with the data value x
        temp.next = top; //points the new node with the data value x to the previous node which was at top of the stack
        top = temp; //updates the top reference to point to the new node, making it the new top of the stack
    }

    /**
     * method to pop the top element from the stack
     * @return
     */
    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1; //returns -1 to indicate an empty stack
        }
        else {
            int data = top.data; //data is holding the value of the top node
            top = top.next; //top is updated, and points to the next node
            return data; //return the popped value
        }
    }

    /**
     * method to get the top element of the stack
     * @return
     */
    public int top() {
        if (top == null) {
            System.out.println("There is no top element in the stack");
            return -1; //returns -1 to indicate an empty stack
        }
        else {
            return top.data; //return the data value at the top of the stack
        }
    }

    public void display(){
        Node current = top; //using a pointer to point to the top of the stack
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
