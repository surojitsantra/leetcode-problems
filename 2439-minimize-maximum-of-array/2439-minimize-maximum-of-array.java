class Solution {
    public int minimizeArrayValue(int[] nums) {
        //Binary search
        //search space
        long low = nums[0], high = Integer.MIN_VALUE;
        for(int num :nums) high = Math.max(high, num);
        
        long ans = high;
        while(low <= high) {
            long mid = (long)low +((high -low) >>1);
            
            if(isPossibleAns(nums, mid)) {
                ans = mid;
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        
        return (int)ans;
    }
    
    private boolean isPossibleAns(int[] nums, long mid) {
        if(nums[0] > mid) return false;
        
        long prevVal = nums[0];
        for(int i = 1; i < nums.length; i++) {
            long diff = mid - prevVal;
            prevVal = nums[i] - diff;
            if(prevVal > mid) return false;
        }
        return true;
    }
}