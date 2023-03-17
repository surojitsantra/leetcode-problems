class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //Using bin search
        int minSize = 1, maxSize = nums.length;
        int minSubarraySize = 0;
        
        while(minSize <= maxSize) {
            int midSize = minSize +(maxSize -minSize) /2;
            if(isLimitSizePossible(nums, target, midSize)) {
                minSubarraySize = midSize;
                maxSize = midSize -1;
            } else {
                minSize = midSize +1;
            }
        }
        
        return minSubarraySize;
    }
    
    private boolean isLimitSizePossible(int[] nums, int target, int subarraySize) {
        int currSum = 0;
        for(int i = 0; i < subarraySize; i++) currSum += nums[i];
        if(currSum >= target) return true;
        
        int i = 0, j = subarraySize -1;
        while(j +1 < nums.length) {
            currSum -= nums[i++];
            currSum += nums[++j];
            if(currSum >= target) return true;
        }
        return false;
    }
}