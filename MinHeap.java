public class MinHeap {

    private int[] heap;
    private int size;

    //constructor
    public MinHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    /**
     * insert a new element into the heap
     * @param value
     */
    public void insert(int value) {
        if (size == heap.length) { //check if the heap is full
            System.out.println("Heap is full. Cannot insert more elements.");
        }
        //if heap is not full, insert the element
        else if(size != heap.length) {
            heap[size] = value; //inserts an element into the heap
            size++; //increase the size of the heap
            heapifyUp(size - 1); //restores the heap property by upward traversal
        }
    }

    /**
     * extract the minimum element from the heap
     * @return
     */
    public int extractMin() {
        if (size == 0) { //check if the heap is empty
            System.out.println("Heap is empty. Cannot extract minimum.");
            return -1;
        }
        int min = heap[0]; //store the minimum element (root of the heap)
        heap[0] = heap[size - 1]; //move the last element in the heap to the root
        size--; //decrease the size of the heap
        heapifyDown(0); //restore the heap property by downward traversal
        return min; //returns the minimum element
    }

    /**
     * restore heap property upwards until the new value added at the end of the heap is < than it's parent
     * @param index
     */
    private void heapifyUp(int index) {
        while (index > 0 && heap[index] < heap[parent(index)]) { //check if the new value is > 0 && < than the parent
            swap(index, parent(index)); //swap the new value with the parent index if it's < than the parent
            index = parent(index); //update the new value to become the parent index
        }
    }

    /**
     * restore heap property downwards until it's > than it's children
     * @param index
     */
    private void heapifyDown(int index) {
        int smallest = index; //current node
        int left = leftChild(index); //the left child of the current node
        int right = rightChild(index); //the right child of the current node

        if (left < size && heap[left] < heap[smallest]) { //if the left child of the current node is < size && the index of the left child of the current node is < than the smallest index in the heap
            smallest = left; //update the smallest index to the left child index of the current node
        }
        if (right < size && heap[right] < heap[smallest]) { //if the right child index of the current node is < size && the index of the right child of the current node is < than the smallest index in the heap
            smallest = right; //update the smallest index to the right child of the current node
        }

        if (smallest != index) { //if the smallest index is not equal to the current node
            swap(index, smallest); //swap the current node with the smallest index
            heapifyDown(smallest); // call the heapifyDown method with the smallest index
        }
    }

    //calculations to find the parent, left child, and right child indices

    private int parent(int childIndex) {
        return (childIndex - 1) / 2; //returns the parent index
    }

    private int leftChild(int parentIndex) {
        return 2 * parentIndex + 1; //returns the left child index
    }

    private int rightChild(int parentIndex) {
        return 2 * parentIndex + 2; //returns the right child index
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
