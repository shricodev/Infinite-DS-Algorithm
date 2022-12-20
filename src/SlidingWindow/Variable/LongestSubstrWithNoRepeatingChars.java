package SlidingWindow.Variable;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        int i = 0, j = 0;
        int maxi = 0;

        while (j < n) {

            char ch = s.charAt(j);

            // increase the character count.
            if (!mp.containsKey(ch)) {
                mp.put(ch, 1);
            } else {
                mp.put(ch, mp.get(ch) + 1);
            }

            if (mp.size() == j - i + 1) {
                maxi = Math.max(maxi, j - i + 1);
                j++;

            } else if (mp.size() < j - i + 1) {
                while (mp.size() < j - i + 1) {
                    char removalCh = s.charAt(i);
                    mp.put(removalCh, mp.get(removalCh) - 1);
                    if (mp.get(removalCh) == 0) {
                        mp.remove(removalCh);
                    }
                    i++;
                }
                j++;
            }
        }
        return maxi;
    }
}
