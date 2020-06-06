package Graph;

import java.util.*;

public class CircleOfStrings {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
		    int n = sc.nextInt();
		    String a[] = new String[n];
		    
		    for(int i=0; i<n; i++) {
		        a[i] = sc.next();
		    }
		    
		    System.out.println(canBeChained(a,n) ? 1 : 0);
		}
		sc.close();
	}
	
	static boolean canBeChained(String a[], int n)
	{
	    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	    int indegree[] = new int[26];
	    
	    // Create ADj list for every character;
	    for (int i=0; i<26; i++) {
	        adj.add(new ArrayList<Integer>());
	    }
	    
	    for (int i=0; i<n; i++) {
	        int f = a[i].charAt(0) - 'a';
	        int l = a[i].charAt(a[i].length() - 1) - 'a';
	        adj.get(f).add(l);
	        indegree[l]++;
	    }
	    
	    return isEulerianCircuitExists(adj, indegree, n);
	}
	
	static boolean isEulerianCircuitExists(ArrayList<ArrayList<Integer>> adj, int indegree[], int n)
	{
	    // graph should a strongly connected. 
	    if (isSC(adj, indegree) == false)
	        return false;
	    
	    // Indegree and outdegree for each node should be same.
	    for (int i=0; i<adj.size(); i++) {
	        if (indegree[i] != adj.get(i).size()) {
	            return false;
	        }
	    }
	    
	    return true;
	}
	
	// Checking if its a strongly connected component
	static boolean isSC(ArrayList<ArrayList<Integer>> adj, int indegree[])
	{
	    boolean visited[] = new boolean[26];
	    
	    Arrays.fill(visited, false);
	    
	    // finding first node to start the dfs.
	    int n =0;
	    for (n=0; n<26; n++) {
	        if (adj.get(n).size() > 0)
	            break;
	    }
	    
	    dfsUtil(adj, visited, n);
	    
	    // if there is a node which didn't got visited in dfs and its connected to some other node (means there is a string), return false.
	    for (int i=0; i<26; i++) {
	        if (adj.get(i).size() > 0 && visited[i]== false)
	               return false;
	    }
	    
	    // No need to reverse dfs check  I character is marked (i.e. it was first or last 
        //    character of some string) then it should be 
        //    visited in last dfs (as for looping, graph 
        //    should be strongly connected) 
	    // ArrayList<ArrayList<Integer>> adjT = getTranspose(adj);
	    
	    // Arrays.fill(visited, false);
	    
	    // dfsUtil(adj, visited, n);
	    
	    // for (int i=0; i<26; i++) {
	    //     if (adj.get(i).size() > 0 && visited[i]== false)
	    //            return false;
	    // }
	    
	    return true;
	}
	
	static void dfsUtil(ArrayList<ArrayList<Integer>> adj, boolean visited[], int n)
	{
	    visited[n] = true;
	    
	    for (int i=0; i<adj.get(n).size(); i++) {
	        if (visited[adj.get(n).get(i)] == false) {
	            dfsUtil(adj, visited, adj.get(n).get(i));
	        }
	    }
	}
	
	static ArrayList<ArrayList<Integer>> getTranspose(ArrayList<ArrayList<Integer>> adj)
	{
	    ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>();
	    
	    for (int i=0; i<26; i++) {
	        adjT.add(new ArrayList<Integer>());
	    }
	    
	    for (int i=0; i<26; i++) {
	        for (int j = 0; j<adj.get(i).size(); j++) {
	            adjT.get(j).add(i);
	        }
	    }
	    
	    return adjT;
	}
}