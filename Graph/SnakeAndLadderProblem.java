package Graph;
import java.util.*;
/**
 * Given a snake and ladder board of order 5x6, find the minimum number of dice throws required to reach the destination or last cell (30th cell) from source (1st cell) . 
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains two lines. The first line of input contains an integer N denoting the no of ladders and snakes present. Then in the next line are 2*N space separated values a,b which denotes a ladder or a snake at position 'a' which takes to a position 'b'.
Soltion's Time complexity of the below mentioned solution is O(N) as every cell is added and removed only once from queue. And a typical enqueue or dequeue operation takes O(1) time.
Output:
For each test case in a new line print the required answer denoting the min no of dice throws.

Constraints:
1 <= T <= 100
1 <= N <= 10
1 <= a <= 30
1 <= b <= 30

Example:
Input:
2
6
11 26 3 22 5 8 20 29 27 1 21 9
1
2 30

Output:
3
1

Explanation:
Testcase 1:
For 1st throw get a 2, which contains ladder to reach 22
For 2nd throw get a 6, which will lead to 28
Finally get a 2, to reach at the end 30. Thus 3 dice throws required to reach 30.
 */
public class SnakeAndLadderProblem {
    static class Node {
        int v;
        int dist;
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            
            for(int i=0; i<n; i++) {
                a[i][0] = sc.nextInt() -1;
                a[i][1] = sc.nextInt() -1;
            }
            
            int r = findMinimumThrows(a, n);
            System.out.println(r);
        }
        sc.close();
    }
    
    static int findMinimumThrows(int [][]moves, int n)
    {
        boolean visited[] = new boolean[30];
        Queue<Node> q = new LinkedList<Node>();
        Node curr = new Node();
        curr.v = 0;
        curr.dist = 0;
        
        // Mark the node 0 as visited and enqueue it. 
        visited[0] = true;
        
        q.add(curr);
        // Do a BFS starting from vertex at index 0 
        while (q.isEmpty() == false) {
            curr = q.remove();
            
            // If front vertex is the destination  
            // vertex, we are done 
            if (curr.v == 29) {
                break;
            }
            // Otherwise dequeue the front vertex and  
            // enqueue its adjacent vertices (or cell  
            // numbers reachable through a dice throw) 
            for (int j=curr.v+1; j<=curr.v+6 && j<30; j++) {
                if (visited[j] == false) {
                    // if not visited calculate its distance and  
                    // mark it as visited 
                    Node adj = new Node();
                    adj.v = j;
                    
                     // Check if there a snake or ladder at 'j' 
                    // then tail of snake or top of ladder 
                    // become the adjacent of 'i' 
                    for (int i=0; i<n; i++) {
                        if (moves[i][0] == j) {
                            adj.v = moves[i][1];
                            break;
                        }
                    }
                    adj.dist = curr.dist +1;
                    visited[j] = true;
                    q.add(adj);
                }
            }
        }

        // We reach here when 'qe' has last vertex 
        // return the distance of vertex in 'qe' 
        return curr.dist;
    }
}
