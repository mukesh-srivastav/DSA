package Tree;

public class CreateMirrorTree {
    
    void mirror(Node node)
    {
	// Your code here
	    if (node == null) return;
	    
	    mirror(node.left);
	    mirror(node.right);
	    
	    Node t = node.left;
	    node.left = node.right;
	    node.right = t;
	    return;
    }
}