package Recursions.Strings;

import java.util.ArrayList;

public class Subse {
    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(subse(s));
    }

    static ArrayList<String> subse(String str) {
        ArrayList<String> ans = new ArrayList<>();
        String output = "";
        int index = 0;
        solve(ans, output, index, str);
        return ans;
    }

    private static void solve(ArrayList<String> ans, String output, int index, String s) {

        if (index >= s.length()) {
            ans.add(output);
            return;
        }

        // for include
        // if we do this way we need to remove the element from output as well.
        output = output + s.charAt(index);

        // this is the better way.
        // char ch = s.charAt(index);
        // solve(ans, output + ch, index + 1, s);
        solve(ans, output, index + 1, s);

        // removing the last char from the string.
        output = output.substring(0, output.length() - 1);

        // exclude
        solve(ans, output, index + 1 , s);
    }
}
