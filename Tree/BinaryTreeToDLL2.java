package Tree;

public class BinaryTreeToDLL2 {
    
    class Node {
        Node left, right;
        int data;
        
        Node(int d)
        {
            data = d;
            left = right = null;
        }       
    }

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
	    
	    DLL(root.right);
	    
	    root.right = head;
	    
	    if (head != null) {
	        head.left = root;
	    }
	    
	    head = root;
	    
	    DLL(root.left);
    }
}