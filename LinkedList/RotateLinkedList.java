package LinkedList;

public class RotateLinkedList {
    public void rotate(Node head,int k)
        {
         //add code here.
            if(head == null)
                return;
                
            if(k==0)
                return;
            Node temp = head; 
            int i=0;
            while(i++<k-1 && temp.next!=null){
                temp = temp.next;
            }
            
            if(temp.next ==null)    print(head);
            Node rot= temp.next; 
            temp.next = null;
            
            if(rot == null)
                return;
            Node head1 = rot;
            while(rot.next!=null){
                rot = rot.next;
            }
            rot.next = head;
            head = head1;
            
            print(head);
         }
         
         void print(Node head){
             Node temp= head;
            while(temp!=null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
         }
}