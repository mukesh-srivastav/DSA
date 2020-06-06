package Graph;
import java.util.*;
/**
 * Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may return any valid order.
You don't need to read input or print anything. Your task is to complete the function findOrder() which takes the string array dict[], its size N and the integer K as inputs and returns a string denoting the order of characters in the alien language.

Expected Time Complexity: O(N + K).
Expected Auxiliary Space: O(K).

The idea is to create a graph of characters and then find topological sorting of the created graph. Following are the detailed steps.

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.

1) Create a graph g with number of vertices equal to the size of alphabet in the given alien language. For example, if the alphabet size is 5, then there can be 5 characters in words. Initially there are no edges in graph.

2) Do following for every pair of adjacent words in given sorted array.
…..a) Let the current pair of words be word1 and word2. One by one compare characters of both words and find the first mismatching characters.
…..b) Create an edge in g from mismatching character of word1 to that of word2.

3) Print topological sorting of the above created graph.
https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
 */
public class AlienDictionary {
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        
        for (int i=0; i<K; i++)
            adj.add(new ArrayList<Integer>());
        
        for (int i=0; i<dict.length -1; i++) {
            for (int j=0; j<Math.min(dict[i].length(), dict[i+1].length()); j++) {
                if (dict[i].charAt(j) != dict[i+1].charAt(j)) {
                    adj.get(dict[i].charAt(j) - 'a').add(dict[i+1].charAt(j) - 'a');
                    break;
                }
            }
        }
        
        
        Stack<Integer> stack = new Stack<Integer>();
        boolean visited[] = new boolean[K];
        
        Arrays.fill(visited, false);
        
        for (int i=0; i<K; i++) {
            if (visited[i] == false)
                dfsUtil(adj, visited, stack, i);
        }
        
        String res = "";
        while (stack.isEmpty()==false) {
            res += (char) ('a' + stack.pop());
        }
        return res;
    }
    
    static void dfsUtil(ArrayList<ArrayList<Integer>> adj, boolean visited[], Stack<Integer> stack, int i)
    {
        visited[i] = true;
        
        for (int j=0; j<adj.get(i).size(); j++) {
            if (visited[adj.get(i).get(j)] == false) {
                dfsUtil(adj, visited, stack, adj.get(i).get(j));
            }
        }
        
        stack.push(i);
    }
}