class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        final int N = nums.length;
        long count = 0;
        int maxI = -1;
        int minI = -1;
        int badI = -1;
        
        for(int i = 0; i < N; i++) {
            int num = nums[i];
            if(num < minK || num > maxK) {
                badI = i;
            }
            if(num == minK) minI = i;
            if(num == maxK) maxI = i;
            
            int minIdx = Math.min(minI, maxI);
            if(minIdx -badI > 0) {
                count += minIdx -badI;
            }
            
        }
        
        return count;
    }
}