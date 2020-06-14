package Array;

/**
 * Given an array A of N integers. The task is to find a peak element in it in O( log N ) .
An array element is peak if it is not smaller than its neighbours. For corner elements, we need to consider only one neighbour.
Note: There may be multiple peak element possible, in that case you may return any valid index (0 based indexing).
Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).
 */
public class PeakElement {
    // Function to return the peak element index.
	public int peakElement(int[] a,int n)
    {
        int low = 0;
        int high = n-1;
        if(n == 1) {
            return 0;
        } else if(n == 2) {
            return (a[0] > a[1])? 0 : 1;
        } else {
        
            while(low <= high) {
                int mid = low + (high - low)/2;
                
                if ((mid==0 || a[mid] >= a[mid-1]) && (mid == n-1 || a[mid] >= a[mid+1]))
                    return mid;
                
                if (mid > 0 && a[mid-1] > a[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
            return 0;
        }
    }
}