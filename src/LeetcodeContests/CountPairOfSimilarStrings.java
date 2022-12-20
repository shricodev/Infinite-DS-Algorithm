package LeetcodeContests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int similarPairs(String[] words) {
        int count = 0;
        List<Set<Character>> set = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {

            for (String word : words) {
                set.add(getChars(word));
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (set.get(i).equals(set.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }

    private Set<Character> getChars(String word) {
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            chars.add(word.charAt(i));
        }
        return chars;
    }
}
