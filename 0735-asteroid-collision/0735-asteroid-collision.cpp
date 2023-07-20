class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        const int N = asteroids.size();
        vector<int> ans;
        
        int i = 0;
        
        for(int i = 0; i < N; i++) {
            int num = asteroids[i];
            if(ans.empty()) {
                ans.push_back(num);
                continue;
            }
            while(!ans.empty() && num != 0 && ans.back() > 0 && num < 0) {
                if(abs(num) == ans.back()) {
                    ans.pop_back();
                    num = 0;
                }else if(abs(num) > ans.back()) {
                    ans.pop_back();
                } else {
                    num = 0;
                }
            }
            if(num != 0) ans.push_back(num);
        }
        
        return ans;
    }
};