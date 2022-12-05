package DataSructures.Stackzz;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        long[] arr = {1,3,2,4};
        System.out.println(nextLargerElement(arr, 4));
    }

    // if there is no greater element then put -1.
    public static long[] nextLargerElement(long[] arr, int n) {
        // Your code here
        Stack<Long> st = new Stack<>();
        long[] ans = new long[n];
        // for handling when there is no greater element.
        st.add((long) -1);
        for (int i = n - 1; i >= 0; i--) {
            
            long curr = arr[i];
            // for finding just smaller element just remove the st.peek() != -1 extra condn.
            while (st.peek() <= curr && st.peek() != -1) {
                st.pop();
            }
            ans[i] = st.peek();
            st.add(curr);
        }
        return ans;
    }
}
