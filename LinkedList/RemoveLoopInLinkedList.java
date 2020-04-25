package LinkedList;

public class RemoveLoopInLinkedList {

    int removeTheLoop(Node node) {
        
	    Node slow = node ; 
	    Node fast = node;
	    
	    while(slow !=null && fast!=null && fast.next!=null) {
	        slow = slow.next;
	        fast = fast.next.next;
	        if(slow == fast) {
	            this.removeLoop(node, slow);
	            return 1;
	        }
	        
	    }
	    
	    return 0;
	}
	
	void removeLoop(Node head, Node loop) {
	    
	    Node ptr1 = loop;
	    Node ptr2 = head;
	    
        ptr1 = loop;
        // int k=1;
        // while(ptr1.next!= loop) {
        //     ptr1 = ptr1.next;
        //     k++;
        // }
        // int i=0; 
        // while(i<k) {
        //     ptr2 = ptr2.next;
        //     i++;
        // }
        
        while(ptr2.next != ptr1.next) {
            ptr2 = ptr2.next;
        ptr1 = ptr1.next;
            
        }
        
        ptr1.next = null;
	        
	}
}