public class CustomLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;
    private int count = 0;

    private class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }

        //--------------------------//
        // Getters & Setters: Node  //
        //--------------------------//
        public int getData() {return this.data;}
        public Node getNext() {return this.next;}
        public void setNext(Node next) {this.next = next;}
    }
    
    // YOUR CODE HERE
    public int addFirst(int data){
        if(getSize() == 0) {initializeList(data);} 
        else{
            Node newHead = new Node(data);        // Creates a new node.
            newHead.setNext(head);                // Sets the new node's {next} node to the current head node.
            head = newHead;                       // Sets {head} to now point to the {newHead} node.
            setSize(getSize() + 1);               // Increases the size counter of the {CustomLinkedList}.
        }
        return head.getData();                    // Returns the {head} of the list.
    }

    public int addLast(int data){
        if(getSize() == 0) {initializeList(data);}
        else{
            Node newTail = new Node(data);        // Creates a new node.
            tail.setNext(newTail);                // Sets the new node's {next} node to the current head node.
            tail = newTail;                       // Sets {head} to now point to the {newHead} node.
            size += 1;                            // Increases the size counter of the {CustomLinkedList}.
        }
        return tail.getData();                    // Returns the {head} of the list.
    }

    public void addAtIndex(int data, int index){
        if(getSize() == 0) {initializeList(data);} 
        else{
            Node newNode = new Node(data);
            newNode.setNext(getNode(index));
            getNode(index - 1).setNext(newNode);
            size += 1;
        }
    }

    public void removeAtIndex(int index){
        if(index == 0) {head = head.getNext();}
        else if(index == getSize() - 1) {tail = getNode(getSize() - 1);}
        if(getSize() != 0 && index != getSize() - 1){
            getNode(index - 1).setNext(getNode(index + 1));
            size -= 1;
        } 
    }

    public Node getNode(int index){
        Node currentNode = head;
        for(int i = 0; i < index; i++) {currentNode = currentNode.getNext();}
        return currentNode;
    }

    //-------------------------------------//
    // Utility Functions: CustomLinkedList //
    //-------------------------------------//

    public void initializeList(int data){
        head = new Node(data);              // If the {CustomizedLinkedList} is empty, {data} is assigned to the {headNode}.
        tail = head;
        size += 1;
    }

    public int checkIfWithinBounds(int index, int upperBound){     // Adjusts the passed in index if it is beyond the bounds of the list.
        if(index > upperBound) {return upperBound;}                // If {index} > {upperBound}, {index} will be set to {upperBound.}
        else if(index < 0) {return 0;}                             // If {index} < 0, {index} will be set to 0.
        return index;                                              // If {index} is within the bounds of the array, just return the index.
    }
    
    //--------------------------------------//
    // Getters & Setteers: CustomLinkedList //
    //--------------------------------------//
    public Node getHeadNode() {return this.head;}
    public int getSize() {return this.size;}
    public void setSize(int size) {this.size = size;}

    // Method for demonstration purposes
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.addFirst(1);
        list.addFirst(4);
        list.addFirst(6);
        list.addFirst(911);
        list.addFirst(2);
        list.addLast(15);

        list.addAtIndex(17, 3);
        list.addAtIndex(319, 1);

        list.removeAtIndex(7);
        list.removeAtIndex(0);
        list.removeAtIndex(6);

        System.out.print("[");
        for(int i = 0; i < list.getSize(); i++){
            System.out.print(list.getNode(i).getData());
            if(i < list.getSize() - 1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
