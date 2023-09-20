class Solution {
    public int minOperations(int[] nums, int x) {
        final int N = nums.length;
        int minOps = Integer.MAX_VALUE;
        
        int i = 0;
        int currSum = 0;
        while(i < N) {
            currSum += nums[i];
            if(currSum >= x) break;
            i++;
        }
        if(currSum < x) return -1;
        
        int j = N -1;
        while(j >= 0) {
            
            if(currSum > x) {
                if(i < 0) break;
                currSum -= nums[i--];
            } else if(currSum < x) {
                currSum += nums[j--];
            } else {
                minOps = Math.min(minOps, N -(j +1) +(i +1));
                currSum += nums[j--];
            }
        }
        
        
        if(minOps == Integer.MAX_VALUE) return -1;
        return minOps;
    }
}