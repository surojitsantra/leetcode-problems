class Solution {

    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            }
        );
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { nums[i], i });
        }

        int ans = 0, mod = 1000000007;
        for (int i = 1; i <= right; i++) {
            int[] p = pq.poll();
            if (i >= left) ans = (ans + p[0]) % mod;
            if (p[1] < n - 1) {
                p[0] += nums[++p[1]];
                pq.offer(p);
            }
        }
        return ans;
    }
}