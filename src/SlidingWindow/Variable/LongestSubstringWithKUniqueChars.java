package SlidingWindow.Variable;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int n = s.length();
        int maxi = -1;
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        int i = 0, j = 0;

        while (j < n) {

            char ch = s.charAt(j);

            // increase the character count.
            if (!mp.containsKey(ch)) {
                mp.putIfAbsent(ch, 1);
            } else {
                mp.put(ch, mp.get(ch) + 1);
            }

            if (mp.size() < k) {
                j++;
            } else if (mp.size() == k) {
                maxi = Math.max(maxi, j - i + 1);
                j++;
            } else {
                // if the size ofthe map is greater than the unique chars then remove elements count 
                // and if the count is zero then remove the element from the map since it is not in the window size anymore.
                while (mp.size() > k) {
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
