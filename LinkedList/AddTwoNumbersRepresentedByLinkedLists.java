package LinkedList;

import java.util.*;

public class AddTwoNumbersRepresentedByLinkedLists {
        Node head;
    
        void printList(Node head) {
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
        }
    
        public void push(int new_data) {
            /* 1 & 2: Allocate the Node &
                      Put in the data*/
            Node new_node = new Node(new_data);
    
            /* 3. Make next of new Node as head */
            new_node.next = head;
    
            /* 4. Move the head to point to new Node */
            head = new_node;
        }
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            while (T > 0) {
                int n1 = sc.nextInt();
                AddTwoNumbersRepresentedByLinkedLists list1 = new AddTwoNumbersRepresentedByLinkedLists();
                for (int i = 1; i <= n1; i++) {
                    int a = sc.nextInt();
                    list1.push(a);
                }
                int n2 = sc.nextInt();
                AddTwoNumbersRepresentedByLinkedLists list2 = new AddTwoNumbersRepresentedByLinkedLists();
                for (int i = 0; i < n2; i++) {
                    int b = sc.nextInt();
                    list2.push(b);
                }
                AddTwoNumbersRepresentedByLinkedLists list3 = new AddTwoNumbersRepresentedByLinkedLists();
                Add g = new Add();
                Node rs = g.addTwoLists(list1.head, list2.head);
                list3.printList(rs);
                System.out.println();
                T--;
            }
        }
    }// } Driver Code Ends
    
class Add {
    
    // This function will add the numbers represented by two linked lists
    Node addTwoLists(Node first, Node second) {
        // Your code here
        Node res = null;
        Node prev = null;
        Node temp = null;
        
        // Node curr = first;
        // Node prev= null, next=null;
        //  print(first); 
        //  print(second);
        // while(curr!=null) {
        //     next = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = next;
        // }
        
        Node firstRev = first;
        
        Node secondRev= second;
        // print(firstRev);
        //  if (secondRev!=null)
        //  return secondRev;
        int c = 0;
        while (firstRev!=null || secondRev!=null) {
            
            int r = ((firstRev!=null) ? firstRev.data : 0) + ((secondRev!=null) ? secondRev.data : 0) + c;
            temp = new Node(r%10);
            
            c = r/10;
            
            if (res==null)
                res = temp;
            else {
                prev.next = temp;
            }
            
            prev = temp;
            
            if (firstRev!=null)
                firstRev = firstRev.next;
            if (secondRev!=null)
                secondRev = secondRev.next;
        }
        
        if (c>0) {
            temp.next = new Node(c);
        }
        // while (firstRev!=null) {
        //     int t = firstRev.data+c;
        //     res.next = new Node(t%10);
        //     res = res.next;
        //     firstRev = firstRev.next;
        //     c = t/10;
        // }
        
        // while (secondRev!=null) {
        //     int t = secondRev.data+c;
        //     res.next = new Node(t%10);
        //     res = res.next;
        //     secondRev = secondRev.next;
        //     c = t/10;
        // }
        
        return res;
    }
    
    Node reverse(Node curr) {
        
        Node prev= null, next=null;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    void print(Node node) {
        Node t = node;
        while (t!=null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
        System.out.println();
    }
}
