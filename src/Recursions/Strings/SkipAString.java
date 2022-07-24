package Recursions.Strings;

public class SkipAString {
    public static void main(String[] args) {
        System.out.println(skipString("hello guyswelcome!", "guys"));
    }

    static String skipString(String s, String skipWord) {

        if (s.isEmpty()) {
            return "";
        }

        char ch = s.charAt(0);

        if (s.startsWith(skipWord)) {
            return skipString(s.substring(skipWord.length()), skipWord);
            
        } else {
            return ch + skipString(s.substring(1), skipWord);
        }
    }
    
}