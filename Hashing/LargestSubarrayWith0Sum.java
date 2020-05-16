package Hashing;

import java.util.*;
/**
 * Given an array having both positive an negative integers. The task is to complete the function maxLen() which returns the length of maximum subarray with 0 sum.
 * The function takes two arguments an array A and n where n is the size of the array A.
 */
public class LargestSubarrayWith0Sum {
    int maxLen(int arr[], int n) {
        // Your code here
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int prefixSum = 0;
        int maxLength = 0;
        
        for (int i = 0; i< n ; i++) {
            prefixSum += arr[i];
            
            if (prefixSum == 0) {
                maxLength = i + 1;
            }
            
            Integer lastIndex = hm.get(prefixSum);
            
            if (lastIndex == null) {
                hm.put(prefixSum, i);
            } else {
                maxLength = Math.max(maxLength, i - lastIndex);
            }
        }
        
        return maxLength;
    }    
}



