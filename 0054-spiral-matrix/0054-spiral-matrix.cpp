class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int m = matrix.size(), n = matrix[0].size();
        int total = m*n;
        
        vector<int> ans(total);
        
        int count = 0;
        int startRow = 0, startCol = 0, endRow = m-1, endCol = n-1;
        
        while(count < total) {
            for(int col = startCol; col <= endCol && count < total; col++) {
                ans[count++] = matrix[startRow][col];
            }
            startRow++;
            
            for(int row = startRow; row <= endRow && count < total; row++) {
                ans[count++] = matrix[row][endCol];
            }
            endCol--;
            
            for(int col = endCol; col >= startCol && count < total; col--) {
                ans[count++] = matrix[endRow][col];
            }
            endRow--;
            
            for(int row = endRow; row >= startRow && count < total; row--) {
                ans[count++] = matrix[row][startCol];
            }
            startCol++;
        }
        
        return ans;
    }
};