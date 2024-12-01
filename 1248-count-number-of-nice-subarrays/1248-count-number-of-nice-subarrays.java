class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return numberOfSubarraysLessThanEqualsGoal(nums, k)
            -numberOfSubarraysLessThanEqualsGoal(nums, k -1);
    }
    
    private int numberOfSubarraysLessThanEqualsGoal(int[] nums, int k) {
        final int N = nums.length;
        int count = 0;
        int currOdds = 0;
        
        int start = 0;
        for(int end = 0; end < N; end++) {
            if((nums[end] &1) == 1) {
                currOdds++;
            }
            
            while(start <= end && currOdds > k) {
                if((nums[start] &1) == 1) {
                    currOdds--;
                }
                start++;
            }
            
            count += end -start +1;
        }
        
        return count;
    }
    
}