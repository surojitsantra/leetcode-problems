class Solution {
    public long mostPoints(int[][] questions) {
        final int N = questions.length;
        long[] dp = new long[N];
        Arrays.fill(dp, -1);
        
        return maxPoint(questions, 0, N, dp);
    }
    
    private long maxPoint(int[][]questions, int p, final int N, long[] dp) {
        if(p >= N) return 0;
        if(dp[p] != -1) return dp[p];
        
        //take pth question;
        long ans1 = questions[p][0] +maxPoint(questions, p +questions[p][1] +1, N, dp);
        
        //skip
        long ans2 = maxPoint(questions, p +1, N, dp);
        
        return dp[p] = Math.max(ans1, ans2);
    }
}