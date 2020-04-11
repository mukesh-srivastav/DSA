
package Tree;

import java.util.*;

class VerticalOrderTraversal
{
    static class NodeHd{
        Node node;
        int hd; 
        NodeHd(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    
    static void verticalOrder(Node root)
    {
        if (root == null) return;
        // add your code here
        TreeMap<Integer, List<Node>> treeMap = new TreeMap<Integer, List<Node>>();
        
        Queue<NodeHd> q = new LinkedList<>();
        
        q.add(new NodeHd(root, 0));
        
        while (q.size()!=0) {
            NodeHd curr = q.remove();
            
            if (curr.node.left != null)
                q.add(new NodeHd(curr.node.left, curr.hd - 1));
            if (curr.node.right != null)
                q.add(new NodeHd(curr.node.right, curr.hd + 1));
            
            if (treeMap.containsKey(curr.hd)) {
                List<Node> list = treeMap.get(curr.hd);
                list.add(curr.node);
                treeMap.put(curr.hd, list);
            } else {
                List<Node> list = new ArrayList<Node>();
                list.add(curr.node);
                treeMap.put(curr.hd, list);
            }
        }
        
        
        Collection<List<Node>> col = treeMap.values();
        
        for (List<Node> list : col) {
            for (Node n : list)
                System.out.print(n.data + " ");
        }
        
    }
}