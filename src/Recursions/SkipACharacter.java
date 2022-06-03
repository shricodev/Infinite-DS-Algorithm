package Recursions;
public class SkipACharacter {
    public static void main(String[] args) {
        skipChar("baccad", 0, 'a', "");
    }

    static void skipChar(String word, int index, char letter, String newWord) {

        // base condition
        if (index == word.length()) {
            System.out.println(newWord);
            return;
        }

        char currentChar = word.charAt(index);

        // If the letter is the character given by the user then do nothing and just
        // recursively call the function with one index increment.
        if (word.charAt(index) == letter) {

            skipChar(word, index + 1, letter, newWord);

        // if the letter is not the character given by the user then just recursively
        // call the function with one index increment and adding the character to the
        // new word.
        } else {

            skipChar(word, index + 1, letter, newWord + currentChar);
        }
    }
}