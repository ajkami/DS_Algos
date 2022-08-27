public class Queue {
    private static class Node {
        private int data;
        private Node next;
        private Node(int data) {
            this.data = data;
        }
    }
    private Node head; // remove from the head (front of line)
    private Node tail; // add things here (end of line)

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        return head.data;
    }

    public void add(int data) {
        Node node = new Node(data);

        if (tail != null) {
            tail.next = node; // if the tail has data then add our new node to the end of the Queue (end of the line)
        }

        tail = node; // we then make our new node the tail (node is now the new end of the line)

        if (head == null) {
            head = node; // if the head is empty then we make our node the new head (front of the line)
        }
    }

    public int remove() { // will remove the head of the list (person at the front of the line is getting in)
        int data = head.data;
        head = head.next; // making the new head the thing before it in line
        if (head == null) {
            tail = null; // if the head is now null then the whole list is empty so make tail null as well
        }
        return data;
    }
}
