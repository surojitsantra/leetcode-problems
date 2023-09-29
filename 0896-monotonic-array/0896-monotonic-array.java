class Solution {
    public boolean isMonotonic(int[] nums) {
        final int N = nums.length;
        Boolean monotonicInc = null;
        
        for(int i = 1; i < N; i++) {
            if(nums[i -1] == nums[i]) continue;
            if(monotonicInc != null && monotonicInc && nums[i -1] > nums[i]) return false;
            if(monotonicInc != null && !monotonicInc && nums[i -1] < nums[i]) return false;
            
            monotonicInc = (nums[i -1] < nums[i]);
        }
        
        return true;
    }
}