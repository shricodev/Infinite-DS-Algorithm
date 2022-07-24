package Recursions.Strings;

import java.util.ArrayList;

public class SubsequencesOfString {
    public static void main(String[] args) {
        
        // printSubsequencesString("", "abc");
        // System.out.println(subsequencesArrayList("", "abc"));
        System.out.println(subsequences("abc"));
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
