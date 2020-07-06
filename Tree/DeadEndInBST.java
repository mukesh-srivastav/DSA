package Tree;
import java.util.*;

/**
 * Given a Binary search Tree that contains positive integer values greater then 0. The task is to complete the function isDeadEnd which returns true if the BST contains a dead end else returns false. Here Dead End means, we are not able to insert any element after that node.
 * 
 * Input :     
              8
            /   \ 
           7     10
         /      /   \
        2      9     13

Output : Yes
Explanation : We can't insert any element at 
              node 9.  
 */
public class DeadEndInBST {
    class Node {
        int data;
        Node left, right;
    }

    public static boolean isDeadEnd(Node root)
    {
        if (root == null)
            return false;
            
        
        return helper(root, 1, Integer.MAX_VALUE);
    }
    
    static boolean helper(Node root, int min, int max)
    {
        if (root == null)
            return false;
        
        if (min == max)
            return true;
        
        return helper(root.left, min, root.data - 1) || helper(root.right, root.data + 1, max);
    }

    public static boolean isDeadEndViaSets(Node root)
    {
        if (root == null)
            return false;
            
        Set<Integer> allNodes = new HashSet<>();
        Set<Integer> leafNodes = new HashSet<>();
        allNodes.add(0);
        
        storeNodes(root, allNodes, leafNodes);
        
        for (Integer leaf : leafNodes) {
            if (allNodes.contains(leaf + 1) && allNodes.contains(leaf - 1)) {
                return true;
            }
        }
        
        return false;
    }
    
    static void storeNodes(Node root, Set<Integer> allNodes, Set<Integer> leafNodes)
    {
        if (root == null)
            return;
        
        allNodes.add(root.data);
        
        if (root.left == null && root.right == null) {
            leafNodes.add(root.data);
            return;
        }
        
        storeNodes(root.left, allNodes, leafNodes);
        storeNodes(root.right, allNodes, leafNodes);
    }
}