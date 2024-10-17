import java.util.LinkedList;
import java.util.Queue;

/*  Michael Pizzichemi, Wesley Morgan, Dan O'Brien
 *  Lab 9 - 03/28/2024
 *  Creates a binary tree and searches within the tree for a node of a specified value
 *  prints the breadth- first search path in the form of edges traversed
 */

public class BinaryTreeBFS {
  public class BinaryTreeNode {
    int value;
    BinaryTreeNode left, right;

    public BinaryTreeNode(int value) {
      this.value = value;
      left = right = null;
    }

    public void insert(int value) {
      if (value < this.value) {
        if (this.left == null) {
          this.left = new BinaryTreeNode(value);
        } else {
          this.left.insert(value);
        }
      } else {
        if (this.right == null) {
          this.right = new BinaryTreeNode(value);
        } else {
          this.right.insert(value);
        }
      }
    }
  }

  public class BinarySearchTree {
    BinaryTreeNode root;

    public BinarySearchTree(int value) {
      root = new BinaryTreeNode(value);
    }

    public void insert(int value) {
      this.root.insert(value);
    }

    // This assumes that root is not null
    public LinkedList<BinaryTreeNode> getNodesAtLevel(int level) {
      LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
      queue.add(root);
      LinkedList<BinaryTreeNode> tempQueue = new LinkedList<BinaryTreeNode>();
      while (level != 0) {
        for (BinaryTreeNode n : queue) {
          if (n.left != null) {tempQueue.add(n.left);}
          if (n.right != null) {tempQueue.add(n.right);}
        }
        queue = new LinkedList<BinaryTreeNode>(tempQueue);
        tempQueue.clear();
        level--;
      }
      return queue;
    }

    public LinkedList getValsAtLevel(int level) {
      LinkedList<Integer> valsQueue = new LinkedList<Integer>();
      LinkedList<BinaryTreeNode> nodesQueue = getNodesAtLevel(level);
      for (BinaryTreeNode n : nodesQueue) {
          valsQueue.add(n.value);
      }
      return valsQueue;
    }
    
    public void breadthFirstSearch(int searchValue) {
      for(int i = 0; i < 3; i++){
        this.getValsAtLevel(i);
      }
    }
  }

  public static void main(String[] args) {
    BinaryTreeBFS bfs = new BinaryTreeBFS();
    BinarySearchTree tree = bfs.new BinarySearchTree(50);
    tree.insert(30);
    tree.insert(20);
    tree.insert(40);
    tree.insert(70);
    tree.insert(60);
    tree.insert(80);

    System.out.println(tree.getValsAtLevel(2));
  }
}