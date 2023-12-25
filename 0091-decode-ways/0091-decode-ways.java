class Solution {
    public int numDecodings(String s) {
        
        final int N = s.length();
        
        int next1 = 1;
        int next2 = 1;
        
        for(int i = N -1; i >= 0; i--) {
            int curr = 0;
            if(s.charAt(i) != '0') {
                curr = next1;
                if((i +1 < N) 
                   && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i +1) <= '6'))) {
                    curr += next2;
                }
            }
            next2 = next1;
            next1 = curr;
        }
        
        return next1;
    }
    
//     public int noOfWaysDecode(char[] nums, int pos, final int N, int[] dp) {
        
//         if(pos >= N) return 1;
//         if(nums[pos] == '0') return 0;
//         if(dp[pos] != -1) return dp[pos];
        
//         int ways = noOfWaysDecode(nums, pos +1, N, dp);
//         if(pos +1 < N) {
//             int num = Integer.valueOf(nums[pos] +"" +nums[pos +1]);
//             if(num <= 26) {
//                 ways += noOfWaysDecode(nums, pos +2, N, dp);
//             }
//         }
        
//         return dp[pos] = ways;
//     }
    
}