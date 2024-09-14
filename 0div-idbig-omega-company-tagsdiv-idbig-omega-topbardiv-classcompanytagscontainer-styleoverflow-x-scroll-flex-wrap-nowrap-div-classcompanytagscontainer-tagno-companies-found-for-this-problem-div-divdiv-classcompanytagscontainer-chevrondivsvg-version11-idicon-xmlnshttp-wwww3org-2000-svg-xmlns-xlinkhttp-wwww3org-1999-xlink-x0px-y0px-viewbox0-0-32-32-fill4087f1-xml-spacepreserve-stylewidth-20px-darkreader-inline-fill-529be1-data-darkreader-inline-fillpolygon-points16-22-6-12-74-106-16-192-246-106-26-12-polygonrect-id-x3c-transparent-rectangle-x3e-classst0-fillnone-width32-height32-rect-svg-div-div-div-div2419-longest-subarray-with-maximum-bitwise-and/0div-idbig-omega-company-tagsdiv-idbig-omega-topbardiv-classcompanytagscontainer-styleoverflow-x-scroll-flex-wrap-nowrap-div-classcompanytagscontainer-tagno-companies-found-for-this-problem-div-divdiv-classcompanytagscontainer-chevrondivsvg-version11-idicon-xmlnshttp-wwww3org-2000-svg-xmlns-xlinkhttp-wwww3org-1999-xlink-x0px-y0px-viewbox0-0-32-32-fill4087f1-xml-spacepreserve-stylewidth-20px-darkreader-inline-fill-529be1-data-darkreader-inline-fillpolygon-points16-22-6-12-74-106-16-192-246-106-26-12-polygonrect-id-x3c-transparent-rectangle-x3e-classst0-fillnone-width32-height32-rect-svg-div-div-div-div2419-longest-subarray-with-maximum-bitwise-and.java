class Solution {
    public int longestSubarray(int[] nums) {
        final int N = nums.length;
        
        int maxNo = 0;
        for(int x :nums) maxNo = Math.max(maxNo, x);
        
        int maxLen = 0;
        int i = 0;
        while(i < N) {
            int len = 0;
            while(i < N && nums[i++] == maxNo) {
                len++;
            }
            maxLen = Math.max(maxLen, len);
        }
        
        return maxLen;
    }
}