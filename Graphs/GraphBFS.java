import java.util.*;

public class GraphBFS{
  Node startingNode;

  GraphBFS(int val){
    this.startingNode = new Node(val);
  }

  class Node {
    int value;
    LinkedList<Node> adjacents; // List of adjacent nodes 
    
    public Node(int value) {
        this.value = value;
        this.adjacents = new LinkedList<Node>();
    }
    
    // Adds an edge from this node to another
    public void addEdge(Node node) {
        this.adjacents.add(node);
        node.adjacents.add(this);
    }

    public void addNode(int val){
        Node newNode = new Node(val);
        addEdge(newNode);
    }

    public List<Node> getAdjacents(){
        return this.adjacents;
    }
  }

  public void BFSSearch(int val){
    Queue<Node> nodeQueue = new LinkedList<Node>();            // A queue of nodes.
    Queue<Node> tempQueue = new LinkedList<Node>();            // A second queue of nodes.
    List<Node> visitedNodes = new LinkedList<Node>();
    nodeQueue.add(this.startingNode);                          // Initializes the queue with the starting node.
    System.out.println("Path:");
    System.out.println(startingNode.value);
    visitedNodes.add(startingNode);
    if(startingNode.value == val) {
      System.out.println("Value " + val + " found at starting node.");
      return;
    }

    while(!nodeQueue.isEmpty()){                               // Runs until {nodeQueue} is empty.
        List<Node> tempList = nodeQueue.poll().getAdjacents(); // Returns the adjacent nodes of the queue's head node as a list.

        for(Node node : tempList) {tempQueue.add(node);}       // Adds all of the nodes in the list to {tempQueue}.

        Node nodeBeingCompared = tempQueue.poll();             // The node in {tempQueue} whose value is being compared to the value being searched for.
        while(nodeBeingCompared != null){                      // While {tempQueue} still has nodes to check...
        System.out.println(nodeBeingCompared.value);

            if(nodeBeingCompared.value == val) {               // If this node's value is equal to the value being searched for, return.
              System.out.println("Value " + nodeBeingCompared.value + " found.");
              return;
            }
            visitedNodes.add(nodeBeingCompared);
            tempList = nodeBeingCompared.getAdjacents();       // Otherwise, grab this node's adjacency list-
            
            for(Node node : tempList) {                        // And add them to the end of {tempQueue}.
              if(!visitedNodes.contains(node)){
                tempQueue.add(node);
              }
            }
            nodeBeingCompared = tempQueue.poll();              // Set {nodeBeingCompared} to as the next node to be run through this process.
        }
    }
    System.out.println("Value not found in the graph.");
}

  public static void main(String[] args){
    GraphBFS graph = new GraphBFS(51);
    Node startingNode = graph.new Node(491);
    Node nodeA = graph.new Node(1928474);
    Node nodeA1 = graph.new Node(-1498);
    Node nodeA2 = graph.new Node(010340);
    Node nodeB = graph.new Node(20404);
    Node nodeC = graph.new Node(13);
    Node nodeD = graph.new Node(491);
    Node nodeE = graph.new Node(1032);
    Node nodeF = graph.new Node(100);

    graph.startingNode.addEdge(nodeA);
    graph.startingNode.addEdge(nodeB);
    graph.startingNode.addEdge(nodeC);
    graph.startingNode.addEdge(nodeD);
    graph.startingNode.addEdge(nodeE);
    nodeB.addEdge(nodeF);
    nodeC.addEdge(nodeF);
    nodeA.addEdge(nodeA1);
    nodeA.addEdge(nodeA2);

    graph.BFSSearch(13);
  }
}