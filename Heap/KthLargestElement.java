package Heap;

import java.util.*;

/**
 * Given an input stream of n integers, find the kth largest element for each element in the stream.
 * Implementation: Maintain MinHeap of K min elements. 
 * Input k = 4  n= 6
 * A[] = 1 2 3 4 5 1
 * Initial Heap will be [1,2,3,4], while checking 5, 1 will be removed=> [2,3,4,5], next is 1 so it won't be removed, 
 * thus output will be -1 -1 -1 1 2 2
 */

class KthLargestElement {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while (t-- > 0) {
		    int k = sc.nextInt();
		    int n = sc.nextInt();
		    
		    int a[] = new int[n];
		    
		    for(int i=0; i<n; i++) {
		        a[i] = sc.nextInt();
		    }
		    
		    for(int i=0; i<k-1; i++) {
		        System.out.print(-1 + " ");
		    }
		    getKMax(a, n, k);
		    System.out.println();
		    
        }
        
        sc.close();
	}
	
	static void getKMax(int a[], int n, int k) {
	        MinHeap mh = new MinHeap(k);
	        for(int i=0; i<k; i++) {
		        mh.add(a[i]);
		    }
		    
		    for(int i=k; i<n; i++) {
		        System.out.print(mh.getMin() + " ");
		        if (mh.getMin() < a[i]) {
		            mh.extractMin();
		            mh.add(a[i]);
		        }
		    }
		    
		    System.out.print(mh.getMin() + " ");
		  
            // PriorityQueue Implementation.
            //PriorityQueue<Integer> mh = new PriorityQueue<>();
            // int i = 0;
            // for(i=0; i<k; i++){
            //   mh.add(arr[i]);
            // }

            // for(i=k; i<n; i++){
            //   System.out.print(mh.peek() + " ");
            //   if(arr[i] > mh.peek()){
            //     mh.remove();
            //     mh.add(arr[i]);
            //   }
            // }
            // System.out.print(mh.peek() + " ");
	}
}

class MinHeap {
    int capacity;
    int heap_size;
    int harr[];
    
    int left(int i) {
        return 2*i + 1;
    }
    
    int right(int i) {
        return 2*i + 2;
    }
    
    int parent(int i) {
        return (i-1)/2;
    }
    
    int getMin() {
        return harr[0];
    }
    
    MinHeap(int cap) {
        capacity = cap;
        heap_size = 0;
        harr = new int[cap];
    }
    
    void Heapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        
        if (l<heap_size && harr[l]<harr[smallest])
            smallest = l;
        
        if (r<heap_size && harr[r]<harr[smallest])
            smallest = r;
            
        if (smallest!=i) {
            int t = harr[smallest];
            harr[smallest] = harr[i];
            harr[i] = t;
            Heapify(smallest);
        }
    }
    
    void add(int k) {
        if (heap_size==capacity) return;
        
        heap_size++;
        int i = heap_size-1;
        harr[i] = k;
        
        while(i!=0 && harr[parent(i)] > harr[i]) {
            int t = harr[parent(i)];
            harr[parent(i)] = harr[i];
            harr[i] = t;
            
            i = parent(i);
        }
    }
    
    int extractMin() {
        if (heap_size<=0)
            return -1;
        
        if (heap_size == 1) {
            heap_size--;
            return harr[0];
        }
        
        int Min = harr[0];
        harr[0] = harr[heap_size-1];
        heap_size--;
        
        Heapify(0);
        
        return Min;
    }
}

