class Solution {
public:
    int maxDistance(vector<vector<int>>& grid) {
        //bfs
        const int N = grid.size();
        
        vector<vector<int>> visited = grid;
        queue<pair<int, int>> helperQueue;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(grid[i][j] == 1) {
                    helperQueue.push({i, j});
                }
            }
        }
        
        if(helperQueue.empty() || helperQueue.size() == (N *N)) return -1;
        
        vector<int> rowCells = {-1, 1, 0, 0};
        vector<int> colCells = {0, 0, -1, 1};
        
        int distance = -1;
        
        while(!helperQueue.empty()) {
            int sz = helperQueue.size();
            while(sz--) {
                pair<int, int> curPos = helperQueue.front();
                helperQueue.pop();
                
                int r = curPos.first;
                int c = curPos.second;
                
                for(int i = 0; i < 4; i++) {
                    int nRow = rowCells[i] +r;
                    int nCol = colCells[i] +c;
                    
                    if(nRow >= 0 && nRow < N && nCol >= 0 && nCol < N && visited[nRow][nCol] == 0) {
                        helperQueue.push({nRow, nCol});
                        visited[nRow][nCol] = 1;
                    }
                } 
            }
            distance++;
        }
        return distance;
    }
};