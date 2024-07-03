class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        final int N = nums.length;
        int diff = Integer.MAX_VALUE;
        
        int i = 0, j = N -4;
        if(i >= j) {
            return 0;
        }
        
        while(j < N) {
            diff = Math.min(diff, nums[j] -nums[i]);
            i++;
            j++;
        }
        
        return diff;
    }
}