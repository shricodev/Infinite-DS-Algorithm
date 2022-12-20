package SlidingWindow.Variable;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstrLen {

    public static void main(String[] args) {
        String s = "this is a test string";
        String t = "t stri";
        System.out.println(minWindow(s, t));    
    }

    public static int minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int ans = Integer.MAX_VALUE;

        // if the main string is lesser than the smaller string then return -1, since we cannot find a minm winodw of bigger string in a smaller string.
        if (s.length() < t.length()) {
            return -1;
        }

        int i = 0, j = 0;
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        
        // adding the values of the ch with the counts.
        for (int k = 0; k < m; k++) {
            char ch = t.charAt(k);
            if (!mp.containsKey(ch)) {
                mp.put(ch, 1);
            } else {
                mp.put(ch, mp.get(ch) + 1);
            }
        }

        // using the variable to optimize iterating through the array all the time.
        int count = mp.size();

        while (j < n) {
            char ch = s.charAt(j);
            if (mp.containsKey(ch)) {
                mp.put(ch, mp.get(ch) - 1);
                // if the count of the character is 0 then just decrease the count.
                if (mp.get(ch) == 0) count--;
            }

            // if the count is greater than zero then just increase the window size.
            if (count > 0) {
                j++;
            } else if (count == 0) {
                int windowSize = j - i + 1;
                ans = Math.min(ans, windowSize);

                // even if the count is zero then also we will iterate over and remove all the useless characters.
                while (count == 0) {
                    char removal = s.charAt(i);
                    // if the char is not in the map then we will decrease the size of the map and find the minimal ans.
                    if (!mp.containsKey(removal)) {
                        i++;
                        ans = Math.min(ans, j - i + 1);
                    } else {
                        // else if it contains then increase the count of the character and if the count is > 0 then we are running out of the character when decreasing the window size.
                        mp.put(s.charAt(i), mp.get(s.charAt(i)) + 1);
                        if (mp.get(s.charAt(i)) > 0) {
                            i++;
                            count++;
                        // even if char count is < 0 after increasing then just decrease and find the minm of the window size.
                        } else {
                            i++;
                            ans = Math.min(ans, j - i + 1);
                        }
                    }
                }
                j++;
            }
        }
        return ans;
    }
}
