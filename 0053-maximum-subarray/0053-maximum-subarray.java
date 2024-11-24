class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = 0, currSum = 0, maxValue = Integer.MIN_VALUE;
        for(int num :nums) {
            currSum += num;
            currSum = Math.max(currSum, 0);
            maxSum = Math.max(maxSum, currSum);
            maxValue = Math.max(maxValue, num);
        }
        if(maxValue < 0) return maxValue;
        return maxSum;
    }
}