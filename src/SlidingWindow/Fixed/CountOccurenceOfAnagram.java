package SlidingWindow.Fixed;

class Solution {

    int search(String pat, String txt) {
        // code here
        int n = txt.length();
        int k = pat.length();
        int ans = 0;
        int[] map = new int[26];

        for(int i = 0; i < k; i++) {
            char ch = pat.charAt(i);
            map[ch - 'a']++;
        }

        int i = 0; int j = 0;

        while (j < n) {
            map[txt.charAt(j) - 'a']--;

            if (j - i + 1 == k) {
                if (allZero(map)) {
                    // for geeks for geeks
                    ans++;
                    // for leetcode. create ans arraylist.
                    // ans.add(i);
                }
                map[txt.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }
        return ans;
    }

    private boolean allZero(int[] map) {
        for (int i : map) {
            if (i != 0) return false;
        }
        return true;
    }
}
