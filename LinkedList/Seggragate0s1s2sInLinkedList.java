package LinkedList;

/**
 * Given a linked list of N nodes where nodes can contain values 0s, 1s and 2s only.
 * The task is to segregate 0s, 1s and 2s linked list such that all zeros segregate to headside, 2s at the end of the linked list and 1s in the mid of 0s and 2s.
 */
public class Seggragate0s1s2sInLinkedList {

    static Node segregate(Node head)
    {
        // add your code here
        Node zeroD = new Node(0);
        Node oneD = new Node(0);
        Node twoD = new Node(0);
        
        Node zero= zeroD;
        Node one = oneD;
        Node two = twoD;
        
        Node curr = head;
        
        while (curr!=null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            
            curr = curr.next;
        }
        
        zero.next = (oneD.next!=null) ? (oneD.next) : (twoD.next);
        one.next = twoD.next;
        two.next = null;
        
        head = zeroD.next;
        return head;
    }
}
