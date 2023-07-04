class Solution {
    public int singleNumber(int[] nums) {
        final int N = nums.length;
        int ans = 0;
        
        for(int i = 0; i < 32; i++) {
            int onceCount = 0;
            for(int num :nums) {
               onceCount += (num >>i) &1;
            }
            onceCount %= 3;
            ans = ans |(onceCount <<i);
        }
        return ans;
    }
}