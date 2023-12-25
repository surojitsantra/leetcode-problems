class Solution {
    public int numDecodings(String s) {
        final int N = s.length();
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        
        return noOfWaysDecode(s.toCharArray(), 0, N, dp);
    }
    
    public int noOfWaysDecode(char[] nums, int pos, final int N, int[] dp) {
        
        if(pos >= N) return 1;
        if(nums[pos] == '0') return 0;
        if(dp[pos] != -1) return dp[pos];
        
        int ways = noOfWaysDecode(nums, pos +1, N, dp);
        if(pos +1 < N) {
            int num = Integer.valueOf(nums[pos] +"" +nums[pos +1]);
            if(num <= 26) {
                ways += noOfWaysDecode(nums, pos +2, N, dp);
            }
        }
        
        return dp[pos] = ways;
    }
    
}