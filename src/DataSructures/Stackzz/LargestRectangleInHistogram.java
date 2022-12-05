package DataSructures.Stackzz;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
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