package DataSructures.Stackzz;

import java.util.Stack;

public class ReverseStackRecursion {
    

    // time complexity; o(n^2)
    // another approach would be iterating the stack1 and pushing it to stack2 recursively and return the stack2 at the last. O(n) time
    private static void reverseStack(Stack<Integer> st) {

        if (st.isEmpty()) return;

        int num = st.pop();
        reverseStack(st);
        // when returning we add the num value to the very last of the stack using the insertBottom function.
        insertBottom(st, num);
    }


    private static void insertBottom(Stack<Integer> st, int x) {

        if (st.isEmpty()) {
            st.add(x);
            return;
        }

        int num = st.pop();
        insertBottom(st, x);

        st.add(num);
    }
}
