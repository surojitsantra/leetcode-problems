class Solution {
public:
    
    int gcd(int x, int y) {
        if(y == 0) return x;
        return gcd(y, x %y);
    }
    
    int maximumScore(vector<int>& nums, vector<bool>& visited, int i, unordered_map<vector<bool>, int>& dp) {
        
        if (dp.count(visited)) return dp[visited];
            
        int score = 0;
        
        for (int x = 0; x < nums.size(); x++) {
            if (visited[x]) continue;
            
            for (int y = x +1; y < nums.size(); y++) {
                if (visited[y]) continue;
                
                visited[x] = visited[y] = true;
                
                int firstNo = nums[x];
                int secondNo = nums[y];
                score = max(score, (i *gcd(firstNo, secondNo) +maximumScore(nums, visited, i +1, dp)));
                
                visited[x] = visited[y] = false;
            }
        }
        return dp[visited] = score; //store the result
    }
    
    
    int maxScore(vector<int>& nums) {
        const int LEN = nums.size();
        const int N = LEN >>1;
        
        vector<bool> visited(LEN, false);
        
        unordered_map<vector<bool>, int> dp;
        
        return maximumScore(nums, visited, 1, dp);
        
    }
};