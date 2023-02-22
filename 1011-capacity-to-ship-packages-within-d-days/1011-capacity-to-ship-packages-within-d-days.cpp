class Solution {
public:
    int shipWithinDays(vector<int>& weights, int days) {
        //Binary search
        
        //search space
        int low = 0, high = 0;
        for(int weight :weights) {
            low = max(low, weight);
            high += weight;
        }
        
        int ans = high;
        while(low <= high) {
            int maxWeightCanCarry = low +(high -low) /2;
            
            if(isPossibleToCarryWeight(weights, maxWeightCanCarry, days)) {
                ans = maxWeightCanCarry;
                high = maxWeightCanCarry -1;
            } else {
                low = maxWeightCanCarry +1;
            }
        }
        
        return ans;
    }
    
private:
    bool isPossibleToCarryWeight(vector<int>& weights, int maxWeightCanCarry, int days) {
        int day = 1;
        int curWeight = 0;
        
        for(int weight :weights) {
            if(weight +curWeight > maxWeightCanCarry) {
                day++;
                curWeight = 0;
            }
            curWeight += weight;
        }
        
        return (day <= days);
    }
};