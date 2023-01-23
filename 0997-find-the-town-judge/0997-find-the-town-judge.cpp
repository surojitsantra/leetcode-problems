class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int> trustCounter(n +1);
        
        for(auto t :trust) {
            int a = t[0], b = t[1];
            trustCounter[a]--;
            trustCounter[b]++;
        }
        
        for(int i = 1; i <= n; i++) {
            if(trustCounter[i] == n -1) return i;
        }
        
        return -1;
        
    }
};