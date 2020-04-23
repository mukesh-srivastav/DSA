package Heap;

/**
 * Heap Sort Algorithm:
1. Build a max heap from the input data.
2. At this point, the largest item is stored at the root of the heap. Replace it with the last item of the heap followed by reducing the size of heap by 1. Finally, heapify the root of tree.
3. Repeat above steps while size of heap is greater than 1.
 */
public class HeapSort {
    
    /**
     * HeapSort Constructor
     * @param a
     * @param n
     */
    public HeapSort(int a[], int n) {
        this.buildHeap(a, n);
        for (int i=n-1; i>=0; i--) {
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            heapify(a, i, 0);
        }
    }

    void buildHeap(int a[], int n)
    {
        for (int i=n/2-1; i>=0; i--) {
            heapify(a, n, i);
        }
    }
 

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int a[], int n, int i)
    {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i + 2;
        
        if (left<n && a[left] > a[largest]) {
            largest = left;
        }
        
        if (right<n && a[right] > a[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            int l = a[largest];
            a[largest] = a[i];
            a[i] = l;
            heapify(a, n, largest);
        }
    }
}