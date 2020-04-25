package LinkedList;

public class NthNodeFromEnd {

    int getNthFromLast(Node head, int n)
    {
	    // Your code here
        Node main = head;
        Node aux = head;
        int i=0;

        while (i < n) {
            if(aux==null)
                return -1;

            aux = aux.next;
            i++;
        }

        while(aux != null) {
            main = main.next;
            aux = aux.next;
        }
        
        return main.data;
    }
}