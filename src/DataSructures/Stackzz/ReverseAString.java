package DataSructures.Stackzz;

import java.util.Stack;

public class ReverseAString {
    
    public String reverse(String S){
        //code here
        Stack<Character> st = new Stack<>();
        int pointer = 0;
        int len = S.length();
        while (pointer != len) {
            st.add(S.charAt(pointer));
            pointer++;
        }
        String rev = "";
        while (!st.isEmpty()) {
            char s = st.pop();
            rev += s;
        }
        return rev;
    }
}
