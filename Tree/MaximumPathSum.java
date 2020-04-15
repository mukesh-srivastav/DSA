package Tree;

public class MaximumPathSum {

    static int value = Integer.MIN_VALUE;

    public static int maxPathSum(Node root) {
        
        if (root==null) 
            return 0;
        int t;

        heightSum(root);
        
        t = value;
        value = Integer.MIN_VALUE;
        
        return t;
    }
    
    static int heightSum(Node root) {
        if (root==null) return 0;
        
        if (root.left==null && root.right==null)
        return root.data;
        
        int lh = heightSum(root.left);
        int rh = heightSum(root.right);
        
        if (root.left!=null && root.right!=null) {
            value = Math.max(value, lh + rh + root.data);
            return Math.max(lh, rh) + root.data;    
        }
        
        return (root.left==null) ? rh+ root.data : lh + root.data;
    }
}