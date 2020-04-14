package Tree;

/**
 * The idea is to do inorder traversal of the binary tree. 
 * While doing inorder traversal, keep track of the previously visited node in a variable say prev.
 * For every visited node, make it next of prev and previous of this node as prev.
 */
public class BinaryTreeToDLL {
    Node head;
    Node prev=null;
    
    Node bToDLL(Node root)
    {
	    DLL(root);
	    return head;
    }
    
    void DLL(Node root)
    {
        if (root==null) return;
	    
	    DLL(root.left);
	    
	    if (prev==null)
	        head = root;
	    else {
	        root.left = prev;
	        prev.right = root;
	    }
	    
	    prev = root;
	    
	    DLL(root.right);
    }
}