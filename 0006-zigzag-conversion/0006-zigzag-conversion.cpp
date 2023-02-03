class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows == 1) return s;
        
        string ans;
        
        for(int row = 0; row < numRows; row++) {
            int increment = (numRows -1) *2;
            for(int i = row; i < s.size(); i += increment) {
                ans.push_back(s[i]);
                if(row > 0 && row < numRows -1 && (i +increment -2*row) < s.size()) {
                    ans.push_back(s[i +increment -2*row]);
                }
            }
        }
        
        return ans;
    }
};