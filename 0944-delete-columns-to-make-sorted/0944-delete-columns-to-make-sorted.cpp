class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        const int N = strs.size();
        const int LEN = strs[0].size();
        
        int nonSortedCol = 0;
        
        for(int i = 0; i < LEN; i++) {
            for(int j = 1; j < N; j++) {
                if(strs[j -1][i] > strs[j][i]) {
                    nonSortedCol++;
                    break;
                }
            }
        }
        
        return nonSortedCol;
    }
};