class Solution {
    public int longestSubarray(int[] nums, int limit) {

        Deque<Integer> increasing = new LinkedList<>();
        Deque<Integer> decreasing = new LinkedList<>();

        final int N = nums.length;

        int maxSubArray = 0;

        int start = 0;
        for(int end = 0; end < N; end++) {
            
            int x = nums[end];
            while(!decreasing.isEmpty() && decreasing.getLast() < x) {
                decreasing.removeLast();
            }
            decreasing.addLast(x);

            while(!increasing.isEmpty() && increasing.getLast() > x) {
                increasing.removeLast();
            }
            increasing.addLast(x);

            while(!increasing.isEmpty() && !decreasing.isEmpty() 
                    && start <= end && Math.abs(increasing.getFirst() -decreasing.getFirst()) > limit) {
                
                if(decreasing.getFirst() == nums[start]) {
                    decreasing.removeFirst();
                }
                if(increasing.getFirst() == nums[start]) {
                    increasing.removeFirst();
                }

                start++;
            }

            maxSubArray = Math.max(maxSubArray, end -start +1);

        }

        return maxSubArray;

    }
}