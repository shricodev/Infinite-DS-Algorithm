package LeetcodeDaily;



import java.util.Arrays;

public class DetermineIfTwoStringsClose {

    public static void main(String[] args) {
        System.out.println(closeStrings("cabbba", "abbccc"));
    }
    
    // condn1: all alphabets must be present of one in another.
    // condn2: the frequencies of letters should be same no matter the character.
    public static boolean closeStrings(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        if (len1 != len2) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int[] alphaCount1 = new int[26];
        int[] alphaCount2 = new int[26];
        
        // since the size of both is same so don't need to run the loop twice.
        for (int i = 0; i < len1; i++) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);
            freq1[ch1 - 'a']++;
            freq2[ch2 - 'a']++;
            alphaCount1[ch1 - 'a'] = 1;
            alphaCount2[ch2 - 'a'] = 1;

        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2) && Arrays.equals(alphaCount1, alphaCount2);

    }
}
