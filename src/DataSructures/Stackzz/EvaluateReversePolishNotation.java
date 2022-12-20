package DataSructures.Stackzz;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();
        int n = tokens.length;

        for (int i = 0; i < n; i++) {
            String s = tokens[i];
            if (isOperator(s)) {
                int top = st.pop();
                int secondTop = st.pop();
                st.push(pushHelper(top, secondTop, s));
                continue;
            } else {
                st.push(Integer.valueOf(s));
            }
        }
        return st.peek();
    }

    private static int pushHelper(int top, int secondTop, String s) {
        if (s.equals("+")) return secondTop + top;
        else if (s.equals("-")) return secondTop - top;
        else if (s.equals("*")) return secondTop * top;
        else return secondTop / top; 
    }

    public static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
