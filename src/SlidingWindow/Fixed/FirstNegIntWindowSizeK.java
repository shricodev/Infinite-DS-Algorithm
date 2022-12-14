package SlidingWindow.Fixed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Compute {

    public List<Long> printFirstNegativeInteger(long arr[], int n, int k) {

        Queue<Long> q = new LinkedList<>();
        List<Long> ans = new ArrayList<>();
        int i = 0, j = 0;

        while (j < n) {

            if (arr[j] < 0) {
                q.add(arr[j]);
            }

            // if the winodw is made of size k then shift the window.
            if (j - i + 1 == k) {
                if (!q.isEmpty()) {
                    ans.add(i, q.peek());
                } else {
                    ans.add(i, (long) 0);
                }

                // before shifting the window check if there was a -ve value at ith index. is so then remove from deque.
                if (arr[i] < 0 && !q.isEmpty()) {
                    q.remove();
                }
                // now shift the window.
                i++;
            }

            j++;
        }
        return ans;
    }
}

