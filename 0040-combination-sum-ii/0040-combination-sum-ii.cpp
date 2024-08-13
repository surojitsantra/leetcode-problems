class Solution {
    void getSubsets(vector<int>& candidates, int i, int N, int curSum, int target, vector<int>& curSubset, vector<vector<int>>& subsets) {
        
        if(curSum == target) {
            subsets.push_back(curSubset);
            return;
        }
        if(curSum > target) return;
        if(i == N) return;
        
        curSubset.push_back(candidates[i]);
        getSubsets(candidates, i +1, N, curSum +candidates[i], target, curSubset, subsets);
        
        curSubset.pop_back();
        while(i +1 < N && candidates[i] == candidates[i +1]) i++;
        getSubsets(candidates, i +1, N, curSum, target, curSubset, subsets);
    }
    
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        
        vector<vector<int>> subsets;
        vector<int> curSubset;
        
        getSubsets(candidates, 0, candidates.size(), 0, target, curSubset, subsets);
        
        return subsets;        
    }
};