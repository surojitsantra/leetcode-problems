class Solution {
    public int missingNumber(int[] nums) {
        final int N = nums.length;
        
        for(int i = 0; i < N; i++) {
            nums[i]++;
        }
        
        for(int num :nums) {
            if(Math.abs(num) -1 < N) nums[Math.abs(num) -1] *= -1;
        }
        
        for(int i = 0; i < N; i++) {
            if(nums[i] > 0) return i;
        }
        return N;
    }
    
}