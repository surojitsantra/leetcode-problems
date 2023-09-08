class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> pascalSeries;
        pascalSeries.push_back({1});
        
        for(int row = 2; row <= numRows; row++) {
            vector<int> prevSeries = pascalSeries[pascalSeries.size() -1];
            vector<int> curSeries(prevSeries.size() +1, 1);
            
            for(int i = 1; i < prevSeries.size(); i++) {
                curSeries[i] = prevSeries[i -1] +prevSeries[i];
            }
            pascalSeries.push_back(curSeries);
        }
        
        return pascalSeries;
    }
};