class Solution {
    public int climbStairs(int n) {
        if(n < 3) return n;
        int prev2 = 1;
        int prev1 = 2;
        
        for(int i = 3; i <= n; i++) {
            int curr = prev1 +prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
    
}