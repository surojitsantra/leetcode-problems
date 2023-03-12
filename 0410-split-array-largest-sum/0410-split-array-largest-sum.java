class Solution {
    public int splitArray(int[] nums, int k) {
        //Bin search
        
        //search space
        int minSum = Integer.MIN_VALUE, maxSum = 0;
        for(int num :nums) {
            minSum = Math.max(minSum, num);
            maxSum += num;
        }
        
        int minimizedMaxSum = maxSum;
        while(minSum <= maxSum) {
            int avgSum = minSum +(maxSum -minSum)/2;
            
            if(isPossibleSum(nums, k, avgSum)) {
                minimizedMaxSum = avgSum;
                maxSum = avgSum -1;
            } else {
                minSum = avgSum +1;
            }
        }
        return minimizedMaxSum;
    }
    
    private boolean isPossibleSum(int[] nums, int k, int maxSumLimit) {
        int currSubarray = 1, currSum = 0;
        for(int num :nums) {
            currSum += num;
            if(currSum > maxSumLimit) {
                currSubarray++;
                currSum = num;
            }
            if(currSubarray > k) return false;
        }
        return true;
    }
}