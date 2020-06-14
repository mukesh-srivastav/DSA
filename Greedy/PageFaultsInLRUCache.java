package Greedy;
import java.util.*;
/**
 * In operating systems that use paging for memory management, page replacement algorithm are needed to decide which page needs to be replaced when the new page comes in. Whenever a new page is referred and is not present in memory, the page fault occurs and Operating System replaces one of the existing pages with a newly needed page. Given a sequence of pages and memory capacity, your task is to find the number of page faults using Least Recently Used (LRU) Algorithm.
 * 
 * Example:
Input:
2
9
5 0 1 3 2 4 1 0 5
4
8
3 1 0 2 5 4 1 2
4

Output:
8
7

Explanation:
Testcase 1:
memory allocated with 4 pages 5, 0, 1, 3: page fault = 4
page number 2 is required, replaces LRU 5: page fault = 4+1 = 5
page number 4 is required, replaces LRU 0: page fault = 5 + 1 = 6
page number 1 is required which is already present: page fault = 6 + 0 = 6
page number 0 is required which replaces LRU 1: page fault = 6 + 1 = 7
page number 5 is required which replaces LRU 3: page fault = 7 + 1  =8.
 */
public class PageFaultsInLRUCache {
    public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int n = sc.nextInt();
		    
		    int a[] = new int[n];
		    
		    for (int i=0; i<n; i++) {
		        a[i] = sc.nextInt();
		    }
		    
		    int k = sc.nextInt();
		    System.out.println(CountPageFaultsInLRUCache(a, n, k));
		}
		sc.close();
	}
	
	static int CountPageFaultsInLRUCache(int a[], int n, int k)
	{
	    if (n==0 || a.length == 0 || k < 4) {
	        return 0;
	    }
	   // Alternate Solution 
	   // Queue<Integer> q = new LinkedList<>();
	   // List<Integer> list = new ArrayList<>();
	   // int cnt = 0;
	    
	   // for (int i=0; i<n; i++) {
	   //     if (list.contains(a[i])) {
	   //         q.remove(a[i]);
	   //         q.add(a[i]);
	   //     } else {
	   //         cnt++;
	   //         if (q.size() >= k) {
	   //             int recent = q.poll();
	   //             list.remove(new Integer(recent));
	   //         }
	           
	   //         q.add(a[i]);
	   //         list.add(a[i]);
	   //     }
	   // }
	    
	   // //System.out.println();
	    
	   // return cnt;
	   
	   int cnt = 0;
	   List<Integer> list = new ArrayList<>(k);
	   
	   for (int i : a) {
	       if (false == list.contains(i)) {
	           if (list.size() == k) {
	               list.remove(0);
	               list.add(k - 1, i);
	           } else {
	               list.add(i);
	           }
	           cnt++;
	       } else {
	           list.remove(new Integer(i));
	           list.add(i);
	       }
	   }
	   
	   return cnt;
	}
}