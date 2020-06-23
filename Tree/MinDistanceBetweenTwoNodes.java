package Tree;

public class MinDistanceBetweenTwoNodes {
    class Node {
        int data;
        Node left, right;
    }

    int d1, d2, dist;
    
    int findDist(Node root, int a, int b) {
        this.d1 = -1;
        this.d2 = -1;
        this.dist = 0;
        
        Node lca = findLCA(root, a, b, 0);
        
        // Means both nodes were in different subtrees.
        if (d1!=-1 && d2!=-1) {
            return dist;
        }
        
        // Means one was ancestor for another. 
        if (d1!=-1) {
            this.dist = findLevel(lca, b, 0);
            return this.dist;
        }
        
        if (d2!=-1) {
            this.dist = findLevel(lca, a, 0);
            return this.dist;
        }
        
        return -1;
    }
    
    Node findLCA(Node root, int a, int b, int level) {
        if (root == null) return null;
        
        if (root.data == a) {
            this.d1 = level;
            return root;
        }
        
        if (root.data == b) {
            this.d2 = level;
            return root;
        }
        
        Node leftLCA = findLCA (root.left, a, b, level+1);
        Node rightLCA = findLCA (root.right, a, b, level+1);
        
        if (leftLCA != null && rightLCA != null) {
            this.dist = this.d1 + this.d2 - 2 * level;
            return root;
        }
        
        return (leftLCA != null) ? leftLCA : rightLCA;
    }
    
    int findLevel(Node root, int n, int level)
    {
        if (root == null)
            return -1;
        
        if (root.data == n)
            return level;
        
        int left = findLevel(root.left, n, level+1);
        
        return (left!= -1) ? left : findLevel(root.right, n, level + 1); 
    }
}