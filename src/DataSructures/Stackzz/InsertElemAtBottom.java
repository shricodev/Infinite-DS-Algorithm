package DataSructures.Stackzz;

import java.util.Stack;

public class InsertElemAtBottom {
    
    public static Stack<Integer> insertBottom(int x, Stack<Integer> st) {
        solve(st, x);
        return st;
    }

    private static void solve(Stack<Integer> st, int x) {

        if (st.isEmpty()) {
            st.add(x);
            return;
        }

        int num = st.pop();
        solve(st, x);

        st.add(num);
    }
}
