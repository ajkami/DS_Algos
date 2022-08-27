public class Stack {
    private static class Node {
        private int data;
        private Node next;
        private Node(int data) {
            this.data = data;
        }
    }

    private Node top; // Dont need a head and tail since we just remove the last element added

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        return top.data; // returning the top plate of the stack
    }

    public void push(int data) { // adding a new plate on top of the stack
        Node node = new Node(data); // this node is being added so will become the new top
        node.next = top; // pushing the top down one space (adding a new plate on top)
        top = node; // making the node the new top
    }

    public int pop() { // taking a plate off of the stack
        int data = top.data; // getting the data of the head
        top = top.next; // making the new top the element one below the top (second plate is now the top)
        return data;
    }
}
