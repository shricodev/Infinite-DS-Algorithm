package LeetcodeDaily;


public class DetermineStringHalvesAlike {
    
    String VOWELS = "aeiouAEIOU";
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
        return VOWELS.indexOf(ch) != -1;
    }
}