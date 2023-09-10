class Solution {
    
    private static final int MOD = 1000000000 +7;
    
    public int countOrders(int n) {
        long fact = fact(n);
        
        return (int)fact;
    }
    
    private long fact(int n) {
        long ans = 1;
        
        for(int i = 1; i <= n *2; i++) {
            ans = ans *i;
            if((i &1) == 0) ans = ans /2;
            ans = ans %MOD;
        }
        
        return ans;
    }
}