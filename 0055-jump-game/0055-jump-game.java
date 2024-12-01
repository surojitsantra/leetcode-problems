class Solution {
    public boolean canJump(int[] nums) {
        final int N = nums.length;
        int maxICanGo = 0;
        
        for(int i = 0; i < N; i++) {
            if(i > maxICanGo) return false;
            maxICanGo = Math.max(maxICanGo, i +nums[i]);
        }
        
        return true;
    }
}