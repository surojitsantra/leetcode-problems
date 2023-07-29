class Solution {
    public double soupServings(int n) {
        int qty = (int)Math.ceil((double)n /25.0);
        if(qty >= 200) return 1;
        
        double[][] dp = new double[200][200];
        for(double[] d :dp) Arrays.fill(d, -1);
        
        return soupServe(qty, qty, dp);
    }
    
    private double soupServe(int a, int b, double[][] dp) {
        
        if(a <= 0 && b <= 0) return 0.5;
        if(a <= 0) return 1;
        if(b <= 0) return 0;
        if(dp[a][b] != -1) return dp[a][b];
        
        return dp[a][b] = (
            (
                soupServe(a -4, b, dp) +
                soupServe(a -3, b -1, dp)+
                soupServe(a -2, b -2, dp)+
                soupServe(a -1, b -3, dp)
            ) /4
        );
    }
}