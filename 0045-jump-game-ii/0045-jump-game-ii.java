class Solution {
    public int jump(int[] nums) {
        final int N = nums.length;
        int l = 0, r = 0;
        int jumps = 0;
        
        while(r < N -1) {
            int maxCanGo = 0;
            for(int i = l; i <= r; i++) {
                maxCanGo = Math.max(maxCanGo, i +nums[i]);
            }
            l = r +1;
            r = maxCanGo;
            
            jumps++;
        }
        
        return jumps;
    }
}