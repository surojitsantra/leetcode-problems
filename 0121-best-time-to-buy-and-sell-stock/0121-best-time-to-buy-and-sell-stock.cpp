class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int curBuyPrice = INT_MAX;
        int curMaxProfit = 0;
        
        for(int num:prices) {
            curBuyPrice = min(curBuyPrice, num);
            curMaxProfit = max(curMaxProfit, num -curBuyPrice);
        }
        
        return curMaxProfit;
    }
};