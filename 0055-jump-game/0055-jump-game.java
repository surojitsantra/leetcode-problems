class Solution {
    public boolean canJump(int[] nums) {
        final int N = nums.length;
        int maxPosCanGo = 0;
        
        for(int i = 0; i < N; i++) {
            maxPosCanGo = Math.max(maxPosCanGo, i +nums[i]);
            if(maxPosCanGo == i) break;
            
        }
        
        return (maxPosCanGo >= N -1);
    }
}