package Greedy;
import java.util.*;

/**
 * You are given N pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. Your task is to complete the function maxChainLen which returns an integer denoting the longest chain which can be formed from a given set of pairs. 
 * 
 * Example(To be used only for expected output):
Input
2
5
5  24 39 60 15 28 27 40 50 90
2
5 10 1 11 
Output
3
1
Explanation
(i) the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} },the longest chain that can be formed is of length 3, and the chain is {{5, 24}, {27, 40}, {50, 90}}
(ii) The max length chain possible is only of length one.
 */
public class MaxChainLength {
    class Pair {
        int x, y;
    }
    int maxChainLength(Pair arr[], int n)
    {
       Arrays.sort(arr, (a, b) -> (a.y - b.y));
       
       int count = 0, i = 1, j = 0;
       while (i<n) {
            if (arr[i].x > arr[j].y) {
               count++;
               j = i;
            }
            i++;
       }
       
       return count+1;
    }
}