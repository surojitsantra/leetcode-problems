class Solution {
public:
    int shortestPathAllKeys(vector<string>& grid) {
        const int M = grid.size();
        const int N = grid[0].size();
        
        int x = -1, y = -1, totalKeys = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                char ch = grid[i][j];
                if(ch == '@') {
                    x = i;
                    y = j;
                } else if('a' <= ch && ch <= 'f') {
                    totalKeys++;
                }
            }
        }
        
        vector<int> rowMap = {0, 0, -1, 1};
        vector<int> colMap = {-1, 1, 0, 0};
        queue<vector<int>> helperQueue;
        unordered_set<string> visited;
        int steps = 0;
        
        helperQueue.push({0, x, y});
        visited.insert(to_string(0) +"_" +to_string(x) +"_" +to_string(y));
        
        while(!helperQueue.empty()) {
            int sz = helperQueue.size();
            while(sz--) {
                vector<int> cell = helperQueue.front();
                helperQueue.pop();
                
                int r = cell[1], c = cell[2];
                if(cell[0] == (1 <<totalKeys) -1) return steps;
                
                for(int i = 0; i < 4; i++) {
                    int nRow = r +rowMap[i];
                    int nCol = c +colMap[i];
                    int keys = cell[0];
                    
                    if(nRow < 0 || nRow >= M || nCol < 0 || nCol >= N) continue;
                    string visit = to_string(keys) +"_" +to_string(nRow) +"_" +to_string(nCol);
                    char ch = grid[nRow][nCol];
                    if(ch == '#') continue;
                    if(visited.find(visit) != visited.end()) continue;
                    if('a' <= ch && ch <= 'f') {
                        keys = keys | (1 <<(ch -'a'));
                    }
                    if('A' <= ch && ch <= 'F' && ((keys >>(ch -'A')) &1) == 0) continue;
                    if(!visited.count(to_string(keys) +"_" +to_string(nRow) +"_" +to_string(nCol))) {
                        helperQueue.push({keys, nRow, nCol});
                        visited.insert(to_string(keys) +"_" +to_string(nRow) +"_" +to_string(nCol));
                    }
                }
            }
            steps++;
        }
        return -1;
    }
};