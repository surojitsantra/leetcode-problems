class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        
        final int M = nums1.length, N = nums2.length;
        int[][] dp = new int[M][N];
        for(int[] d :dp) Arrays.fill(d, -1);
        
        int maxDot = getMaxDotProduct(nums1, 0, nums2, 0, M, N, dp);
        if(maxDot > 0) return maxDot;
        
        int minNo1 = Integer.MAX_VALUE, minNo2 = Integer.MAX_VALUE;
        
        for(int num :nums1) {
            minNo1 = Math.min(minNo1, Math.abs(num));
        }
        for(int num :nums2) {
            minNo2 = Math.min(minNo2, Math.abs(num));
        }
        
        return -(minNo1 *minNo2);
        
    }
    
    private int getMaxDotProduct(int[] nums1, int i, int[] nums2, int j, final int M, final int N, int[][] dp) {
        
        if(i >= M || j >= N) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        int maxDot = (nums1[i] *nums2[j]) +getMaxDotProduct(nums1, i +1, nums2, j +1, M, N, dp);
        maxDot = Math.max(maxDot, getMaxDotProduct(nums1, i +1, nums2, j, M, N, dp));
        maxDot = Math.max(maxDot, getMaxDotProduct(nums1, i, nums2, j +1, M, N, dp));
        
        return dp[i][j] = maxDot;
    }
}