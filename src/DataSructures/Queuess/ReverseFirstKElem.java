package DataSructures.Queuess;

import java.util.Queue;

class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
        helper(q, k);
        // now the queue will have the reversed element to the end of the queue.
        int nMinusK = q.size() - k;
        for (int i = 0; i < nMinusK; i++) {
            int temp = q.poll();
            q.add(temp);
        }
        return q;
    }

    private void helper(Queue<Integer> q, int k) {
        if (k == 0) {
            return;
        }

        int num = q.poll();
        helper(q, k - 1);

        q.add(num);
    }
}
