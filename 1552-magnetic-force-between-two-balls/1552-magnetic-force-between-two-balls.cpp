class Solution {
public:
    int maxDistance(vector<int>& position, int m) {
        //Bin serach
        const int N = position.size();
        
        sort(position.begin(), position.end());
        
        //search space
        int minDis = INT_MAX, maxDis = (position[N -1] -position[0]) /(m -1);
        for(int i = 1; i < N; i++) {
            minDis = min(minDis, position[i] -position[i -1]);
        }
        
        int maxDisPossible = minDis;
        while(minDis <= maxDis) {
            int midDis = minDis +(maxDis -minDis)/2;
            if(isPossibleDistance(position, m, midDis)) {
                minDis = midDis +1;
                maxDisPossible = midDis;
            } else {
                maxDis = midDis -1;
            }
        }
        
        return maxDisPossible;
    }
    
private:
    bool isPossibleDistance(vector<int>& position, int totalBalls, int distanceLimit) {
        
        int currBall = 1;
        int currPos = position[0];
        
        for(int i = 1; i < position.size(); i++) {
            int dis = position[i] -currPos;
            if(dis >= distanceLimit) {
                currBall++;
                currPos = position[i];
            }
            if(currBall >= totalBalls) return true;
        }
        
        return false;
    }
};