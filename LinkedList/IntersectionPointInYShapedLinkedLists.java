package LinkedList;

public class IntersectionPointInYShapedLinkedLists {
	int intersectPoint(Node headA, Node headB)
	{
         // code here
        Node headA1 = copy(headA);
        Node headA2 = copy(headB);
        Node rev1 = reverse(headA1);
        Node rev2 = reverse(headA2);
        
        Node prev = null;
        while(rev1!=null && rev2 !=null){
            if(rev1.data != rev2.data)  return prev.data;
            prev = rev1;
            rev1 = rev1.next;
            rev2 = rev2.next;
        }
        
        //This is solution if Lists are allowed to modified.
        // Node temp = headA ;
        
        // while(temp!=null){
        //     temp.data = temp.data * (-1);
        //     temp = temp.next;
        // }
        
        // temp = headB;
        // while(temp!=null){
        //     if(temp.data<0) return (-1) * temp.data;
        //     temp = temp.next;
        // }
        return -1;
	}
	
	Node copy (Node head) {
	    Node newHead = new Node(head.data);
	    head = head.next;
	    Node ret = newHead;
	    while(head!=null){
	        newHead.next = new Node(head.data);
	        head = head.next; 
	        newHead = newHead.next;
	    }
	    
	    return ret;
	}
	Node reverse(Node head){
	    Node temp = head; 
	    Node next = null, prev= null;
	    
	    while(temp!=null){
	        next = temp.next; 
	        temp.next = prev;
	        prev = temp; 
	        temp = next; 
	    }
	    
	    return prev;
	}
}