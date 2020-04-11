
/**
 * Complete the function to print spiral order traversal of a tree. For below tree, function should print 1, 2, 3, 4, 5, 6, 7.
 * 
 *                1
 *          2           3
 *      7       6   5       4
 */
import java.util.*;

class Node {
    int data; 
    Node left, right; 
    Node(int data) {
        this.data = data; 
        left = right = null;
    }
}

public class LevelOrderTraversalSpiralForm {
      void printSpiral(Node node) 
      {
            Deque<Node> d = new LinkedList<Node>();  
            int dir = 0; // right to left. 
            if (node == null) return;
            d.addLast(node);
            
            while(d.size()>0) {
                int size = d.size();
                
                while(size-->0) {
                    if (dir == 0) {
                        Node t = d.peekLast();
                        d.pollLast();
                        if (t.right!=null)
                            d.addFirst(t.right);
                        if (t.left!=null)
                            d.addFirst(t.left);
                        System.out.print(t.data + " "); 
                    } else {
                        Node t = d.peekFirst();
                        d.pollFirst();
                        if (t.left!=null)
                            d.addLast(t.left);
                        if (t.right!=null)
                            d.addLast(t.right);
                        System.out.print(t.data + " "); 
                    }
                }
                dir = 1-dir;
            }
            
           
      }
}