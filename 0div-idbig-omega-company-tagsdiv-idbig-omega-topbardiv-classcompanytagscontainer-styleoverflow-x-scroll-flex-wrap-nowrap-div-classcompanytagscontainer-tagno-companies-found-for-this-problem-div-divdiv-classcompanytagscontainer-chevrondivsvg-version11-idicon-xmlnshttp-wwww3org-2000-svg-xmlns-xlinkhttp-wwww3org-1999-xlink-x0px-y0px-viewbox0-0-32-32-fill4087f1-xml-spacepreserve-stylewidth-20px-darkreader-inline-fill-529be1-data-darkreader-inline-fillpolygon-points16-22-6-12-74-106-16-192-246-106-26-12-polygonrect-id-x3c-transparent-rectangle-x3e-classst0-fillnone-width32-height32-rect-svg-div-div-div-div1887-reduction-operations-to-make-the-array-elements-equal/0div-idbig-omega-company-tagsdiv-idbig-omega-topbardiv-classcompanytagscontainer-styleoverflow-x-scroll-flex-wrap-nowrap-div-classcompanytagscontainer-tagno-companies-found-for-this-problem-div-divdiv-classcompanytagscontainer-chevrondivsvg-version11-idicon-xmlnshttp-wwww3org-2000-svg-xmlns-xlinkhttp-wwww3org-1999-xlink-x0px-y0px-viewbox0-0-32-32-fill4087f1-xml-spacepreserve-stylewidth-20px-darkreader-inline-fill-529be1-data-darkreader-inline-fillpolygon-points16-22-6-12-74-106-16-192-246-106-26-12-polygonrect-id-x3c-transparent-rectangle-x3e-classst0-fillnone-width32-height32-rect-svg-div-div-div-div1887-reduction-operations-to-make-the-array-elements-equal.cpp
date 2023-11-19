class Solution {
public:
    int reductionOperations(vector<int>& nums) {
        sort(nums.begin(), nums.end(), greater<int>());
        const int N = nums.size();
        
        int ans = 0;
        for(int i = 1; i < N; i++) {
            if(nums[i -1] != nums[i]) {
                ans += i;
            }
        }
        
        return ans;
    }
};