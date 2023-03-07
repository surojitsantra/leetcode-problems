class Solution {
public:
    long long minimumTime(vector<int>& time, int totalTrips) {
        //Binary search
        const int N = time.size();
        
        //search space
        long long minTime = INT_MAX, maxTime;
        
        for(long long t :time) {
            minTime = min(minTime, t);
        }
        maxTime = 1LL *minTime *totalTrips;
        
        long long minTimeReq = maxTime;
        
        while(minTime <= maxTime) {
            long long midTime = minTime +(maxTime -minTime)/2;
            if(isPossibleWithInTime(time, totalTrips, midTime)) {
                maxTime = midTime -1;
                minTimeReq = midTime;
            } else {
                minTime = midTime +1;
            }
        }
        
        return minTimeReq;
    }
    
private:
    bool isPossibleWithInTime(vector<int>& time, int totalTrips, long long timeLimit) {
        long long currTrip = 0;
        for(int t :time) {
            currTrip += (timeLimit /t);
            if(currTrip >= totalTrips) return true;
        }
        return false;
    }
};