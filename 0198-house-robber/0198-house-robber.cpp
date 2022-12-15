class Solution {
    
public:
    int rob(vector<int>& nums) {
        const int N = nums.size();
        
        int prev2 = 0, prev = nums[0];
        
        for(int len = 2; len <= N; len++) {
            int cur = max(prev, nums[len -1] +prev2);
            
            prev2 = prev;
            prev = cur;
        }
        
        return prev;
    }
};