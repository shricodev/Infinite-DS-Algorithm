package Recursions.Strings;
public class MoveAllXToEndString {
    public static void main(String[] args) {
        moveX("naunghtny", 0, 'n', 0, "");
    }


    static void moveX(String str, int index, char letter, int count, String newString) {

        // base condition
        if (index == str.length()) {

            // adding the letter to the end of the string with reference to the count variable.
            for(int i = 1; i <= count; i++) {
                newString += letter;
            }
            // printing the output to the screen.
            System.out.println(newString);
            return;
        }


        if (str.charAt(index) == letter) {

            // increasing the count variable everytime the character is found.
            count += 1;
            moveX(str, index + 1, letter, count, newString);

        // else is must in this code. otherwise it will misbehave.
        } else {

            // if the character is not found then adding the character in the newString variable.
            newString += str.charAt(index);

            // we are not increasing count in this because this code runs for letters except x
            moveX(str, index + 1, letter, count, newString);
        }

    }
}