package Tree;

public class IsIdenticalTrees {
    boolean isIdentical(Node root1, Node root2)
	{
	    // Code Here
	    if (root1==null && root2==null)
	        return true;
	   if (root1==null || root2==null)
	        return false;
	   
	   
	   if (root1.data==root2.data && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right))
	        return true;
	   return false;  
	}
}