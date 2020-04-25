package LinkedList;

import java.util.*;

public class MergeTwoLists {

    Node head;

    public void addToTheLast(Node node)
    {
        if (head == null) {
            head = node;
        } else {

            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
        
            temp.next = node;
        }
    }


  /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
	 
 
     /* Driver program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			MergeTwoLists llist1 = new MergeTwoLists();
		    MergeTwoLists llist2 = new MergeTwoLists();
			
				int a1=sc.nextInt();
				Node head1= new Node(a1);
				llist1.addToTheLast(head1);
				if (sc.hasNextInt())
				for (int i = 1; i < n1; i++) 
				{ 
					int a = sc.nextInt(); 
					llist1.addToTheLast(new Node(a));
				}
			
			
				int b1=sc.nextInt();
				Node head2 = new Node(b1);
				llist2.addToTheLast(head2);
				if (sc.hasNextInt()) 
				for (int i = 1; i < n2; i++) 
				{
					//int b;
					
					 int b = sc.nextInt(); 
					llist2.addToTheLast(new Node(b));
				}
				llist1.head= new LinkedList().sortedMerge(llist1.head,llist2.head);
				llist1.printList();
			
			t--;
			
        }

        sc.close();
    }
}
// } Driver Code Ends
/*
  Merge two linked lists 
  head pointer input could be NULL as well for empty list
  Node is defined as 
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class LinkedList
{
    Node sortedMerge(Node headA, Node headB) {
     // This is a "method-only" submission. 
     // You only need to complete this method
     
        if (headA==null) return headB;
        if (headB==null) return headA;
        
        Node res = new Node(0), temp = res;
        while(headA!=null && headB!=null) {
            if (headA.data <= headB.data) {
                res.next =  new Node(headA.data);
                headA = headA.next;
            }
            else {
                res.next = new Node(headB.data);
                headB= headB.next;
            }
            res = res.next;
        }
        
        if (headA!=null) {
            res.next = headA;
        }
        
        if (headB!=null) {
            res.next = headB;
        }
        
        return temp.next;
    
    } 
}