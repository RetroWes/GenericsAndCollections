import java.util.*;

public class Graph {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        // Comparator function used for sorting edges based on their weight
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    // A class to represent a subset for union-find
    class Subset {
        int parent, rank;

        Subset(int parent, int rank){
            this.parent = parent;
            this.rank = rank;
        }
    }

    int vertices;      // Number of vertices and edges
    List<Edge> edges; // collection of all edges

    // Constructor
    private Graph(int vertices){
        this.vertices = vertices;
        this.edges = new ArrayList<Edge>();
    }

    // A utility function to find set of an element i (uses path compression technique)
    private int find(Subset[] subsets, int i){
        if(subsets[i].parent != i){
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    // A function that does union of two sets of x and y (uses union by rank)
    private void union(Subset[] subsets, int x, int y){
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);

        if(subsets[rootX].rank < subsets[rootY].rank) {subsets[rootX].parent = rootY;} 
        else if(subsets[rootX].rank > subsets[rootY].rank){subsets[rootY].parent = rootX;} 
        else{
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    // The main function to construct MST using Kruskal's algorithm
    public List<Edge> KruskalMST(){
        List<Edge> result = new ArrayList<Edge>();
        Collections.sort(edges);

        Subset[] subsets = new Subset[vertices];
        for(int vertex = 0; vertex < vertices; ++vertex) {subsets[vertex] = new Subset(vertex, 0);}

        int i = 0;
        while(result.size() < vertices - 1 && i < edges.size()){
            Edge nextEdge = edges.get(i++);

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            if(x != y){
                result.add(nextEdge);
                union(subsets, x, y);
            }
        }
        return result;
    }

    public static void main(String[] args){
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 0, 4);

        List<Edge> result = graph.KruskalMST();
        for(Edge e : result) {System.out.printf("%d -> %d, Weight: %d\n", e.src, e.dest, e.weight);}
    }
}