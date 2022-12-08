package DataSructures.Stackzz;

import java.util.Stack;

public class SpecialStack {

    /*----------------- Public Functions of SpecialStack -----------------*/
    int mini = Integer.MAX_VALUE;

    public void push(int data, Stack<Integer> st) {
        // add code here.
        if (st.isEmpty()) {
            st.push(data);
            mini = data;
        } else {
            if (data < mini) {
                int val = 2 * data - mini;
                st.push(val);
                mini = data;
            } else {
                st.push(data);
            }
        }
    }

    public int pop(Stack<Integer> st) {
        // add code here.
        if (st.isEmpty())
            return -1;
        int curr = st.pop();

        if (curr > mini) {
            return curr;
        } else {
            int prevMin = mini;
            int val = 2 * mini - curr;
            mini = val;
            return prevMin;
        }
    }

    public int getMin(Stack<Integer> st) {
        // add code here.
        if (st.isEmpty())
            return -1;
        return mini;
    }

    public boolean isFull(Stack<Integer> st, int n) {
        // add code here.
        return (st.size() == n);
    }

    public boolean isEmpty(Stack<Integer> st) {
        // add code here.
        return st.isEmpty();
    }
}
