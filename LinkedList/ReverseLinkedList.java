package LinkedList;


class Node {
    int data;
    Node next;
    Node(int value) {
       this.data = value;
    }
}

class ReverseLinkedList {
    // This function should reverse linked list and return
   // head of the modified linked list.
   Node reverse(Node head)
   {
        Node previous = null;
        Node next = null;
        
        while(head != null ) {
            next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        
        return previous;
   }
}