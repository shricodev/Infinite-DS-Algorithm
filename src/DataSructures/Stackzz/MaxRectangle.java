package DataSructures.Stackzz;

import java.util.Stack;

public class MaxRectangle {

    public static void main(String[] args) {
        int[][] matrix = {
            {1,0,1,0,0},
            {1,0,1,1,1}, 
            {1,1,1,1,1},
            {1,0,0,1,0}
        };
        System.out.println(maximalRectangle(matrix));
    }

    // tc: O(n x m)
    // sc: O(m)
    public static int maximalRectangle(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int area = largestRectangleArea(matrix[0]);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j];
                } else {
                    matrix[i][j] = 0;
                }
            }
            int tempArea = largestRectangleArea(matrix[i]);

            area = Math.max(area, tempArea);
        }
        return area;
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;
        int[] nextSmallerInd = findNextSmaller(heights, n);
        int[] prevSmallerInd = findPrevSmaller(heights, n);
        
        for (int i = 0; i < n; i++) {
            if (nextSmallerInd[i] == -1) {
                nextSmallerInd[i] = n;
            }
            int length = heights[i];
            int breadth = nextSmallerInd[i] - prevSmallerInd[i] - 1;
            int area = length * breadth;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static int[] findNextSmaller(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        // for handling when there is no greater element.
        st.add(-1);
        for (int i = n - 1; i >= 0; i--) {
            
            int curr = arr[i];
            // for finding just smaller element just remove the st.peek() != -1 extra condn.
            while (st.peek() != -1 && arr[st.peek()] >= curr) {
                st.pop();
            }
            ans[i] = st.peek();
            st.add(i);
        }
        return ans;
    }
    
    public static int[] findPrevSmaller(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        // for handling when there is no greater element.
        int[] ans = new int[n];
        st.add(-1);
        for (int i = 0; i < n; i++) {
            
            int curr = arr[i];
            while (st.peek() != -1 && arr[st.peek()] >= curr) {
                st.pop();
            }
            ans[i] = st.peek();
            st.add(i);
        }
        return ans;
    }  
}
