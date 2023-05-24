class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        final int N = nums1.length;
        
        int[][] nums = new int[N][2];
        
        for(int i = 0; i < N; i++) {
            nums[i]= new int[] {nums2[i], nums1[i]};
        }
        
        Arrays.sort(nums, (a, b)->b[0] -a[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a -b);
        
        long res = 0;
        long sum = 0;
        
        for(int[] num :nums) {
            minHeap.add(num[1]);
            sum += num[1];
            
            if(minHeap.size() > k) {
                sum -= minHeap.poll();
            }
            
            if(minHeap.size() == k) {
                res = Math.max(res, sum *num[0]);
            }
            
        }
        
        return res;
    }
}