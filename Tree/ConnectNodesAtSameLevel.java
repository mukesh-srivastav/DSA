package Tree;

/**
 * https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1
 * 
 * Given a binary tree, connect the nodes that are at same level.Structure of the given Binary Tree node is like following.

struct Node
{
      int data;
      Node* left;
      Node* right;
      Node* nextRight;
}
Initially, all the nextRight pointers point to garbage values. Your function should set these pointers to point next right for each node.
       10                       10 ------> NULL
      / \                       /      \
     3   5       =>     3 ------> 5 --------> NULL
    / \     \               /  \           \
   4   1   2          4 --> 1 -----> 2 -------> NULL
 */
import java.util.*;
public class ConnectNodesAtSameLevel {

    class Node {
        Node left, right, nextRight;
        int data;
        Node(int data) {
            this.data = data;
            left = right = nextRight = null;
        }
    };

    public static void connect(Node p)
        {
            // code here.
            Queue<Node> q = new LinkedList<Node>();
            
            q.add(p);
            Node prev = null;
            
            while(q.size()!=0) {
                int n = q.size();
                
                for(int i=0; i<n; i++) {
                    Node temp = q.remove();
                    
                    if (i>0) {
                        prev.nextRight = temp;
                    }
                    
                    if (temp.left!=null)
                        q.add(temp.left);
                    if (temp.right!=null)
                        q.add(temp.right);
                    
                    prev = temp;
                }
              
                prev.nextRight = null;  
            }
        }
}