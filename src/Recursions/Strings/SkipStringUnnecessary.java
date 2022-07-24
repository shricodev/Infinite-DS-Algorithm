package Recursions.Strings;

public class SkipStringUnnecessary {
    public static void main(String[] args) {
        System.out.println(skipStringUnnecessary("hello guyswelcome!", "wel", "wellcomme"));
    }

    // skip the string only when the string doesnot contains a exception word.
    static String skipStringUnnecessary(String s, String skipWord, String exception) {

        if (s.isEmpty()) {
            return "";
        }

        char ch = s.charAt(0);

        if (s.startsWith(skipWord) && !(s.startsWith(exception))) {
            return skipStringUnnecessary(s.substring(skipWord.length()), skipWord, exception);
            
        } else {
            return ch + skipStringUnnecessary(s.substring(1), skipWord, exception);
        }
    }
    
}