class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<int> distance(n, INT_MAX);
        queue<pair<int, int>> q;
        q.push({src, 0});
        distance[src] = 0;
        auto level = 0;
        while(!q.empty() && level <= k) {
            auto sz = q.size();
            while(sz--) {
                auto curNode = q.front().first;
                auto curDis = q.front().second;
                q.pop();
                for(int i = 0; i < flights.size(); i++) {
                    auto node = flights[i][0];
                    auto destNode = flights[i][1];
                    auto cost = flights[i][2];
                    if(node == curNode && distance[destNode] > curDis+cost) {
                        distance[destNode] = curDis+cost;
                        q.push({destNode, distance[destNode]});
                    }
                }
            }
            level++;
        }
        return distance[dst] == INT_MAX ? -1 : distance[dst];
    }
};