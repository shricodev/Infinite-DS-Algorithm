package LeetcodeDaily;

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            
            while (!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) {
                st.pop();
            }
            // not needed since the stack is already initialized with 0.
            if (st.empty()) ans[i] = 0;
            
            if (!st.empty()) {
                ans[i] = st.peek() - i;
            }

            st.add(i);
        }
        return ans;
    }
}
