package DataSructures.Stackzz;

public class MinmAddToMakeParenthesisValid {
    
    // note: i am not using stack here but this problem uses stack.
    // this is more efficient code.
    public int minAddToMakeValid(String s) {
        if (s.length() == 0) return 0;
        int open = 0;
        int close = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') open++;
            else {
                if (open == 0) close++;
                else open--;
            }
        }
        // no of invalid one's are required to make it valid.
        return open + close;
    }
}
