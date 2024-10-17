public class BinarySearchTree {
    private Node root; // Root node of the BST

    // Inner class to define the structure of a Node in the BST
    private class Node {
        int data; // Value stored in the node
        Node left, right; // Pointers to the left and right child nodes

        // Constructor to create a new node with a given value
        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    // Method to insert a new value into the BST
    public void insert(int value){
        // If the tree is empty, create a new root node
        if(root == null) {root = new Node(value);}
        else {
            // Otherwise, call the recursive method to insert the new value in the correct position
            insertNode(root, value);
        }
    }

    // Recursive method to insert a new value starting from a given node
    public Node insertNode(Node node, int value){
        // If the current node is null, we've found the correct position for the new value
        if(node == null){
            node = new Node(value);
            return node;
        }
        // If the new value is less than the current node's value, go left
        if(value < node.data) {node.left = insertNode(node.left, value);}
        // If the new value is greater or equal, go right
        else if(value >= node.data) {node.right = insertNode(node.right, value);}

        return node; // Return the node after insertion
    }

    // Wrapper method for searching a value in the BST
    public Node search(int value){
        // Call the recursive search method starting from the root
        return searchNodeRecursive(root, value);
    }

    // Method to search for a value using loops (this has a logical error in its implementation)
    public Node searchNodeLoop(int value){
        Node currentNode = root;
        while(currentNode != null){
            if(value == currentNode.data) {return currentNode = currentNode.left;}
            else if(value < currentNode.data) {return currentNode = currentNode.right;}
        }
        return null; // Return null if the value is not found
    }

    // Recursive method to search for a value starting from a given node
    public Node searchNodeRecursive(Node node, int value){
        // Base case: if node is null or value matches the node's data
        if(node == null || value == node.data) {return node;}
        // If the value is less than the node's data, search in the left subtree
        else if(value < node.data) {return searchNodeRecursive(node.left, value);}
        // If the value is greater, search in the right subtree
        else if(value > node.data) {return searchNodeRecursive(node.right, value);}
        return node; // This line is actually redundant due to the return statements in the conditions above
    }

    // Main method to demonstrate the functionality of the BST
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);

        // Demonstrate searching for a value and printing its data
        System.out.println(bst.search(30).data);
        // System.out.println("Is 30 in the tree? " +
        // bst.search(30));
    }
}