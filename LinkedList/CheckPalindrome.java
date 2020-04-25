package LinkedList;

public class CheckPalindrome {
    
    boolean isPalindrome(Node head) 
    {
        //Your code here
        //print(head);
        if(head == null) return true;
        
        Node copy = copy(head);
        Node rev = Reverse(copy);
        
        Node a = head;
        Node b = rev;
        while(a != null && b != null) {
            
            if(a.data != b.data) return false;
            a = a.next;
            b = b.next;
            
        }
    
        return true;    
    } 
    
    Node copy(Node head) {
        Node newHead = new Node(head.data);
        Node ret = newHead;
        head = head.next;
        while(head !=null) {
            newHead.next = new Node(head.data);
            head = head.next;
            newHead = newHead.next;
        }
        return ret;
    }
    
    Node Reverse(Node head) {
        Node temp = head;
        
        Node next = null;
        Node prev = null;
        while(temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp=next;
        }
        
        return prev;
         
    }
    
    void print(Node head)
    {
        while(head!=null){
            System.out.print(head.data + " ");
            head= head.next;
        }
        
        System.out.println();
    }
}