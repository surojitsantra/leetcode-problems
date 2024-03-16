class Solution {
    public int findMaxLength(int[] nums) {
        final int N = nums.length;
        
        for(int i = 0; i < N; i++) {
            if(nums[i] == 0) nums[i] = -1;
        }
        
        Map<Integer, Integer> sumIdx = new HashMap<>();
        
        int maxSize = 0;
        int currSum = 0;
        for(int i = 0; i < N; i++) {
            currSum += nums[i];
            if(currSum == 0) {
                maxSize = i +1;
            } else if(sumIdx.containsKey(currSum)) {
                maxSize = Math.max(maxSize, i -sumIdx.get(currSum));
            } else {
                sumIdx.put(currSum, i);
            }
        }
        
        return maxSize;
        
    }
}