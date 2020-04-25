package Heap;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

/*a is an array of Nodes of the heads of linked lists
  and N is size of array a*/
public  class MergeKSortedLists {
      
    Node mergeKList(Node[]a,int N) {

        Node current = null;
        MinHeap mh = new MinHeap(N);
          
        for (int i=0; i<N; i++) {
            mh.add(a[i]); 
        }
        
        Node res = null;
          
        while(!mh.isEmpty()) {
            Node min = mh.extractMin();
            if (min.next!=null) {
                mh.add(min.next);
            }
              
            if (current==null) {
                current = new Node(min.data);
            } else {
                current.next = new Node(min.data);
                current = current.next;
            }
            
            if (res==null) {
                res = current;
            }
        }
          
        return res;
    }
}
  
class MinHeap {
    int capacity;
    int heap_size;
    Node heap[];
    
    public MinHeap(int cap) {
        capacity = cap;
        heap_size = 0;
        heap = new Node[cap];
    }
    
    boolean isEmpty() {
        return (heap_size == 0);    
    }
    
    int left (int i) {
        return 2*i + 1;
    }
    
    int right(int i) {
        return 2*i+2;
    }
    
    int parent(int i) {
        return (i-1)/2;
    }
    
    Node getMin() {
        return heap[0];
    }
    
    void Heapify (int i) {
        int smallest = i;
        int left = left(i);
        int right = right(i);
        
        if (left<heap_size && heap[left].data < heap[smallest].data) {
            smallest = left;
        }
        
        if (right<heap_size && heap[right].data < heap[smallest].data) {
            smallest = right;
        }
        
        if (smallest != i) {
            Node t = heap[smallest];
            heap[smallest] = heap[i];
            heap[i] = t;
            
            Heapify(smallest);
        }
    }
    
    void add(Node k) {
        
        if (heap_size == capacity) {
            return;
        }
        
        heap_size++;
        int i = heap_size - 1;
        heap[i] = k;
        
        while (i!=0 && heap[parent(i)].data > heap[i].data) {
            
            Node t = heap[parent(i)];
            heap[parent(i)] = heap[i];
            heap[i] = t;
            
            i = parent(i);
        }
    }
    
    Node extractMin () {
        if (heap_size<=0) {
            return new Node(-1);
        }
        
        if (heap_size == 1) {
            heap_size --; 
            return heap[0];
        }
        
        Node root = heap[0];
        heap[0]  = heap[heap_size -1];
        heap_size--;
        
        Heapify(0);
        
        return root;
    }
}
  