class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        final int N = satisfaction.length;
        
        Arrays.sort(satisfaction);
        
        int[][] dp = new int[N][N +1];
        for(int[] arr :dp) Arrays.fill(arr, -1);
        
        return maxSatisfy(satisfaction, 0, 1, dp);
    }
    
    private int maxSatisfy(int[] satisfaction, int currDish, int currRank, int[][] dp) {
        if(currDish >= satisfaction.length) return 0;
        if(dp[currDish][currRank] != -1) return dp[currDish][currRank];
        
        //take currDish
        int takeCurrDish = currRank *satisfaction[currDish] +maxSatisfy(satisfaction, currDish +1, currRank +1, dp);
        
        //skip currDish
        int skipCurrDish = maxSatisfy(satisfaction, currDish +1, currRank, dp);
        
        dp[currDish][currRank] = Math.max(takeCurrDish, skipCurrDish);
        return dp[currDish][currRank];
    }
}