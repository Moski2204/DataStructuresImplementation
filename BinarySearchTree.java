public class BinarySearchTree {

    public BinarySearchTree left;
    public Integer key;
    public BinarySearchTree right;

    //constructor, to create an empty BST
    public BinarySearchTree() {
        this.key = null;
        this.left = null;
        this.right = null;
    }

    //constructor to create a new node, to be able to insert new keys into the tree
    public BinarySearchTree(int node) {
        this.key = node;
        this.left = null;
        this.right = null;
    }

    /**
     * insert new keys into the BST
     * @param key
     */
    public void insert(int key) {
        if (this.key == null) { //if the current key is null (tree is empty)
            this.key = key; //insert a root key into the BST
            this.left = null; //initialize the left child to null
            this.right = null; //initialize the right child to null
        }
        else if (key < this.key) {  //if the subsequent key is less than the root key
            if (this.left == null) {
                this.left = new BinarySearchTree(key); //create and insert the new subsequent key in the left child of the root key
            }
            else {
                this.left.insert(key); //recursively insert the key on the left child node
            }
        }
        else if (key > this.key) {  //if the subsequent key is greater than the root key
            if (this.right == null) {
                this.right = new BinarySearchTree(key); //create and insert the subsequent key in the right child of the root key
            }
            else {
                this.right.insert(key); //recursively insert the key on the right child node
            }
        }
    }

    /**
     * Delete a key from the tree
     * @param key
     * @return
     */
    public BinarySearchTree delete(int key) {
        if (this.key == null) { //checks if the tree is empty
            return null;
        }
        else if (key < this.key) { //if the key to be deleted is less than the root key
            if (this.left != null) {
                this.left = this.left.delete(key); //recursively calling the delete method on the left child
            }
        }
        else if (key > this.key) { //if the key to be deleted is greater than the root key
            if (this.right != null) {
                this.right = this.right.delete(key); //recursively calling the delete method on the right child
            }
        }
        //if the key to be deleted is equal to the root key
        else if (key == this.key) {
            if (this.left == null) {
                return this.right; //if the left child is null, then return the right child
            }
            else if (this.right == null) {
                return this.left; //if the right child is null, then return the left child
            }
            //if the left and right children are not null
            else {
                BinarySearchTree root = this; //root is the root node
                BinarySearchTree rootChild = this.right; //rootChild the right child of the root node

                while (rootChild.left != null) {
                    root = rootChild;
                    rootChild = rootChild.left;
                }
                if (root != this) {
                    root.left = rootChild.right;
                }
                else {
                    root.right = rootChild.right;
                }
                this.key = rootChild.key;
            }
        }
        return this;
    }

    /**
     * Find a key from the tree
     * @param root
     * @param searchKey
     * @return
     */
    public static BinarySearchTree find(BinarySearchTree root, int searchKey) {
        BinarySearchTree current = root; //the root key
        while (current != null && current.key != searchKey) {
            if (current.key > searchKey){ //if the root key is greater than the key to be searched
                current = current.left; //the left child of the root key becomes the new root key
            }
            else {
                current = current.right; //the right child of the root key becomes the new root key
            }
        }
        return current; //return the found node or null if the key is not found
    }

    //inorder Traversal
    public void inOrder() {
        printTree(this);
        System.out.println(); //move to the next line after printing the tree
    }

    /**
     * helper method to print the tree in in-order traversal
     * @param node
     */
    private void printTree(BinarySearchTree node) {
        if (node != null) {
            if (node.left != null) {
                printTree(node.left);
                System.out.print(" -> "); //print arrow after left child
            }

            if (node.right != null) {
                printTree(node.right);
                System.out.print(" -> "); //print arrow before right child
            }
            System.out.print(node.key); //print the current node keyy
        }
    }
}