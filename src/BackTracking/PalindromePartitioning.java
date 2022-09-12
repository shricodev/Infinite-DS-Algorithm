package BackTracking;

import java.util.ArrayList;
import java.util.List;


public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "vikings";
        System.out.println(partition(s));

    }

    static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> output = new ArrayList<>();
        solve(0, s, ans, output);
        return ans;

    }

    private static void solve(int index, String s, List<List<String>> ans, List<String> output) {
        if (index >= s.length()) {
            ans.add(new ArrayList<>(output));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                output.add(s.substring(index, i + 1));
                solve(i + 1, s, ans, output);
                // backtrack the changes made to the array.
                output.remove(output.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
