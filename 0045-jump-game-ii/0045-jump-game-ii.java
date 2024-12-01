class Solution {
    public int jump(int[] nums) {
        int maxICanGo = 0;
        int jumps = 0, curEnd = 0;
        for(int i = 0; i < nums.length -1; i++) {
            maxICanGo = Math.max(maxICanGo, i +nums[i]);
            if(i == curEnd) {
                jumps++;
                curEnd = maxICanGo;
            }
        }
        
        return jumps;
    }
}