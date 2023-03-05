class Solution {
public:
    bool canJump(vector<int>& nums) {
        const int N = nums.size();
        
        return DFS(nums, 0, N);
    }
    
private:
    bool DFS(vector<int>& nums, int currIdx, const int N) {
        
        if(currIdx >= N || nums[currIdx] == -1) return false;
        if(currIdx == N -1) return true;
        
        int x = nums[currIdx];
        nums[currIdx] = -1;
        
        for(int i = 1; i <= x; i++) {
            if(DFS(nums, currIdx +i, N)) return true;
        }
        
        return false;
    }
};