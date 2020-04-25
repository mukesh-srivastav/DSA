package LinkedList;

public class ReverseLinkedListInGroups {
    
    public static Node reverse(Node node, int k)
    {
        Node curr = node, prev = null, next = null;
        int count = 0;
        while(curr != null && count < k)
        {
            next = curr.next;
		    curr.next = prev;
		    prev = curr;
		    curr = next;
		    count++;
        }
        
        if (next != null)
	      node.next = reverse(next, k); 
	      return prev;
    }
}