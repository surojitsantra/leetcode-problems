class Solution {
public:
    int minSpeedOnTime(vector<int>& dist, double hour) {
        //Bin search
        const int N = dist.size();
        
        //search space
        long minSpeed = 1;
        long maxSpeed = INT_MAX;
        
        int minSpeedReq = INT_MAX;
        while(minSpeed <= maxSpeed) {
            long avgSpeed = minSpeed +(maxSpeed -minSpeed)/2;
            if(isPossibleToReach(dist, hour, avgSpeed)) {
                minSpeedReq = avgSpeed;
                maxSpeed = avgSpeed -1;
            } else {
                minSpeed = avgSpeed +1;
            }
        }
        
        return(minSpeedReq == INT_MAX)? -1 : minSpeedReq;
    }
    
private:
    bool isPossibleToReach(vector<int>& dist, double hour, long speed) {
        const int N = dist.size();
        double currTime = 0.0;
        for(int i = 0; i < N -1; i++) {
            int currDist = dist[i];
            currTime += ceil((double)currDist /speed);
            if(currTime > hour) return false;
        }
        currTime += ((double)dist[N -1] /speed);
        
        return (currTime <= hour);
    }
};