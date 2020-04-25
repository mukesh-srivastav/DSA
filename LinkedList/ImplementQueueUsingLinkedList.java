package LinkedList;

import java.util.*;

class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}

class ImplementQueueUsingLinkedList {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
			MyQueue obj = new MyQueue();
			int Q = sc.nextInt();
			while(Q>0)
			{
				int QueryType = 0;
				QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					
					obj.push(a);
					
				}else if(QueryType == 2)
				{
				System.out.print(obj.pop()+" ");
				}
				Q--;
			}
			System.out.println("");
			t--;
        }

        sc.close(); 
	}
} // Driver code Ends.


class MyQueue
{
    QueueNode front, rear;
    
    // This function should add an item at
    // rear
	void push(int a)
	{
        // Your code here
        QueueNode temp = new QueueNode(a);
        if (front== null || rear==null) {
            front = temp;
            rear = temp;
            return;
        }
        rear.next = temp;
        rear = rear.next;
	}
	
    // This function should remove front
    // item from queue and should return
    // the removed item.
	int pop()
	{
	    if (this.front == null)
	        return -1;
        // Your code here
        QueueNode temp = this.front;
        this.front = this.front.next;
        
        return temp.data;   
	}
}