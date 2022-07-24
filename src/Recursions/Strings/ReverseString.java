package Recursions.Strings;
public class ReverseString {
    public static void main(String[] args) {
        String word = "Hello";
        printReverse(word, word.length() - 1);
    }

    static void printReverse(String word, int index) {

        // base condition.
        if (index == 0) {
            System.out.print(word.charAt(0));
            return;
        }
        
        System.out.print(word.charAt(index));

        // recursive leap of faith.
        printReverse(word, index - 1);
    }
}
