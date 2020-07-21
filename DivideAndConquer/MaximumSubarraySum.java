/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:
If you have figured out the Kadane O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
This is Divide&Conquer solution.
 */
package DivideAndConquer;

public class MaximumSubarraySum {
    public int max(int a, int b, int c){
        return Math.max(a, Math.max(b,c));
    }
    
    public int helper(int[] nums, int start, int mid, int end, int lr, int rr){
        
        //System.out.print("start="+start+" mid="+mid+" end="+end+" leftval="+lr+" rightval="+rr);
   
        
        int leftmax = Integer.MIN_VALUE;
        int sum=0;
        
        for(int i=mid; i>=start; i--){
           sum+= nums[i];
            leftmax = Math.max(leftmax, sum);
        }
        
        
        int rightmax = Integer.MIN_VALUE;
        sum=0;
        
        for(int i=mid+1; i<=end; i++){
            sum+=nums[i];
            rightmax = Math.max(sum, rightmax);
        }


        int cr = leftmax+rightmax;
        
        int res =  max(lr,rr,cr);
       //System.out.println(" res="+ res);
        return res;
        
    }
    
    public int mergehelper(int[] nums, int start, int end){
        if(start>=end) return nums[start];
        int mid = start+(end-start)/2;
        int lr = mergehelper(nums, start, mid);
        int rr = mergehelper(nums, mid+1, end);
        return helper(nums, start, mid, end, lr, rr);
    }
    
    public int maxSubArray(int[] nums) {
        if(nums.length<1)
            return Integer.MIN_VALUE;
        return mergehelper(nums, 0, nums.length-1);
    }
}