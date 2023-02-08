class Solution {
public:
    int jump(vector<int>& nums) {
        const int N = nums.size();
        vector<int> dp(N, -1);
        
        return minJumpReq(nums, 0, N, dp);
    }
    
private:
    int minJumpReq(vector<int>& nums, int curPos, const int N, vector<int>& dp) {
        
        if(curPos == N -1) return 0;
        if(dp[curPos] != -1) return dp[curPos];
        
        int minJump = INT_MAX -1;
        
        for(int i = 1; i <= nums[curPos]; i++) {
            if(curPos +i >= N) break;
            minJump = min(minJump, 1 +minJumpReq(nums, curPos +i, N, dp));
        }
        
        return dp[curPos] = minJump;
    }
};