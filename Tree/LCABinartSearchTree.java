package Tree;

public class LCABinartSearchTree {

    Node LCA(Node node, int n1, int n2)
	{
	    
        while(node!=null) {
            
            if (node.data > n1 && node.data > n2)
                node = node.left;
            
            else if (node.data < n1 && node.data < n2)
                node = node.right;
            else { break;  }
            
        }
        
        return node;
    }
}