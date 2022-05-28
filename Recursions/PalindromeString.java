import java.lang.String;

public class PalindromeString {
    public static void main(String[] args) {
        String word = (String) ("1234321");
        // String word = "mom";
        System.out.println(checkPalindrome(word, 0, word.length() - 1));
    }

    static boolean checkPalindrome(String s, int start, int end) {
        // base condition.
        if (start == end) {
            return true;
        }

        // checking condition.
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }

        return checkPalindrome(s, start + 1, end - 1);
    }
}
