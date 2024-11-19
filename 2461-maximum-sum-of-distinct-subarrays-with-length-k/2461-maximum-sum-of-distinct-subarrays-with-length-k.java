class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        final int N = nums.length;
        Map<Integer, Integer> numsCount = new HashMap<>();
        
        long currSum = 0;
        long maxSum = 0;
        for(int i = 0; i < k; i++) {
            numsCount.put(nums[i], numsCount.getOrDefault(nums[i], 0) +1);
            currSum += nums[i];
        }
        
        if(numsCount.size() == k) {
            maxSum = currSum;
        }
        for(int i = k; i < N; i++) {
            int preNum = nums[i -k];
            currSum -= preNum;
            numsCount.put(preNum, numsCount.get(preNum) -1);
            if(numsCount.get(preNum) == 0) {
                numsCount.remove(preNum);
            }
            currSum += nums[i];
            numsCount.put(nums[i], numsCount.getOrDefault(nums[i], 0) +1);
            
            if(numsCount.size() == k) {
                maxSum = Math.max(maxSum, currSum);
            }
        }
        
        return maxSum;
    }
}