package DataSructures.Queuess;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingChars {

    public static void main(String[] args) {
        System.out.println(FirstNonRepeating("aabc"));
    }

    // using the queue since we need to check for the first non repeating char which is done with queue.
    public static String FirstNonRepeating(String s) {
        // code here
        int n = s.length();
        Queue<Character> q = new LinkedList<>();
        int[] map = new int[26];
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            q.add(ch);
            map[ch - 'a'] += 1;
            
            int size = q.size();
            for (int j = 0; j < size; j++) {
                char c = q.peek();
                if (map[c - 'a'] > 1) {
                    q.remove();
                } else {
                    sb.append(c);
                    break;
                }
            }
            // so if the queue is empty then there was no non repeating char so add '#' 
            if (q.isEmpty()) {
                sb.append('#');
            }
        }
        return sb.toString();
    }
}
