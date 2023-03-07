class Solution {
public:
    int minDays(vector<int>& bloomDay, int m, int k) {
        //Bin search
        const int N = bloomDay.size();
        
        if(N /k < m) return -1;
        
        //search space
        int minDay = INT_MAX, maxDay = INT_MIN;
        for(int day :bloomDay) {
            minDay = min(minDay, day);
            maxDay = max(maxDay, day);
        }
        
        int minDayReq = maxDay;
        while(minDay <= maxDay) {
            int midDay = minDay +(maxDay -minDay)/2;
            if(isPossibleInThatDay(bloomDay, midDay, m, k)) {
                minDayReq = midDay;
                maxDay = midDay -1;
            } else {
                minDay = midDay +1;
            }
        }
        return minDayReq;
    }
    
private:
    bool isPossibleInThatDay(vector<int>& bloomDay, int day, int m, int k) {
        int currBouquets = 0;
        int currFlowers = 0;
        
        for(int i = 0; i < bloomDay.size(); i++) {
            int bDay = bloomDay[i];
            if(bDay <= day) currFlowers++;
            else currFlowers = 0;
            if(currFlowers == k) {
                currBouquets++;
                currFlowers = 0;
            }
            if(currBouquets >= m) return true;
        }
        return false;
    }
};