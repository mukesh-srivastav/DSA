/**
 * Given a matrix mat[][] of size M*N. Traverse and print the matrix in spiral form
 */


import java.util.*;
import java.io.*;

class SpirallyTraversingMatrix {
    static void print(int m, int n, int a[][]){
        int i, k=0, l=0;
        
        while(k<m && l<n) {
            //Print top
            for(i=l; i<n;i++){
                System.out.print(a[k][i]+" ");
            }
            k++;
            
            //Print right
            for(i=k; i<m; i++){
                System.out.print(a[i][n-1]+" ");
            }
            n--;
            
            if(k<m){
                //Print bottom 
                for(i=n-1; i>=l; i--){
                    System.out.print(a[m-1][i]+" ");
                }
                m--;
            }
            
            if(l<n){
                //Print left
                for(i=m-1; i>=k; i--){
                    System.out.print(a[i][l]+" ");
                }
                l++;
            }
        }
    }
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
 		int t  = sc.nextInt();
 		while(t-->0){
 		    int m = sc.nextInt();
		    int n = sc.nextInt();
 		    
 		    int a[][] = new int[m][n];
 		    
 		    for(int i=0; i<m; i++){
 		        for(int j=0; j<n; j++){
 		            a[i][j] = sc.nextInt();
 		        }
 		    }
 		    
 		    print(m,n,a);
 		    System.out.println();
 		}
	}
}