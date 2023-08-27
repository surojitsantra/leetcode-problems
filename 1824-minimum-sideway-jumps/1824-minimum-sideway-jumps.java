class Solution {
    public int minSideJumps(int[] obstacles) {
        final int N = obstacles.length;
        
        int[][] dp = new int[N][4];
        for(int[] d :dp) Arrays.fill(d, -1);
        
        return minSideJumpReq(obstacles, 2, 0, N, dp);
    }
    
    
    private int minSideJumpReq(int[] obstacles, int currLane, int currPoint, final int N, int[][] dp) {
        if(currPoint == N -1) return 0;
        if(dp[currPoint][currLane] != -1) return dp[currPoint][currLane];
        
        int obstacleLane = obstacles[currPoint];
        int nextObstacleLane = obstacles[currPoint +1];
        
        if(currLane != nextObstacleLane) {
            return dp[currPoint][currLane] = minSideJumpReq(obstacles, currLane, currPoint +1, N, dp);
        } else {
            if(obstacleLane == 0) {
                return dp[currPoint][currLane] = 1 +Math.min(
                    minSideJumpReq(obstacles, (currLane) %3 +1, currPoint, N, dp),
                    minSideJumpReq(obstacles, (currLane +1) %3 +1, currPoint, N, dp)
                );
            } else {
                int nonObstacleLane = findNonObstacleLane(currLane, obstacleLane );
                return dp[currPoint][currLane] = 1 +minSideJumpReq(obstacles, nonObstacleLane, currPoint, N, dp);
            }
        }
        
    }
    
    private int findNonObstacleLane(int currLane, int obstacleLane ) {
        if(currLane == 1) {
            return (obstacleLane == 2) ? 3 : 2;
        }
        
        if(currLane == 2) {
            return (obstacleLane == 1) ? 3 : 1;
        }
        
        if(currLane == 3) {
            return (obstacleLane == 1) ? 2 : 1;
        }
        return -1;
    }
}