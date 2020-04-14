package Tree;


public class LCABinaryTree {
    /* If n1 and n2 are present, return reference
   to LCA. If both are not present, return 
   null,. Else if left subtree contains any 
   of them return pointer to left.*/
  
   
	Node lca(Node root, int n1,int n2)
	{
		return findLca(root, n1, n2);
	}
	
	Node findLca(Node root, int n1, int n2)
	{
	    if (root==null) return null;
	    
	    if(root.data == n1 || root.data==n2)
	    return root;
	    
	    Node left_lca = findLca(root.left, n1, n2);
	    Node right_lca = findLca(root.right, n1,n2);
	    
	    if (left_lca!=null && right_lca!=null)
	        return root;
	    
	    return (left_lca!=null) ? left_lca : right_lca;
	}

}