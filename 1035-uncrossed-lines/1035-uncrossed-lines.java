class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(int[] d: dp) Arrays.fill(d, -1);
        
        return maxLine(nums1, 0, nums2, 0, dp);
    }
    
    private int maxLine(int[] nums1, int p1, int[] nums2, int p2, int[][] dp) {
        if(p1 >= nums1.length || p2 >= nums2.length) return 0;
        if(dp[p1][p2] != -1) return dp[p1][p2];
        
        int ans1 = 0;
        if(nums1[p1] == nums2[p2]) {
            ans1 = 1 +maxLine(nums1, p1 +1, nums2, p2 +1, dp);
        }
        
        int ans2 = Math.max(
            maxLine(nums1, p1, nums2, p2 +1, dp),
            maxLine(nums1, p1 +1, nums2, p2, dp)
        );
        
        return dp[p1][p2] = Math.max(ans1, ans2);
    }
}