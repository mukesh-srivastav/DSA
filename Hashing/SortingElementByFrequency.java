package Hashing;

/*package whatever //do not write package name here */
/**
 * Given an array A[] of integers, sort the array according to frequency of elements. That is elements that have higher frequency come first. If frequencies of two elements are same, then smaller number comes first.
 */
import java.util.*;

class SortingElementByFrequency {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int n = sc.nextInt();
		    
		    
		    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		    List<Integer> list = new ArrayList<Integer>();
		    
		    for (int i=0; i<n; i++) {
		        int curr = sc.nextInt();
		        hm.put(curr, hm.getOrDefault(curr, 0) + 1);
		        list.add(curr);
		    }
		    
		    
		    
		    SortValueComparator smap = new SortValueComparator(hm);
		    
		    Collections.sort(list, smap);
		    
		    for (int i : list) {
		        System.out.print(i + " ");
		    }
		    System.out.println();
        } 
        
        sc.close();
	}
}

class SortValueComparator implements Comparator<Integer> {
    final Map<Integer, Integer> hm;
    
    SortValueComparator (HashMap<Integer, Integer> hm) {
        this.hm  = hm;
    }
    
    @Override 
    public int compare(Integer k1, Integer k2) {
        
        int freq = hm.get(k2).compareTo(hm.get(k1));
        int val = k1.compareTo(k2);
        if (freq == 0) {
            return val;
        } else
        return freq;
        
    }
    
}