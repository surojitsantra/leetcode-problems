class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        int maxAlt = 0;
        int currAlt = 0;
        
        for(int num :gain) {
            currAlt += num;
            maxAlt = max(maxAlt, currAlt);
        }
        return maxAlt;
    }
};