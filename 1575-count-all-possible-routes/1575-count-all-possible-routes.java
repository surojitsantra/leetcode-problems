class Solution {
    
    private final int MOD = 1000000007;
    
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        final int N = locations.length;
        
        int[][] dp = new int[N][fuel +1];
        for(int[] d :dp) Arrays.fill(d, -1);
        
        int route = totalRoutes(locations, start, finish, fuel, N, dp);
        
        return route;
    }
    
    private int totalRoutes(int[] locations, int start, int finish, int fuel, int N, int[][] dp) {
        if(fuel < 0) return 0;
        if(dp[start][fuel] != -1) return dp[start][fuel];
        
        int route = 0;
        if(start == finish) route = 1;
        
        for(int i = 0; i < N; i++) {
            if(i == start) continue;
            route += totalRoutes(locations, i, finish, 
                                 fuel -Math.abs(locations[start] -locations[i]), N, dp);
            route %= MOD;
        }
        
        return dp[start][fuel] = route %MOD;
    }
}