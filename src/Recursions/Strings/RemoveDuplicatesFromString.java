package Recursions.Strings;
public class RemoveDuplicatesFromString {

    // To hold the tweenty six english alphabet.
    static boolean[] arr = new boolean[26];

    public static void main(String[] args) {
        removeDups("pizzaz", 0, "");
    }

    static void removeDups(String word, int index, String newStr) {

        // base case.
        if (index == word.length()) {
            System.out.println(newStr);
            return;
        }

        // when we subtract character from character then we get index value.
        // we are checking if character value there is already true in the array, if so
        // then call the function with a index value +1 and dont update the newstring.
        // 0 -> a
        // 1 -> b
        // 2 -> c
        // 3 -> d
        // .....
        // 25 -> z

        char currentCharacter = word.charAt(index);

        // -a gives the index of the character
        if (arr[currentCharacter - 'a'] == true) {

            removeDups(word, index + 1, newStr);

        } else {

            newStr += currentCharacter;

            // if new character is found then update the arr with the character index with
            // true.
            arr[currentCharacter - 'a'] = true;

            removeDups(word, index + 1, newStr);
        }
    }

}
