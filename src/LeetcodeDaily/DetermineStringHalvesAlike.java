package LeetcodeDaily;

public class DetermineStringHalvesAlike {
    

    public boolean halvesAreAlike(String s) {
        
        int countFirstHalf = 0;
        int mid = s.length() / 2;

        for (int i = 0; i < mid; i++) {
            if (isVowel(s.charAt(i))) countFirstHalf++;
        }
        int countSecondHalf = 0;
        for (int i = mid; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) countSecondHalf++;
        }
        return countFirstHalf == countSecondHalf;

        
    }

    boolean  isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}