class Node { // Binary search tree
    Node left,right;
    int data; // the data of the current node
    public Node(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) { // If new value is lower than the node insert on the left side
            if (left == null) { // if there is no node to the left of the parent
                left = new Node(value); // make our value the new node to the left
            }else {
                left.insert(value); // using recursion to then use this method on the left node
            }
        }else {
            if (right == null) { // if there is no node to the right of the parent
                right = new Node(value); // make our value the new node to the right
            } else {
                right.insert(value); //using recursion to then use this method on the right node
            }
        }
    }

    public boolean contains(int value) {
        if (value == data) { // if our current node is the value then our tree contains it
            return true;
        } else if (value < data) { // if our value is less than the node
            if (left == null) { // if the left child does not exist return false (value does not exist in the tree)
                return false;
            } else { // If there is a left child then use recursion to check again for the left child
                return left.contains(value);
            }
        } else { // if our value is greater than the node
            if (right == null) { // if the left child does not exist return false (value does not exist in the tree)
                return false;
            } else { // If there is a right child then use recursion to check again for the right child
                return right.contains(value);
            }
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder(); // recursively using print function on left child
        }
        System.out.println(data); // printing parent node

        if (right != null) {
            right.printInOrder(); // recursively using print function on right child
        }
    }
}