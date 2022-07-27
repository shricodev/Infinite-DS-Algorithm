package Recursions.Subsets_Subsequence;

import java.util.ArrayList;

public class SubsequencesOfString {
    public static void main(String[] args) {
        
        printSubsequencesString("", "abc");
        // System.out.println(subsequencesArrayList("", "abc"));
        // System.out.println(subsequences("abc"));
        // System.out.println(subseqFind("abc"));

    }

    static void printSubsequencesString(String processed, String unProcess) {

        // since we are sending the substring in each function call so there will be time 
        // when the unprocessed string will be blank. so there will be no possible subsequences.
        if (unProcess.isEmpty()) {
            System.out.println(processed);
            return;
        }

        char ch = unProcess.charAt(0);

        printSubsequencesString(processed + ch, unProcess.substring(1));
        printSubsequencesString(processed, unProcess.substring(1));
    }


    static ArrayList<String> subsequences(String s) {
        
        ArrayList<String> ans = new ArrayList<>();
        String output = "";
        int index = 0;
        subseqArrayList(s, output, ans, index);
        return ans;
    }

    
    static ArrayList<String> subseqFind(String str) {
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
        solve(ans, output, index + 1, s);

        // this is the better way.
        // char ch = s.charAt(index);
        // solve(ans, output + ch, index + 1, s);
        

        // removing the last char from the string.
        output = output.substring(0, output.length() - 1);

        // exclude
        solve(ans, output, index + 1 , s);
    }
    
    private static void subseqArrayList(String s, String output, ArrayList<String> ans, int index) {

        if (index >= s.length()) {
            ans.add(output);
            return;
        }

        // include      
        char ch = s.charAt(index);
        subseqArrayList(s, output + ch, ans, index + 1);

        // exclude
        subseqArrayList(s, output, ans, index + 1);

    }


}
