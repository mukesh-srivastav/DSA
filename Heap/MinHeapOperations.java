package Heap;

public class MinHeapOperations {

    int[] harr; 
    int capacity; 
    int heap_size;
    
    MinHeapOperations(int cap) {
        heap_size = 0;
        capacity = cap; 
        harr = new int[cap];
    }
    
    int parent(int i) { return (i-1)/2; }
    int left(int i) { return (2*i + 1); }
    int right(int i) { return (2*i + 2); }
        
    
    int extractMin()
    {
        if (heap_size<=0)
            return -1;
        if (heap_size==1) {
            heap_size--;
            return harr[0];
        }
        
        int k = harr[0];
        harr[0] = harr[heap_size-1];
        heap_size--;
        MinHeapify(0);
        
        return k;
    }
    
    
    void insertKey(int k)
    {
        if (heap_size == capacity) {
            return;
        }
        
        heap_size++;
        int i = heap_size - 1;
        harr[i] = k;
        
        while (i!=0 && harr[parent(i)] > harr[i]) {
            int t = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = t;
            i = parent(i);
        }
    }

    void deleteKey(int i)
    {
        if (i>=heap_size) 
            return;
        
        decreaseKey(i, -1);
        extractMin();
        
    }
    
    // Decrease key operation, helps in deleting the element
    void decreaseKey(int i, int new_val)
    {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i])
        {
            int temp = harr[i] ;
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }
    
    /* You may call below MinHeapify function in 
        above codes. Please do not delete this code
        if you are not writing your own MinHeapify */
    void MinHeapify(int i)
    {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i])
            smallest = l;
        if (r < heap_size && harr[r] < harr[smallest])
            smallest = r;
        if (smallest != i)
        {
            int temp = harr[i] ;
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            MinHeapify(smallest);
        }
    }
    
}