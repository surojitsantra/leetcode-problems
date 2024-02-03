class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        final int N = arr.length;
        
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        
        return findMaxSum(arr, 0, k, N, dp);
        
    }
    
    private int findMaxSum(int[] arr, int i, int k, final int N, int[] dp) {
        if(i >= N) return 0;
        if(dp[i] != -1) return dp[i];
        
        int currMax = 0;
        int maxAns = 0;
        
        for(int pos = i; pos < i +k && pos < N; pos++) {
            currMax = Math.max(currMax, arr[pos]);
            int freq = pos -i +1;
            int sum = freq *currMax;
            sum += findMaxSum(arr, pos +1, k, N, dp);
            
            maxAns = Math.max(maxAns, sum);
            
        }
        
        return dp[i] = maxAns;
    }
}