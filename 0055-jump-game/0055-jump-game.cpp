class Solution {
    int canReachEnd(vector<int>& nums, int curPos, int N, vector<int>& dp) {
        if(curPos >= N) return 0;

        if(curPos == N -1) return 1;

        if(dp[curPos] != -1) return dp[curPos];

        int stepsCanJump = nums[curPos];

        for(int i = 1; i <= stepsCanJump; i++) {
            dp[curPos] = canReachEnd(nums, curPos +i, N, dp);
            if(dp[curPos]) return dp[curPos];
        }

        return 0;
    }
    
public:
    bool canJump(vector<int>& nums) {
        const int N = nums.size();
        
        vector<int> dp(N, -1);
        
        return canReachEnd(nums, 0, N, dp);
    }
};