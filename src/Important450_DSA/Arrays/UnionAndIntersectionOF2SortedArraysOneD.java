package Important450_DSA.Arrays;

import java.util.HashSet;

public class UnionAndIntersectionOF2SortedArraysOneD {
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6 };
        int b[] = { 1, 2, 3 };
        System.out.println(union(a, a.length - 1, b, b.length - 1));

    }

    // this method should return the no of union element in a and b of size n and m
    // respectively
    static int union(int a[], int n, int[] b, int m) {
        
        
            //using HashSet to store the elements. It stores only unique element.
            HashSet<Integer> s=new HashSet<>();
            
        	for(int i = 0;i<n;i++)
        	   s.add(a[i]);
        	    

        	 for(int i = 0;i<m;i++)
        	    s.add(b[i]);
        	    
        	  return s.size() ;
        	    
    }

    }
