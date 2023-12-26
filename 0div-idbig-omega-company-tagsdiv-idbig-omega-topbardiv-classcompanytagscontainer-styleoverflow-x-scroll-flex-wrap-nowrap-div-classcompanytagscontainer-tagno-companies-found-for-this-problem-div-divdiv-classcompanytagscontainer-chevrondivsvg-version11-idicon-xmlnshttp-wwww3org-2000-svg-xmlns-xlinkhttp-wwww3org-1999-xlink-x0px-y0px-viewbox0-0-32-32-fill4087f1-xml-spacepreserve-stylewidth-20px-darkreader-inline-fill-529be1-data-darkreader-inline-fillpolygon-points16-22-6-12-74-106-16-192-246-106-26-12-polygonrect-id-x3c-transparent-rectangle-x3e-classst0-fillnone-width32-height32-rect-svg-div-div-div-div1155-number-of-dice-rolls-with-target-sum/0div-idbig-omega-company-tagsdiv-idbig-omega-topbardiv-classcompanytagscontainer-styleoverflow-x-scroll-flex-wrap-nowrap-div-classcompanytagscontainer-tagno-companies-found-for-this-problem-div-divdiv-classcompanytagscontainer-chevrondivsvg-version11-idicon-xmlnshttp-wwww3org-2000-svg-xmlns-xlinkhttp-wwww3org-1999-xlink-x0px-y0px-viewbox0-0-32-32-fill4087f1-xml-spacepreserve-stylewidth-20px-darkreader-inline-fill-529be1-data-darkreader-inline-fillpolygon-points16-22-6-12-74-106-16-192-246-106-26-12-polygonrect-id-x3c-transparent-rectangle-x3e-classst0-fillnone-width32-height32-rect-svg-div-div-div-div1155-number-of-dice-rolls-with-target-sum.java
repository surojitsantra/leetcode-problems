class Solution {
    
    private final int MOD = 1000000000 +7;
    
    public int numRollsToTarget(int n, int k, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return noOfWays(n, k, target, dp);
    }
    
    private int noOfWays(int n, int k, int target, Map<String, Integer> dp) {
        if(n == 0 && target == 0) return 1;
        if(n == 0 || target <= 0) return 0;
        
        String key = n +" " +target;
        if(dp.containsKey(key)) return dp.get(key);
        
        int ways = 0;
        
        for(int i = 1; i <= k; i++) {
            ways = ((ways %MOD) +(noOfWays(n -1, k, target -i, dp) %MOD)) %MOD;
        }
        
        dp.put(key, ways);
        return ways;
    }
    
}