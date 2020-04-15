package Tree;

import java.util.*;

public class SerializeAndDeserializeBinaryTree {

    public void serialize(Node root, ArrayList<Integer> A) {
	    if (root == null) {
	        A.add(-1);
	        return;
	    }
	    
	    A.add(root.data);
	    serialize(root.left, A);
	    serialize(root.right, A);
	}
	
	int index = 0;
	
    public Node deSerialize(ArrayList<Integer> A){
        if (A.size() == index || A.get(index) == -1) {
            index+=1;
            //index%=A.size();System.out.print(index+ " ");
            return null;
        }
        
        Node root = new Node(A.get(index));
        index+=1;
        //index%=A.size(); 
        root.left = deSerialize(A);
        root.right = deSerialize(A);
        
        return root;
    }

}