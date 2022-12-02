package DataSructures.Stackzz;

import java.util.Stack;

public class SortAStackRec {

    public Stack<Integer> sort(Stack<Integer> st) {
        // add code here.
        helper(st);
        return st;
    }

    private void helper(Stack<Integer> st) {

        if (st.isEmpty()) {
            return;
        }

        int num = st.pop();
        helper(st);

        sortedInsert(num, st);
    }

    // fxn to insert the num to the right place in the stack.
    private void sortedInsert(int num, Stack<Integer> st) {
        if (st.isEmpty()) {
            st.add(num);
            return;
        }
        
        // if stack top is less than the num then add the num and return.
        if (st.peek() < num) {
            st.add(num);
            return;
        }

        int top = st.pop();

        sortedInsert(num, st);

        // when backtracking add the removed element to the top.
        st.add(top);
    }
}
