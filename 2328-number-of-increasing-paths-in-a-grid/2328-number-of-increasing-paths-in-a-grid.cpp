#define MOD 1000000007

class Solution {
public:
    int countPaths(vector<vector<int>>& grid) {
        const int M = grid.size();
        const int N = grid[0].size();
        
        vector<vector<long>> dp(M, vector<long>(N, -1));
        
        int ans = 0;
        
        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                int paths = dfs(grid, r, c, M, N, dp);
                
                ans += (paths %MOD);
                ans %= MOD;
            }
        }
        return ans;
    }
    
    
private:
    
    int dfs(vector<vector<int>>& grid, int r, int c, int M, int N, vector<vector<long>>& dp) {
        
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        
        int paths = 1;
        
        vector<int> rowMap = {-1, 1, 0, 0};
        vector<int> colMap = {0, 0, -1, 1};
        
        
        for(int i = 0; i < 4; i++) {
            int nRow = r +rowMap[i];
            int nCol = c +colMap[i];
            
            if(nRow < 0 || nRow >= M || nCol < 0 || nCol >= N 
               || grid[nRow][nCol] <= grid[r][c]) continue;
            
            paths = ((paths %MOD) + dfs(grid, nRow, nCol, M, N, dp) %MOD) %MOD;
        }
        return dp[r][c] = paths;
    }
};