class Solution {
    public int subarraySum(int[] nums, int k) {
        final int N = nums.length;
        
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        int currSum = 0;
        int subarrayCount = 0;
        
        for(int i = 0; i < N; i++) {
            currSum += nums[i];
            if(currSum == k) {
                subarrayCount++;
            }
            
            int rem = currSum -k;
            subarrayCount += prefixSumCount.getOrDefault(rem, 0);
            
            prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) +1);
        }
        
        return subarrayCount;
    }
}