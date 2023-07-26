class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        
        //search space
        long low = 1, high = Integer.MAX_VALUE;
        int minSpeed = -1;
        
        while(low <= high) {
            long mid = low +(high -low) /2;
            if(isPossibleReach(dist, hour, mid)) {
                minSpeed = (int)mid;
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        
        return minSpeed;
    }
    
    private boolean isPossibleReach(int[] dist, double hour, long speed) {
        
        final int N = dist.length;
        double currTime = 0;
        
        for(int i = 0; i < N -1; i++) {
            currTime += Math.ceil((double)dist[i] /speed);
        }
        currTime += (double)dist[N -1] /speed;
        
        return (currTime <= hour);
    }
}