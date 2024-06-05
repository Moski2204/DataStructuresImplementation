import java.util.Scanner;


public class ProjectMain {

    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {

        //instantiating the data structures

        LinkedList list = new LinkedList();

        Stack stack = new Stack();

        Queue queue = new Queue();

        MinHeap minHeap = new MinHeap(100);

        BinarySearchTree BST = new BinarySearchTree();

        Scanner scan = new Scanner(System.in);
        System.out.println("Program: Please select the data structure you want to work with: ");

        //if user enters 1,2,3,4 or 5 the program will continue, if not the user will have to re-enter again.
        String input;
        while (true) {
            System.out.println("Enter 1 for Linked List");
            System.out.println("Enter 2 for Stack");
            System.out.println("Enter 3 for Queue");
            System.out.println("Enter 4 for Min Heap");
            System.out.println("Enter 5 for Binary Search Tree (BST)");
            input = scan.nextLine();
            if (input.equals("1")) {
                System.out.println("You've selected: Linked List");
                break; //end the while loop if user enters "1"
            }
            if (input.equals("2")) {
                System.out.println("You've selected Stack.");
                break; //end the while loop if user enters "2"
            }
            if (input.equals("3")) {
                System.out.println("You've selected Queue.");
                break; //end the while loop if user enters "3"
            }
            if (input.equals("4")) {
                System.out.println("You've selected Min Heap");
                break; //end the while loop if user enters "4"
            }
            if (input.equals("5")) {
                System.out.println("You've selected Binary Search Tree (BST)");
                break; //end the while loop if user enters "5"
            }
            else {
                System.out.println();
                System.out.println("Invalid input, please try again.");
            }
        }

        //Linked List
        if (input.equals("1")) {
            while (true) {
                System.out.println();
                System.out.println("What do you want to do with the Linked list?");
                System.out.println("1. Add Data");
                System.out.println("2. Remove Data");
                System.out.println("3. Display Linked List");
                System.out.println("4. Exit");
                System.out.println();
                System.out.print("Enter your choice (1/2/3/4): ");
                input = scan.nextLine();
                switch (input) {
                    case "1":
                        System.out.print("Enter the data to add to the Linked List (-1 to end) ");
                        int inputData = Integer.parseInt(scan.nextLine());
                        while (inputData != -1) {
                            //create a new node with the input data
                            Node newNode = new Node(inputData);
                            list.insertAfter(newNode); //insert the new node into the linked list
                            System.out.print("Enter the data to add to the Linked List (-1 to end) ");
                            inputData = Integer.parseInt(scan.nextLine());
                        }
                        break;
                    case "2":
                        while (true) {
                            System.out.print("Enter the data to remove from the linked list (-1 to end): ");
                            int key = Integer.parseInt(scan.nextLine());
                            if (key == -1) {
                                break;
                            }
                            list.deletion(key);
                        }
                    case "3":
                        System.out.println();
                        System.out.println("Your Linked List looks like this: ");
                        list.display();
                        break;

                    case "4":
                        System.out.println("You've exited the program.");
                        return; //exit the program
                    default:
                        System.out.println();
                        System.out.println("Invalid choice. Please enter a valid option (1-4  ).");
                        break;
                }
            }
        }

        //Stack
        if (input.equals("2")) {
            while (true) {
                System.out.println();
                System.out.println("What do you want to do with the Stack?");
                System.out.println("1. Push Element");
                System.out.println("2. Pop Element");
                System.out.println("3. Top Element");
                System.out.println("4. Display Stack");
                System.out.println("5. Exit");
                System.out.println();
                System.out.println("Enter your choice (1/2/3/4/5): ");
                input = scan.nextLine();
                System.out.println();
                switch (input) {
                    case "1":
                        System.out.print("Enter the data to push onto the Stack (-1 to end) ");
                        int inputData = Integer.parseInt(scan.nextLine());
                        while (inputData != -1) {
                            stack.push(inputData);
                            System.out.print("Enter the data to push onto the Stack (-1 to end) ");
                            inputData = Integer.parseInt(scan.nextLine());
                        }
                        break;
                    case "2":
                        int error = stack.pop();
                        if(error == -1){
                            System.out.println("Checking if this works");
                        }
                        else {
                            System.out.println("Popped element: " + stack.pop());
                        }
                        break;
                    case "3":
                        System.out.println("Top element: " + stack.top());
                        break;
                    case "4":
                        System.out.println();
                        stack.display();
                        break;
                    case "5":
                        System.out.println("You've exited the program!");
                        return; //exit the program
                    default:
                        System.out.println();
                        System.out.println("Invalid choice. Please enter a valid option (1-5).");
                        break;
                }
            }
        }

        //Queue
        if (input.equals("3")) {
            while (true) {
                System.out.println();
                System.out.println("What do you want to do with the Queue? ");
                System.out.println("1. Enqueue");
                System.out.println("2. Denqueue");
                System.out.println("3. Display Queue");
                System.out.println("4. Exit");
                System.out.println();
                System.out.print("Enter your choice (1/2/3/4): ");
                input = scan.nextLine();
                System.out.println();
                switch (input) {
                    case "1":
                        System.out.print("Enter the data to enqueue (-1 to end) ");
                        int inputData = Integer.parseInt(scan.nextLine());
                        while (inputData != -1) {
                            queue.enqueue(inputData);
                            System.out.print("Enter the data to enqueue (-1 to end) ");
                            inputData = Integer.parseInt(scan.nextLine());
                        }
                        break;
                    case "2":
                        System.out.println("Dequeled element: " + queue.dequeue());
                        break;
                    case "3":
                        System.out.println();
                        queue.display();
                        break;
                    case "4":
                        System.out.println("You've exited the program!");
                        return; //exit the program
                    default:
                        System.out.println();
                        System.out.println("Invalid choice. Please enter a valid option (1-4).");
                        break;
                }
            }
        }

        //Min Heap
        if (input.equals("4")) {
            while (true) {
                System.out.println();
                System.out.println("What do you want to do with the Min Heap?");
                System.out.println("1. Insert");
                System.out.println("2. ExtractMin");
                System.out.println("3. Exit");
                System.out.println();
                System.out.println("Enter your choice (1/2/3): ");
                input = scan.nextLine();

                switch (input) {
                    case "1":
                        System.out.print("Enter the key to insert into the Min Heap (-1 to end): ");
                        int inputKey = Integer.parseInt(scan.nextLine());
                        while (inputKey != -1) {
                            minHeap.insert(inputKey);
                            System.out.print("Enter the key to insert into the Min Heap (-1 to end): ");
                            inputKey = Integer.parseInt(scan.nextLine());
                        }
                        break;
                    case "2":
                        System.out.println();
                        System.out.println("Min element extracted: " + minHeap.extractMin());
                        break;
                    case "3":
                        System.out.println("You've exited the program!");
                        return; //exit the program
                    default:
                        System.out.println();
                        System.out.println("Invalid choice. Please enter a valid option (1-3).");
                        break;
                }
            }
        }

        //BST
        if (input.equals("5")) {
            while (true) {
                System.out.println();
                System.out.println("What do you want to do with the BST?");
                System.out.println("1. Insert Node");
                System.out.println("2. Delete Node");
                System.out.println("3. Find Node");
                System.out.println("4. Inorder Traversal");
                System.out.println("5. Exit");

                System.out.println();

                System.out.print("Enter your choice (1/2/3/4/5): ");
                input = scan.nextLine();

                switch (input) {
                    case "1":
                        System.out.print("Enter the key to insert into the BST (-1 to end): ");
                        int inputKey = Integer.parseInt(scan.nextLine());
                        while (inputKey != -1) {
                            BST.insert(inputKey); 
                            System.out.print("Enter the key to insert into the BST (-1 to end): ");
                            inputKey = Integer.parseInt(scan.nextLine());
                        }
                        break;
                    case "2":
                        System.out.print("Enter the key to delete from the BST (-1 to end): ");
                        int keyDelete = Integer.parseInt(scan.nextLine());
                        while (keyDelete != -1) {
                            BST = BST.delete(keyDelete);
                            System.out.print("Enter the key to delete from the BST (-1 to end): ");
                            keyDelete = Integer.parseInt(scan.nextLine());
                        }
                        break;
                    case "3":
                        System.out.print("Enter the key to find in the BST: ");
                        int keyToFind = Integer.parseInt(scan.nextLine());
                        BinarySearchTree foundNode = BST.find(BST, keyToFind);
                        if (foundNode != null) {
                            System.out.println("Node found in the BST");
                        }
                        else {
                            System.out.println("Node NOT found in the BST");
                        }
                        break;
                    case "4":
                        System.out.println();
                        System.out.println("Inorder Traversal of the BST: ");
                        BST.inOrder();
                        break;
                    case "5":
                        System.out.println();
                        System.out.println("You've exited the program!");
                        return; //exit the program
                    default:
                        System.out.println();
                        System.out.println("Invalid choice. Please enter a valid option (1-5).");
                        break;
                }
            }
        }
    }
}