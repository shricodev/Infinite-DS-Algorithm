package Recursions;
public class SubsequencesOfString {
    public static void main(String[] args) {
        subsequencesString("pabloescobarisamotherfucker", 0, "");
    }

    static void subsequencesString(String word, int index, String newString) {

        if(index == word.length()) {
            System.out.println(newString);
            return;
        }

        char currentCharacter = word.charAt(index);

        subsequencesString(word, index + 1, newString + currentCharacter);
        subsequencesString(word, index + 1, newString);
    }
}
