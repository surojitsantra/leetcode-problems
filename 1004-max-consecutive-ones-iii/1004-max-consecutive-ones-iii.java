class Solution {
    public int longestOnes(int[] nums, int k) {
        final int N = nums.length;
        
        int maxSubarrayLen = 0;
        int flipUsed = 0;
        int i = 0, j = 0;
        while(i < N && j < N) {
            if(nums[j] == 1) {
                j++;
                maxSubarrayLen = Math.max(maxSubarrayLen, j -i);
            } else if(flipUsed < k) {
                j++;
                flipUsed++;
                maxSubarrayLen = Math.max(maxSubarrayLen, j -i);
            } else {
                if(nums[i] == 0) {
                    flipUsed--;
                }
                i++;
            }
        }
        
        return maxSubarrayLen;
    }
}