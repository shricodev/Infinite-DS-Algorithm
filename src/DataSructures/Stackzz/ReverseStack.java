package DataSructures.Stackzz;

import java.util.Stack;

public class ReverseStack {
    
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
