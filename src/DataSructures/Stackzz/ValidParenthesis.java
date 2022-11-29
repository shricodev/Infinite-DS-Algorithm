package DataSructures.Stackzz;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        System.out.println(ispar("{)}"));
    }

    static boolean ispar(String x) {

        // add your code here
        int len = x.length();
        if (len % 2 != 0) return false;

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < len; i++) {
            char ch = x.charAt(i);

            if (!isClosed(ch)) {
                st.add(ch);
            }
            else {
                if (!st.isEmpty()) {
                    
                    char top = st.peek();
                    if (isMatch(ch, top)) {
                        st.pop();
                    } 
                    else return false;
                }
                else {
                    return false;
                }
            }
        }

        if (st.isEmpty()) return true;
        return false;
    }

    private static boolean isMatch(char ch, char top) {
        if (top == '(' && ch == ')' || top == '{' && ch == '}' || top == '[' && ch == ']') return true;
        return false;
    }

    private static boolean isClosed(char ch) {
        return ch == '}' || ch == ']' || ch == ')';
    }
}
