package DynamicProgramming.Subsequences;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int open = n, close = n;
        String output = "";
        helper(ans, n, open, close, output);
        return ans;
    }

    public void helper(List<String> ans, int n, int open, int close, String output) {

        if (open == 0 && close == 0) {
            ans.add(output.toString());
            return;
        }

        // we can open the brackets all the time unless the count of open is 0.
        if (open != 0) {
            helper(ans, n, open - 1, close, output + "(");
        }
        
        // we can use open bracket only when the count of open is lesser than the count of close bracket.
        if (open < close) {
            helper(ans, n, open, close - 1, output + ")");
        }
    }
}
