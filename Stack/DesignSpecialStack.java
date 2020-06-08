package Stack;
import java.util.*; 
/**
 * Design a data-structure SpecialStack (using the STL of stack) that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. Your task is to complete all the functions, using stack data-Structure.
 */
public class DesignSpecialStack {
    Stack<Integer> min = new Stack<Integer>();

	public void push(int a,Stack<Integer> s)
	{
	    if (s.isEmpty()) {
	        min.push(a);
	    } else {
	        int x = min.pop();
            min.push(x);
            
        /* push into min only when the incoming  
           element of main stack is smaller  
        than or equal to top of auxiliary stack */
	        if (a<x) {
	            min.push(a);
	        }
	    }
	    
	    s.push(a);
    }
    
	public int pop(Stack<Integer> s)
    {
        if (s.isEmpty())
            return -1;
        
        int x = s.pop();
        int y = min.pop();
        
        /* Push the popped element y back  
       only if it is not equal to x */
        if (x!=y)
            min.push(y);
        
        return x;
	}
	
	public int min(Stack<Integer> s)
    {
        int x = min.pop();
        min.push(x);
        return x;
    }
    
	public boolean isFull(Stack<Integer>s, int n)
    {
        return (s.size() == n);
    }
    
	public boolean isEmpty(Stack<Integer>s)
    {
         return s.isEmpty();
	}
}