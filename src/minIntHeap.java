import java.util.Arrays;
import java.util.LinkedList;

public class minIntHeap {
    LinkedList[] data;
    private int capacity = 10; // capacity of the heap (array)
    private int size = 0; // current size of the array

    int[] items = new int[capacity];

    // These methods get the index of the requested nodes
    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    // These methods tell you if a node exists
    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    // These methods give you the value of the requested nodes
    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0]; // returns root if there is something there
    }



    public int poll () { // extracts the min element from the array (root)
        int item = items[0]; // making our root the item since we want to get it
        items[0] = items[size - 1]; // replacing the old root node with the recently added value
        size--; // Lowering our size variable because our array is now 1 element smaller
        heapifyDown(); // bubbling down the element
        return item;
    }

    public void add(int item) {
        ensureExtraCapacity(); // making sure array has enough space
        items[size] = item; // adding new item to the last spot of the array
        size++; // increasing size variable as one more element has been added
        heapifyUp(); // bubbling up the new element
    }

    public void heapifyUp() {
        int index = size - 1; // starts at the last item in the list
        while (hasParent(index) && parent(index) > items[index]) { // while the node has a parent and is smaller than its parent
            swap(getParentIndex(index), index); // swap the element and its parent (so smaller number is now higher)
            index = getParentIndex(index); // now make the new index the index of the parent (to keep bubbling up)
        }
    }

    public void heapifyDown() {
        int index = 0; // index will be the root
        while (hasLeftChild(index)) { // only check for left child b/c if theres no left child there is no right
            int smallerChildIndex = getLeftChildIndex(index); // make the smaller child index the left one
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) { // if there is a right child and then right child is smaller than the left
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]) { // if the value is now smaller than the smaller child then everything is good so break
                break;
            } else {
                swap(index, smallerChildIndex); // swap node with its smaller child
                index = smallerChildIndex; // then declare new index as the smaller child
            }

        }
    }

}


