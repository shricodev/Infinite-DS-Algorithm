package DataSructures.Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Pair {
    String word;
    int steps;
    public int distance;

    public Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}

public class WordLadder1 {

    // time complexity; O(n x m x 26)
    // space complexity; O()
    public int wordLadderLength(String startWord, int targetWord, String[] wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1));
        Set<String> st = new HashSet<>();
        // adding the list in the set to reduce the time complexity.
        for (int i = 0; i < wordList.length; i++) {
            st.add(wordList[i]);
        }
        // st.remove() acts as a vis[i] = true;
        st.remove(startWord);

        while (!q.isEmpty()) {
            String word = q.peek().word;
            int steps = q.peek().steps;
            if (word.equals(targetWord) == true)
                return steps;
            q.remove();

            for (int i = 0; i < word.length(); i++) {
                // for every index of the word, we are trying out every single char.
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedChArr = word.toCharArray();
                    replacedChArr[i] = ch;
                    String replacedWord = new String(replacedChArr);

                    if (st.contains(replacedWord) == true) {
                        q.add(new Pair(replacedWord, steps + 1));
                        st.remove(replacedWord);
                    }
                }
            }
        }
        return 0;
    }
}
