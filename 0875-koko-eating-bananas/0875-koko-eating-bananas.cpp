class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        //Bin search
        const int N = piles.size();
        
        //search space
        int low = 1, high = INT_MIN;
        for(int pile :piles) high = max(high, pile);
        
        int k = high;
        while(low <= high) {
            int mid = low +(high -low)/2;
            
            if(isPossibleEatBananaWithinHour(piles, h, mid)) {
                k = mid;
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        
        return k;
    }
    
private:
    bool isPossibleEatBananaWithinHour(vector<int>& piles, int h, int k) {
        int currHour = 0;
        for(int pile :piles) {
            currHour += ceil((double)pile /k);
            if(currHour > h) return false;
        }
        return true;
    }
};