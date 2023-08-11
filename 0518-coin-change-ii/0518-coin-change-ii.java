class Solution {
    public int change(int amount, int[] coins) {
        final int N = coins.length;
        int[][] dp = new int[N][amount +1];
        for(int[] d :dp) Arrays.fill(d, -1);
        
        return totalCombinations(coins, 0, 0, amount, dp);
    }
    
    private int totalCombinations(int[] coins, int i, int currAmount, int amount, int[][] dp) {
        if(currAmount == amount) return 1;
        if(currAmount > amount) return 0;
        
        if(dp[i][currAmount] != -1) return dp[i][currAmount];
        
        int ans = 0;
        
        for(int j = i; j < coins.length; j++) {
            ans += totalCombinations(coins, j, currAmount +coins[j], amount, dp);
        }
        
        return dp[i][currAmount] = ans;
    }
}