class Solution {
public:
    bool arrayStringsAreEqual(vector<string>& word1, vector<string>& word2) {
        const int M = word1.size();
        const int N = word2.size();
        
        int i = 0, j = 0;
        int k = 0, l = 0;
        
        while(i < M && j < N) {
            if(word1[i][k++] != word2[j][l++]) return false;
            if(k == word1[i].size()) {
                k = 0;
                i++;
            }
            if(l == word2[j].size()) {
                l = 0;
                j++;
            }
        }
        if(i != M || j != N) return false;
        if(k != 0 || l != 0) return false;
        
        return true;
    }
};