package SlidingWindow.Variable;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        int ans = 0;
        int n = fruits.length;
        int maxType = 2;
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int i = 0, j = 0;
        int fruitsCount = 0;

        while (j < n) {
            int fruitType = fruits[j];
 
            // increase the fruits count.
            if (!mp.containsKey(fruitType)) {
                mp.put(fruitType, 1);
                fruitsCount++;
            } else {
                mp.put(fruitType, mp.get(fruitType) + 1);
                fruitsCount++;
            }

            if (mp.size() < maxType) {
                ans = Math.max(ans, fruitsCount);
                j++;
            } else if (mp.size() == maxType) {
                ans = Math.max(ans, fruitsCount);
                j++;
            } else {
                // if the size of the map is greater than the k then remove elements count 
                // and if the count is zero then remove the element from the map since it is not in the window size anymore.
                while (mp.size() > maxType) {
                    int removal = fruits[i];
                    mp.put(removal, mp.get(removal) - 1);
                    fruitsCount--;
                    if (mp.get(removal) == 0) {
                        mp.remove(removal);
                    }
                    i++;
                }
                j++;
            }
        }
        return ans;
    }
}
