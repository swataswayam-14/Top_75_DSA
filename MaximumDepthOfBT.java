import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBT {
    int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int depth = 0;
        while (!q.isEmpty()) {
            depth++;
            int size = q.size();
            for (int i=0; i<size; i++) {
                Node node = q.remove();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return depth;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        
        /*
             Tree structure:
                  1
                /   \
               2     3
              / \     \
             4   5     6
            /
           7
           
           Expected depth: 4
        */
        
        MaximumDepthOfBT solution = new MaximumDepthOfBT();
        int depth = solution.maxDepth(root);
        
        System.out.println("Maximum depth of the binary tree: " + depth);
        System.out.println("Maximum depth of null tree: " + solution.maxDepth(null));
        Node singleNode = new Node(1);
        System.out.println("Maximum depth of single node tree: " + solution.maxDepth(singleNode));
    }
}

class Node {
    int val;
    Node left;
    Node right;
    Node (int val) {
        this.val = val;
        this.left =  this.right = null;
    }
}
