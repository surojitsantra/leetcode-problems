class Solution {
public:
    bool canReach(vector<int>& arr, int start) {
        const int N = arr.size();
        
        //DFS
        vector<bool> visited(N, false);
        return DFS(arr, start, N, visited);
    }
    
private:
    bool DFS(vector<int>& arr, int nodeIdx, const int N, vector<bool>& visited) {
        if(arr[nodeIdx] == 0) return true;
        visited[nodeIdx] = true;
        
        bool leftSide = false;
        if(nodeIdx -arr[nodeIdx] >= 0 && !visited[nodeIdx -arr[nodeIdx]]) leftSide = DFS(arr, nodeIdx -arr[nodeIdx], N, visited);
        
        bool rightSide = false;
        if(nodeIdx +arr[nodeIdx] < N && !visited[nodeIdx +arr[nodeIdx]]) rightSide = DFS(arr, nodeIdx +arr[nodeIdx], N, visited);
        
        return(leftSide || rightSide);        
    }
};