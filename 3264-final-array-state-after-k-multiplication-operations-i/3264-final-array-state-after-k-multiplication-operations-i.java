class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> minHeap = 
            new PriorityQueue<>((a, b) -> {
                if(nums[a] == nums[b]) {
                    return a -b;
                }
                return nums[a] -nums[b];
            });
        
        for(int i = 0; i < nums.length; i++) {
            minHeap.add(i);
        }
        
        while(k-- > 0) {
            int idx = minHeap.poll();
            nums[idx] *= multiplier;
            
            minHeap.add(idx);
        }
        
        return nums;
    }
}