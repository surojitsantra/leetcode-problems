class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        final int N = nums.length;
        int[] result = new int[N];
        
        int totalXor = 0;
        for(int num :nums) totalXor = totalXor ^num;
        
        int mask = (1 << maximumBit) - 1;
        for(int i = 0; i < N; i++) {
            result[i] = totalXor ^mask;
            totalXor ^= nums[N -1 -i];
        }
        
        return result;
    }
}