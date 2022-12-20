class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        const int N = rooms.size();
        
        vector<bool> visited(N, false);
        
        queue<int> helperQueue;
        helperQueue.push(0);
        
        while(!helperQueue.empty()) {
            int curRoom = helperQueue.front();
            helperQueue.pop();
            
            if(visited[curRoom]) continue;
            
            visited[curRoom] = true;
            
            for(int key :rooms[curRoom])
                helperQueue.push(key);
        }
        
        for(bool visit :visited) {
            if(!visit) return false;
        }
        
        return true;
    }
};