package LeetcodeContests;

public class CircularSentence {
    
    public boolean isCircularSentence(String sentence) {

        String[] words = sentence.split(" ");
        int n = words.length;

        if (words.length == 1) {
            return words[0].charAt(0) == words[0].charAt(words[0].length() - 1);
        }

        if (words[0].charAt(0) != words[n - 1].charAt(words[n - 1].length() - 1)) {
            return false;
        }

        for (int i = 1; i < n; i++) {
            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
