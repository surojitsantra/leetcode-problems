class Solution {
    
    private final static int MAX_NO = 1000000000;
    
    public int coinChange(int[] coins, int amount) {
        final int N = coins.length;
        
        int[] prev = new int[amount +1];
        
        //buttom up
        //base case
        
        for(int amt = 0; amt <= amount; amt++) {
            if(amt %coins[0] == 0) prev[amt] = amt /coins[0];
            else prev[amt] = MAX_NO;
        }
        prev[0] = 0;
        
        for(int pos = 1; pos < N; pos++) {
            int[] curr = new int[amount +1];
            curr[0] = 0;
            
            for(int amt = 1; amt <= amount; amt++) {
                
                int skip = prev[amt];
                
                int take = MAX_NO;
                if(amt >= coins[pos]) {
                    take = curr[amt -coins[pos]] +1;
                }

                curr[amt] = Math.min(skip, take);
            }
            
            prev = curr;
        }
        
        int x = prev[amount];
        return (x == MAX_NO)? -1 : x;
    }
    
}