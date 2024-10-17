import java.util.*;

public class GraphD {
    Node startingNode;

    public GraphD(String string) {
        this.startingNode = new Node(string);
    }

    class Node {
        String string;
        LinkedList<Edge> adjacents;
        int distance = Integer.MAX_VALUE;

        public Node(String string) {
            this.string = string;
            this.adjacents = new LinkedList<>();
        }

        // Adds an edge from this node to another
        public void addEdge(Node node, int weight) {
            this.adjacents.add(new Edge(this, node, weight));
            node.adjacents.add(new Edge(node, this, weight));
        }

        public List<Edge> getAdjacents() {
            return this.adjacents;
        }
    }

    class Edge {
        int weight;
        Node sourceNode;
        Node destNode;

        public Edge(Node sourceNode, Node destNode, int weight) {
            this.weight = weight;
            this.sourceNode = sourceNode;
            this.destNode = destNode;
        }
    }

    public void Dijkstra(Node startingNode) {
        startingNode.distance = 0;
        PriorityQueue<Node> nodesToVisit = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
        nodesToVisit.add(startingNode);

        while (!nodesToVisit.isEmpty()) {
            Node currentNode = nodesToVisit.poll();

            for (Edge edge : currentNode.getAdjacents()){
                Node adjacentNode = edge.destNode;
                int newDistance = currentNode.distance + edge.weight;

                if (newDistance < adjacentNode.distance) {
                    adjacentNode.distance = newDistance;
                    nodesToVisit.add(adjacentNode);
                }
            }
        }
    }

    public void distanceBetweenNodes(Node node1, Node node2){
      this.Dijkstra(node1);
      System.out.printf("The shortest distance from %s to %s is %d", node1.string, node2.string, node2.distance);
    }

    public static void main(String[] args) {
        GraphD graph = new GraphD("S");
        Node startingNode = graph.startingNode;
        Node nodeA = graph.new Node("A");
        Node nodeB = graph.new Node("B");
        Node nodeC = graph.new Node("C");
        Node nodeD = graph.new Node("D");
        Node nodeE = graph.new Node("E");
        Node nodeF = graph.new Node("F");

        startingNode.addEdge(nodeA, 5);
        startingNode.addEdge(nodeB, 2);
        startingNode.addEdge(nodeC, 9);
        startingNode.addEdge(nodeD, 4);
        startingNode.addEdge(nodeE, 3);
        nodeB.addEdge(nodeF, 3);
        nodeC.addEdge(nodeF, 2);
        nodeA.addEdge(nodeB, 7);

        // All distances must be reset before {distanceBetweenNodes} is called a second time.
        graph.distanceBetweenNodes(nodeB, nodeC);
    }
}
