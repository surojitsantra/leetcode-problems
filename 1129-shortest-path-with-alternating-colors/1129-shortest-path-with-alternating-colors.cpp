class Edge {
    public:
    int vertex;
    int isRed;
    
    Edge(int vertex, int isRed) {
        this->vertex = vertex;
        this->isRed = isRed;
    }
};

class Solution {
public:
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>>& redEdges, vector<vector<int>>& blueEdges) {
        vector<vector<Edge>> adjMatrix(n);
        
        for(auto& edge :redEdges) {
            int u = edge[0], v = edge[1];
            adjMatrix[u].push_back(Edge(v, true));
        }
        for(auto& edge :blueEdges) {
            int u = edge[0], v = edge[1];
            adjMatrix[u].push_back(Edge(v, false));
        }
        
        vector<int> ans(n, INT_MAX);
        
        //bfs        
        //starting with Red
        bfs(adjMatrix, 0, n, ans);
        
        //starting with Blue
        bfs(adjMatrix, 1, n, ans);
        
        for(int i = 0; i < n; i++) {
            if(ans[i] == INT_MAX) ans[i] = -1;
        }
        
        return ans;
    }
    
    
    void bfs(vector<vector<Edge>>& adjMatrix, int isRed, int n, vector<int>& ans) {
        
        vector<vector<bool>> visited(n, vector(2, false));
        queue<int> helperQueue;
        helperQueue.push(0);
        visited[0][isRed] = true;
        int level = 0;
        
        while(!helperQueue.empty()) {
            int sz = helperQueue.size();
            while(sz--) {
                int src = helperQueue.front();
                helperQueue.pop();
                ans[src] = min(ans[src], level);
                // cout<<src<<" ";
                
                for(auto& edge :adjMatrix[src]) {
                    int des = edge.vertex;
                    int edgeColor = edge.isRed;

                    if(!visited[des][edgeColor] && edgeColor != isRed) {
                        visited[des][edgeColor] = true;
                        helperQueue.push(des);
                        
                        //cout<<des<<" ";
                    }
                }
            }
            level++;
            isRed = !isRed;
        }
    }
};