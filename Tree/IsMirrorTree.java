package Tree;

public class IsMirrorTree {
    public static boolean isSymmetric(Node root)
    {
        // add your code here;
        if (root==null) return true;
        
        return find(root.left, root.right);
    }
    
    static boolean find(Node left, Node right)
    {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.data != right.data ) return false;
        
        return (find(left.left, right.right) && find(right.left, left.right)) ;
    }
}