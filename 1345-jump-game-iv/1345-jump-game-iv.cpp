class Solution {
public:
    int minJumps(vector<int>& arr) {
        const int N = arr.size();
        
        unordered_map<int, vector<int>> numToIdxMap;
        for(int i = 0; i < N; i++) numToIdxMap[arr[i]].push_back(i);
        
        //BFS
        queue<int> helperQueue;
        vector<bool> visited(N, false);
        //initialize
        helperQueue.push(0);
        visited[0] = true;
        int level = 0;
        
        while(!helperQueue.empty()) {
            int sz = helperQueue.size();
            while(sz--) {
                int currIdx = helperQueue.front();
                if(currIdx == N -1) return level;
                helperQueue.pop();
                
                //go prev
                if(currIdx -1 >= 0 && !visited[currIdx -1]) {
                    helperQueue.push(currIdx -1);
                    visited[currIdx -1] = true;
                }
                
                //go next
                if(currIdx +1 >= 0 && !visited[currIdx +1]) {
                    helperQueue.push(currIdx +1);
                    visited[currIdx +1] = true;
                }
                
                //go to arr[i] = arr[j]
                
                for(int idx :numToIdxMap[arr[currIdx]]) {
                    if(idx >= 0 && !visited[idx]) {
                        helperQueue.push(idx);
                        visited[idx] = true;
                    }
                }
                numToIdxMap[arr[currIdx]].clear();
            }
            level++;
        }
        
        return -1;
    }
};