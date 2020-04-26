package Recursion;

import java.util.*;

/**
 * This algorithm is also used as fill/bucket tool in MS Paint.
 * Given a 2D screen, location of a pixel in the screen ie(x,y) and a color(K), your task is to replace color of the given pixel and all adjacent(excluding diagonally adjacent) same colored pixels with the given color K.

Example:

{{1, 1, 1, 1, 1, 1, 1, 1},
{1, 1, 1, 1, 1, 1, 0, 0},
{1, 0, 0, 1, 1, 0, 1, 1},
{1, 2, 2, 2, 2, 0, 1, 0},
{1, 1, 1, 2, 2, 0, 1, 0},
{1, 1, 1, 2, 2, 2, 2, 0},
{1, 1, 1, 1, 1, 2, 1, 1},
{1, 1, 1, 1, 1, 2, 2, 1},
 };

 x=4, y=4, color=3 

{{1, 1, 1, 1, 1, 1, 1, 1},
{1, 1, 1, 1, 1, 1, 0, 0},
{1, 0, 0, 1, 1, 0, 1, 1}, 
{1, 3, 3, 3, 3, 0, 1, 0},
{1, 1, 1, 3, 3, 0, 1, 0},
{1, 1, 1, 3, 3, 3, 3, 0},
{1, 1, 1, 1, 1, 3, 1, 1},
{1, 1, 1, 1, 1, 3, 3, 1}, };

Note: Use zero based indexing.
 */
public class FloodFillAlgorithm {

    public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0) {
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    
		    int a[][] = new int[n][m];
		    
		    for (int i=0; i<n; i++) {
		        for (int j=0; j<m; j++) {
		            a[i][j] = sc.nextInt();
		        }
		    }
		    
		    int x = sc.nextInt();
		    int y = sc.nextInt();
		    
		    int k = sc.nextInt();
		    int curr = a[x][y];
		    
		    floodfill(a, n, m, x, y, k, curr);
		    
		    for (int i=0; i<n; i++) {
		        for (int j=0; j<m; j++) {
		            System.out.print(a[i][j] + " ");
		        }
		    }
		    
		    System.out.println();
        }
        sc.close();
	}
	
	static void floodfill(int a[][], int n, int m, int x, int y, int k, int curr) {
	    if (x<0 || x>=n || y<0 || y>=m)
	        return;
	    if (a[x][y] !=curr)
	        return;
	    a[x][y] = k;
	    
	    floodfill(a, n, m, x+1, y, k, curr);
	    floodfill(a, n, m, x-1, y, k, curr);
	    floodfill(a, n, m, x, y-1, k, curr);
	    floodfill(a, n, m, x, y+1, k, curr);
	}
}