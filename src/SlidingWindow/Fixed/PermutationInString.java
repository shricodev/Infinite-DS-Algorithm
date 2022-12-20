package SlidingWindow.Fixed;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int n = s2.length();
        int[] map = new int[26];
        
        // we keep track of the char of the pattern.
        for (int i = 0; i < k; i++) {
            char ch = s1.charAt(i);
            map[ch - 'a']++;
        }

        int i = 0, j = 0;

        while (j < n) {
            // initial calculation.
            map[s2.charAt(j) - 'a']--;

            if (j - i + 1 == k) {
                if (allZero(map)) {
                    return true;
                } else {
                    // before shifting the window, increase the char at i val.
                    map[s2.charAt(i) - 'a']++;
                    i++;
                }
            }
            j++;
        }

        return false;
    }

    private boolean allZero(int[] map) {
        
        for (int i : map) {
            if (i != 0) return false;
        }
        return true;
    }
}
