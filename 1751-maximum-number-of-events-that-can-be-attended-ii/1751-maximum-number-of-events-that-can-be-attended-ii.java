class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b)-> a[0] -b[0]);
        
        final int N = events.length;
        int[][] dp = new int[k +1][N];
        for(int[] d :dp) Arrays.fill(d, -1);
        
        return findMaxValue(events, 0, k, dp);
    }
    
    private int findMaxValue(int[][] events, int i, int k, int[][] dp) {
        if(i >= events.length) return 0;
        if(k <= 0) return 0;
        if(dp[k][i] != -1) return dp[k][i];
        
        int skip = findMaxValue(events, i +1, k, dp);
        
        int j = findNextPos(events, i, events.length -1, events[i][1]);
        int pick = events[i][2] +findMaxValue(events, j, k -1, dp);
        
        return dp[k][i] = Math.max(skip, pick);
    }
    
    private int findNextPos(int[][] events, int low, int high, int end) {
        int j = events.length;
        
        while(low <= high) {
            int mid = low +(high -low)/2;
            int[] event = events[mid];
            if(event[0] <= end) {
                low = mid +1;
            } else {
                high = mid -1;
                j = mid;
            }
        }
        
        return j;
    }
    
}