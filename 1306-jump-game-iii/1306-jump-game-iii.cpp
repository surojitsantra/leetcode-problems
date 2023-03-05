class Solution {
public:
    bool canReach(vector<int>& arr, int start) {
        const int N = arr.size();
        
        //DFS
        return DFS(arr, start, N);
    }
    
private:
    bool DFS(vector<int>& arr, int nodeIdx, const int N) {
        if(nodeIdx < 0 || nodeIdx >= N || arr[nodeIdx] == -1) return false;
        if(arr[nodeIdx] == 0) return true;
        
        int x = arr[nodeIdx];
        arr[nodeIdx] = -1;
        
        return(DFS(arr, nodeIdx -x, N) || DFS(arr, nodeIdx +x, N));        
    }
};