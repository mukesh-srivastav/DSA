package LinkedList;

import java.util.*;

class StackNode {
    int data;
    StackNode next;
    StackNode(int a) {
        data = a;
        next = null;
    }
}

class ImplementStackUsingLinkedList {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            MyStack obj = new MyStack();
            int Q = sc.nextInt();
            while (Q > 0) {
                int QueryType = 0;
                QueryType = sc.nextInt();
                if (QueryType == 1) {
                    int a = sc.nextInt();
                    obj.push(a);
                } else if (QueryType == 2) {
                    System.out.print(obj.pop() + " ");
                }
                Q--;
            }
            System.out.println("");
            t--;
        }

        sc.close();
    }
} //Driver Code Ends

class MyStack {

    // Note that top is by default null
    // in Java
    StackNode top;

    void push(int a) {
        // Add your code here
        StackNode n = new StackNode(a);
        if (top==null) {
            top = n;
            return;
        }
        n.next = top; 
        top = n;
    }
    
    int pop() {
        // Add your code here
        if(top==null) {
            return -1;
        }
        
        StackNode t = top;
        top = top.next;
        return t.data;
    }
}
