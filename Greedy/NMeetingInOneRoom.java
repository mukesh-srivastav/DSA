package Greedy;
import java.util.*;

/**
 * There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is start time of meeting i and F[i] is finish time of meeting i.

What is the maximum number of meetings that can be accommodated in the meeting room?
In each separate line print the order in which the meetings take place separated by a space.

== This is just another version of activity selection problem, here we have to print the indexes of the original array, so we define an additional index variable in meeting object which keeps track original index in array (using i+1 as output requires 1 base indexing output). 
 */
public class NMeetingInOneRoom {
    static class Meeting {
        int start, finish, index;
    }
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int n = sc.nextInt();
		    
		    Meeting a[] = new Meeting[n];
		    
		    for (int i=0; i<n; i++) {
		        a[i] = new Meeting();
		    }
		    
		    for (int i=0; i<n; i++) {
		        a[i].start = sc.nextInt();
		        a[i].index = i+1;
		    }
		    
		    for (int i=0; i<n; i++) {
		        a[i].finish = sc.nextInt();
		    }
		    
		    ScheduleMeetings(a, n);
		}
		sc.close();
	}
	
	static void ScheduleMeetings(Meeting a[], int n)
	{
        // Sort based on finish time. 
	    Arrays.sort(a, ((Meeting m1, Meeting m2) -> m1.finish - m2.finish));
        
        // Pick first meeting as it will be the first one to finish. 
	    int i = 0;
	    System.out.print(a[i].index + " ");
        
        // Check for rest others which are starting just after the last finished meeting. printing their indexes.
	    for (int j=1; j<n; j++) {
	        if (a[j].start >= a[i].finish) {
	            System.out.print(a[j].index + " ");
	            i = j;
	        }
	    }
	    
	    System.out.println();
	}
}