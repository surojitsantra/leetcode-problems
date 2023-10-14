class Solution {
    int cache[][], n;
    
    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        cache = new int[n][2 * n + 1];
        for (int[] row : cache) Arrays.fill(row, -1);
        return dp(cost, time, 0, 0);
    }
    
    private int dp(int[] cost, int[] time, int i, int t) {
        if (i == n) return (t >= 0) ? 0 : (int) 1e9;
        if (cache[i][t + n] != -1) return cache[i][t + n];
        return cache[i][t + n] = Math.min(dp(cost, time, i + 1, t - 1),
                        cost[i] + dp(cost, time, i + 1, Math.min(t + time[i], n)));
    }
}