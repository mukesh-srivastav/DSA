package Hashing;

import java.util.*;
public class CountDistinctInWindow {
    
    void countDistinct(int A[], int k, int n) {
        
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int i=0;
        for (i=0; i<k; i++) {
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }
        
        for (i=k; i<n; i++) {
            System.out.print(hm.size() + " ");
            int val = hm.get(A[i-k]);
            if (val <= 1) {
                hm.remove(A[i-k]);
            } else {
                hm.put(A[i-k], hm.get(A[i-k]) - 1);    
            }
            
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }
        System.out.print(hm.size() + " ");
    }
}