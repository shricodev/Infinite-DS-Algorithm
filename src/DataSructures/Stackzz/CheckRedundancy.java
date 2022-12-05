package DataSructures.Stackzz;

import java.util.Stack;

public class CheckRedundancy {

    // the idea is if there is no operator between two parenthesis then the parenthesis is considered redundant.
    public static int checkRedundancy(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                st.add(ch);
            } else {
                if (ch == ')') {
                    boolean isRedundant = true;
                    while (st.peek() != '(') {
                        char top = st.peek();
                        if (top == '*' || top == '+' || top == '-' || top == '/') {
                            isRedundant = false;
                        }
                        st.pop();
                    }
                    // this pop is for the pair open bracket found.
                    st.pop();
                    if (isRedundant)
                        return 1;
                }
            }
        }
        return 0;
    }
}
