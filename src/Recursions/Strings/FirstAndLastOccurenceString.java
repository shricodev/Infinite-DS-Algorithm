package Recursions.Strings;
public class FirstAndLastOccurenceString {

    // initiating the variable with a -1 first so if the letter is not in the list
    // the value -1 will be returned.
    static int first = -1;
    static int last = -1;

    public static void main(String[] args) {
        checkOccurences("hello", 'e', 0);
        System.out.println(first);
        System.out.println(last);
    }

    static void checkOccurences(String word, char letter, int index) {

        // is the index is same as the length of the word then just return.
        // base case.
        if (index == word.length()) {
            // this handles the edge case for only appearance of the letter one time in the word.
            if (first != -1 && last == -1) {
                last = first;
            }
            return;
        }

        if (word.charAt(index) == letter) {

            // if first is equal to -1 then the variable is not accessed so the first index
            // is equal to the current index
            if (first == -1) {
                first = index;
            } else {
                // its value keeps on changing with every occurances.
                last = index;
            }
        }

        checkOccurences(word, letter, index + 1);

    }

}
