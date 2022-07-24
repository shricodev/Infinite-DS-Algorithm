package Recursions.Strings;
import java.lang.String;

public class PalindromeString {
    public static void main(String[] args) {
        String word = (String) ("1234321");
        // String word = "mom";
        // System.out.println(checkPalindromeParameterized(word, 0, word.length() - 1));
        System.out.println(checkPalindromeFunctional(word, 0, word.length()));
    }

    static boolean checkPalindromeParameterized(String s, int start, int end) {
        // base condition.
        if (start == end) {
            return true;
        }

        // checking condition.
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }

        return checkPalindromeParameterized(s, start + 1, end - 1);
    }

    // the only differnce is that we are not using the pointer for checking if the
    // string is a palindrome or not.
    static boolean checkPalindromeFunctional(String s, int i, int n) {

        if (i >= s.length() / 2) return true;

        if (s.charAt(i) != s.charAt(n-i-1)) return false;

        return checkPalindromeFunctional(s, i+1, n);

    }

}
