package Tree;

public class DiameterOfTree {
    
    int diameter(Node root) {
        // Your code here
        if (root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        
        int lDia = diameter(root.left);
        int rDia = diameter(root.right);
        
        return Math.max(lh+rh+1, Math.max(lDia, rDia));
    }
    
    
    int height(Node root) {
      if (root==null) return 0;
    
      return 1 + Math.max(height(root.left), height(root.right));
    }
}