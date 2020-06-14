/**
 * Given N activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.

Note : The start time and end time of two activities may coincide.
 */
package Greedy;
import java.util.*;
public class ActivitySelection {
    
    static class Activity {
        int start, finish;
    }
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
		    int n = sc.nextInt();
		    Activity a[] = new Activity[n];
		    
		    for(int i=0; i<n; i++) {
		        a[i] = new Activity();
		    }
		    
		    for(int i=0; i<n; i++) {
		        a[i].start = sc.nextInt();
		    }
		    
		    for(int i=0; i<n; i++) {
		        a[i].finish = sc.nextInt();
		    }
		    
		    System.out.println(activitySelection(a,n));
        }
        sc.close();
	}
	
	static int activitySelection(Activity a[], int n)
	{
	    if (a.length ==0)
	        return 0;
	        
	    Arrays.sort(a, ((Activity a1, Activity a2) -> a1.finish - a2.finish));
	    
	    int count = 1;
	    int i=0;
	    for (int j=1; j<n; j++) {
	        if (a[j].start >= a[i].finish) {
	            count++;
	            i = j;
	        }
	    }
	    
	    return count;
	}
}

/**
 * Summary: https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
 * 
 * Greedy is an algorithmic paradigm that builds up a solution piece by piece, always choosing the next piece that offers the most obvious and immediate benefit. Greedy algorithms are used for optimization problems. An optimization problem can be solved using Greedy if the problem has the following property: At every step, we can make a choice that looks best at the moment, and we get the optimal solution of the complete problem.
If a Greedy Algorithm can solve a problem, then it generally becomes the best method to solve that problem as the Greedy algorithms are in general more efficient than other techniques like Dynamic Programming. But Greedy algorithms cannot always be applied. For example, Fractional Knapsack problem (See this) can be solved using Greedy, but 0-1 Knapsack cannot be solved using Greedy.

The greedy choice is to always pick the next activity whose finish time is least among the remaining activities and the start time is more than or equal to the finish time of previously selected activity. We can sort the activities according to their finishing time so that we always consider the next activity as minimum finishing time activity.

1) Sort the activities according to their finishing time
2) Select the first activity from the sorted array and print it.
3) Do following for remaining activities in the sorted array.
…….a) If the start time of this activity is greater than or equal to the finish time of previously selected activity then select this activity and print it.
 */