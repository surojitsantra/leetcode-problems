class Solution {
    public int minimumDeletions(String s) {
        
        int[][] dp = new int[s.length()][2];
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        
        return minDel(s, 0, true, dp);
    }
    
    private int minDel(String s, int i, boolean isA, int[][] dp) {
        
        if(i >= s.length()) return 0;
        
        int idx = (isA)? 1 : 0;
        if(dp[i][idx] != -1) return dp[i][idx];
            
        char ch = s.charAt(i);
        int count = 0;
        
        if(isA) {
            if(ch == 'a') {
                count = minDel(s, i +1, true, dp);
            } else {
                int take = minDel(s, i +1, false, dp);
                int remove = 1 +minDel(s, i +1, true, dp);
                count = Math.min(take, remove);
            }
        } else {
            if(ch == 'a') {
                count = 1 +minDel(s, i +1, false, dp);
            } else {
                count = minDel(s, i +1, false, dp);
            }
        }
        
        return dp[i][idx] = count;
    }
}