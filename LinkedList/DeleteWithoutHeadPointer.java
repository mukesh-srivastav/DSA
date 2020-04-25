package LinkedList;

/**
 * You are given a pointer/ reference to the node which is to be deleted from the linked list of N nodes.
 * The task is to delete the node. Pointer/ reference to head node is not given. 
 * Note: No head reference is given to you.
 */
public class DeleteWithoutHeadPointer {
    
    void deleteNode(Node node)
    {
         // Your code here
         Node prev = null;
        while(node!=null && node.next!=null) {
            prev = node;
            node.data = node.next.data;
            node = node.next;
        }
        prev.next= null;
    }
}