class Solution {
    // this is not my code BTW, I saw this code online and I loved it.
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int mini = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 == 1) {
                num *= 2;
            }
            pq.offer(num);
            mini = Math.min(mini, num);
        }
        int res = Integer.MAX_VALUE;
        while (true) {
            int maxi = pq.poll();
            res = Math.min(res, maxi - mini);
            if (maxi % 2 == 1) {
                break;
            }
            maxi /= 2;
            mini = Math.min(mini, maxi);
            pq.offer(maxi);
        }
        return res;
    }
}