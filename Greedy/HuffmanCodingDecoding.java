package Greedy;

import java.io.*;
import java.util.*;

/**
 * The task is to implement Huffman Encoding and Decoding.
 * https://www.geeksforgeeks.org/greedy-algorithms-set-3-huffman-coding/
 * https://www.geeksforgeeks.org/huffman-decoding/
 */
class minHeapNode {
    char data;
    int freq;
    minHeapNode left, right;
    minHeapNode(char data, int freq){
        left = right = null;
        this.data = data;
        this.freq = freq;
    }
}

class heapComparator implements Comparator<minHeapNode> {
    public int compare(minHeapNode h1, minHeapNode h2) { 
        if (h1.freq < h2.freq) {
            return 1;
        } else if (h1.freq > h2.freq) {
            return -1;
        }
        return 0; 
    } 
} 

class HuffmanCoding {
    
    static PriorityQueue<minHeapNode> heapq;
    static HashMap<Character, Integer> freqMap;
    static HashMap<Character, String> codes;
    
    // Storing values from Huffman Heap into HashMap.
    static void storeCodes(minHeapNode root, String str) {
        if(root==null)return;
        if(root.data != '$')codes.put(root.data, str);
        storeCodes(root.left, str + "0");
        storeCodes(root.right, str + "1");
    }
    
    // Building the heap.
    static void encodeString(){
        minHeapNode left, right, top;
        for (Map.Entry<Character, Integer> val:freqMap.entrySet()) {
            heapq.add(new minHeapNode(val.getKey(), val.getValue()));
        }
        while (heapq.size() != 1) {
            left = heapq.poll();
            right = heapq.poll();
            top = new minHeapNode('$', left.freq + right.freq);
            top.left = left;
            top.right = right;
            heapq.add(top);
        }
        storeCodes(heapq.peek(), "");
    }
    
    // Setting Frequency array.
    static void calcFreq(String str) {
        for (int i=0; i<str.length(); i++) { 
            Integer j = freqMap.get(str.charAt(i)); 
            freqMap.put(str.charAt(i), (j == null) ? 1 : j + 1); 
        } 
    }
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String str = br.readLine().trim();
            heapq = new PriorityQueue<minHeapNode>(new heapComparator());
            codes = new HashMap<Character, String>();
            freqMap = new HashMap<Character, Integer>();
            
            String encodedString = "";
            calcFreq(str);
            encodeString();
            for(int i=0; i<str.length(); i++){
                encodedString+=codes.get(str.charAt(i));
            }
            HuffmanDecoding g = new HuffmanDecoding();
            System.out.println(g.decodeString(heapq.peek(), encodedString));
        }
    }
}


//User function Template for Java
class HuffmanDecoding {
    // your required to complete this function
    // this function should return the encoded string
    // see the main function for the minHeapNode reference
    String decodeString(minHeapNode root, String encodedStr){
        String s = "";
        
        minHeapNode curr = root;
        int n = encodedStr.length();
        
        for (int i=0; i<n; i++) {
            if (encodedStr.charAt(i) == '0')
                curr = curr.left;
            else
                curr = curr.right;
            
            if (curr.left == null && curr.right == null) {
                s += curr.data;
                curr = root;
            }
        }
        
        return s;
    }
}